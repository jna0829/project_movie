package com.example.project_D.movie.repository;

import com.example.project_D.movie.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired MovieRepository repository;

    @Test
    @DisplayName("영화 리스트가 조회되어야 한다.")
    void listAllTest(){
        // given (테스트 시 필요한 데이터)

        // when (테스트의 실제 상황)
        List<Movie> movieList = repository.listAll();

        // then (테스트 결과 / 단언)
        assertNotNull(movieList);
    }

    @Test
    @DisplayName("영화코드가 20227762 일때 영화제목이 올빼미여야 한다.")
    void findOneTest(){
        //given
        String movieCd = "20227762";

        //when
        Movie movie = repository.findOne(movieCd);

        //then
        assertEquals("올빼미", movie.getMovieNm());

    }

    @Test
    @DisplayName("새로운 영화를 등록했을때 등록을 성공해야 한다.")
    void  addTest(){
        // given
        Movie newMovie = new Movie("20228313", "오늘 밤, 세계에서 이 사랑이 사라진다 해도", "미키 타카히로", "미치에다 슌스케","121","2022-11-30");

        // when
        boolean flag = repository.add(newMovie);
        List<Movie> movieList = repository.listAll();

        // then
        assertTrue(flag);
    }



}
