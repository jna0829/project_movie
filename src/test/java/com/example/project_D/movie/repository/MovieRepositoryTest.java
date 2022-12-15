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

}