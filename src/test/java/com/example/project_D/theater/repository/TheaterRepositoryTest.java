package com.example.project_D.theater.repository;

import com.example.project_D.theater.entity.Theater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TheaterRepositoryTest {

    @Autowired TheaterRepository repository;

    @Test
    @DisplayName("새로운 지점을 등록했을 때 성공해야 한다.")
    void saveTest() {
        // given
        Theater newTheater = new Theater("1-1", "강변", "서울특별시 광진구", "1234-1111", "Seoul");

        // when
        boolean flag = repository.save(newTheater);
        List<Theater> theaterList = repository.findAll(newTheater.getLocationID());

        // then
        assertTrue(flag);
        assertEquals(1, theaterList.size());
    }

    @Test
    @DisplayName("서울지역을 조회했을때 지점의 개수가 2개여야 한다.")
    void findAllTest() {
        // given
        String LocationID = "Seoul";

        // when
        List<Theater> theaterList = repository.findAll(LocationID);

        // then
        assertEquals(2, theaterList.size());

        for (Theater theater : theaterList) {
            System.out.println("theater = " + theater);
        }
    }

    @Test
    @DisplayName("아이디 1-1을 조회했을때 지점이름은 강변이여야 한다.")
    void findOneTest() {
        // given
        String TheaterID = "1-1";

        // when
        Theater theater = repository.findOne(TheaterID);

        // then
        assertEquals("강변", theater.getTheaterNm());
    }

    @Test
    @DisplayName("아이디 1-1을 홍대 지점으로 수정해야 한다.")
    void modifyTest() {
        // given
        Theater theater = new Theater();
        theater.setTheaterID("1-1");
        theater.setTheaterNm("홍대");
        theater.setAddress("서울특별시 마포구");
        theater.setTell("1234-1112");

        // when
        boolean flag = repository.modify(theater);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디 1-1을 삭제한 후 다시 조회했을때 null이 나와야 한다.")
    void removeTest() {
        // given
        String TheaterID = "1-1";

        // when
        boolean flag = repository.remove(TheaterID);
        Theater theater = repository.findOne(TheaterID);

        // then
        assertTrue(flag);
        assertNull(theater);
    }

}