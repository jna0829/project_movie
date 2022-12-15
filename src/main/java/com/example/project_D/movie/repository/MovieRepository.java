package com.example.project_D.movie.repository;

import com.example.project_D.movie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieRepository {

    // 영화정보 조회하는 기능
    List<Movie> listAll();

    // 영화코드를 통해서 개별 영화정보 조회하기
    Movie findOne(String movieCd);

    // 영화정보 추가하는 기능
    boolean add(Movie movie);

    // 영화정보 수정하는 기능
    boolean modify(Movie movie);

    // 영화정보 삭제하는 기능
    boolean remove(String movieCd);

}
