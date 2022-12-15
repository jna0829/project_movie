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

        // then (테스트 결과 단언)
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
    @DisplayName("새로운 영화를 등록했을때 전체 목록의 개수가 1개여야 한다.")
    void  addTest(){
        // given (테스트 시 필요한 데이터)
        Movie newMovie = new Movie("20227762", "올빼미", "안태진", "류준열","118","2022-11-23");

        // when (테스트의 실제 상황)
        boolean flag = repository.add(newMovie);
        List<Movie> movieList = repository.listAll();

        // then (테스트 결과 단언)
        assertTrue(flag);
        assertEquals(1,movieList.size());

    }



}
