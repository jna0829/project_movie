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
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public ListAllDTO listAllServ(){

        List<Movie> movieList = repository.listAll();

        ListAllDTO listAllDTO = new ListAllDTO(movieList);

        return listAllDTO;
    }



}
