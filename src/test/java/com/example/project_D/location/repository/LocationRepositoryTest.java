package com.example.project_D.location.repository;

import com.example.project_D.location.entity.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationRepositoryTest {

    @Autowired LocationRepository repository;

    @Test
    @DisplayName("새로운 지역을 등록했을 때 성공해야 한다.")
    void saveTest() {
        // given
        Location newLoc = new Location("Gyeonggi","경기");

        // when
        boolean flag = repository.save(newLoc);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("지역목록을 조회했을때 목록의 개수가 5개여야 한다.")
    void findAllTest() {
        // given

        // when
        List<Location> locList = repository.findAll();

        // then
        assertEquals(5, locList.size());
        assertNotNull(locList);
    }

    @Test
    @DisplayName("아이디 Seoul을 검색했을때 이름은 서울이여야 한다.")
    void findOneTest() {
        // given
        String LocationID = "Seoul";

        // when
        Location location = repository.findOne(LocationID);

        // then
        assertEquals("서울", location.getLocationNm());
    }

    @Test
    @DisplayName("특정 지역 데이터를 수정해야 한다.")
    void modifyTest() {
        // given
        Location location = new Location();
        location.setLocationNm("경기");
        location.setLocationID("Gyeonggi");

        // when
        boolean flag = repository.modify(location);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("Gyeonggi를 삭제한 후 다시 조회했을때 null이 나와야 한다.")
    void removeTest() {
        // given
        String LocationID = "Gyeonggi";

        // when
        boolean flag = repository.remove(LocationID);
        Location location = repository.findOne(LocationID);

        // then
        assertTrue(flag);
        assertNull(location);
        assertEquals(1, repository.findAll().size());
    }

}