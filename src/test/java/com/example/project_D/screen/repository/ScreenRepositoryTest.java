package com.example.project_D.screen.repository;

import com.example.project_D.screen.entity.Screen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScreenRepositoryTest {

    @Autowired ScreenRepository repository;

    @Test
    @DisplayName("새로운 영화관을 등록했을 때 성공해야 한다.")
    void saveTest() {
        // given
        Screen newScreen = new Screen("a-2", "A관", 150, "1-1");

        // when
        boolean flag = repository.save(newScreen);
        List<Screen> screenList = repository.findAll(newScreen.getTheaterID());

        // then
        assertTrue(flag);
        assertEquals(2, screenList.size());
    }

    @Test
    @DisplayName("강변지점 아이디를 조회했을때 영화관의 개수가 2개여야 한다.")
    void findAllTest() {
        // given
        String TheaterID = "1-1";

        // when
        List<Screen> screenList = repository.findAll(TheaterID);

        // then
        assertEquals(2, screenList.size());
    }

    @Test
    @DisplayName("아이디 a-1을 조회했을때 영화관 이름은 A관 이여야 한다.")
    void findOneTest() {
        // given
        String ScreenID = "a-1";

        // when
        Screen screen = repository.findOne(ScreenID);

        // then
        assertEquals("A관", screen.getScreenNm());
    }

    @Test
    @DisplayName("아이디 a-1의 좌석수를 300으로 수정해야 한다.")
    void modifyTest() {
        // given
        Screen screen = new Screen();
        screen.setScreenID("a-1");
        screen.setScreenNm("A관");
        screen.setScreenSeat(300);

        // when
        boolean flag = repository.modify(screen);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("아이디 a-2을 삭제한 후 다시 조회했을때 null이 나와야 한다.")
    void removeTest() {
        // given
        String ScreenID = "a-2";

        // when
        boolean flag = repository.remove(ScreenID);
        Screen screen = repository.findOne(ScreenID);

        // then
        assertTrue(flag);
        assertNull(screen);
    }

}