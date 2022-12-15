package com.example.project_D.movie.service;

import com.example.project_D.movie.dto.ListAllDTO;
import com.example.project_D.movie.entity.Movie;
import com.example.project_D.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    // 영화 목록 전체 보기
    public ListAllDTO listAllServ(){

        return new ListAllDTO(repository.listAll());
    }

    // 영화 개별 정보 보기
    public ListAllDTO findOneServ(String movieCd) {

        Movie movie = repository.findOne(movieCd);
        log.info("findOneServ return data - {}", movie);


        return movie != null ? new ListAllDTO(movie) : null;
    }

    // 영화 정보 등록 하기
    public ListAllDTO addServ(Movie newMovie){

        if(newMovie == null){
            log.warn("newMovie cannot be null!");
            throw new RuntimeException("newMovie cannot be null!");
        }

        boolean flag = repository.add(newMovie);
        if (flag) log.info("새로운 영화정보 [MoveNm: {}]가 저장되었습니다.",newMovie.getMovieNm());

        return flag ? listAllServ() : null;
    }



}
