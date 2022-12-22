package com.example.project_D.seat.repository;

import com.example.project_D.seat.entity.Seat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeatRepositoryTest {

    @Autowired SeatRepository repository;

    @Test
    @DisplayName("새로운 좌석을 등록했을 때 성공해야 한다.")
    void saveTest() {
        // given
        Seat newSeat = new Seat();
        newSeat.setSeatNum("A2");
        newSeat.setSeatState("0");
        newSeat.setScreenCD("S1");

        // when
        boolean flag = repository.save(newSeat);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("1관을 조회했을때 좌석의 개수가 2개여야 한다.")
    void findAllTest() {
        // given
        String ScreenCD = "S1";

        // when
        List<Seat> seatList = repository.findAll(ScreenCD);

        // then
        assertEquals(2, seatList.size());
    }

    @Test
    @DisplayName("아이디를 조회했을때 좌석 이름은 A1이여야 한다.")
    void findOneTest() {
        // given
        String SeatID = "5d852acf-f806-4895-a9ea-76b1169eca9d";

        // when
        Seat seat = repository.findOne(SeatID);

        // then
        assertEquals("A1", seat.getSeatNum());
    }

    @Test
    @DisplayName("A1의 좌석상태를 1로 수정해야 한다.")
    void modifyTest() {
        // given
        Seat seat = new Seat();
        seat.setSeatID("5d852acf-f806-4895-a9ea-76b1169eca9d");
        seat.setSeatNum("A1");
        seat.setSeatState("1");
        seat.setScreenCD("S1");

        // when
        boolean flag = repository.modify(seat);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("A1의 아이디를 삭제한 후 다시 조회했을때 null이 나와야 한다.")
    void removeTest() {
        // given
        String SeatID = "5d852acf-f806-4895-a9ea-76b1169eca9d";

        // when
        boolean flag = repository.remove(SeatID);
        Seat seat = repository.findOne(SeatID);

        // then
        assertTrue(flag);
        assertNull(seat);
    }

}