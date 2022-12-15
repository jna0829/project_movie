package com.example.project_D.movie.api;

import com.example.project_D.movie.entity.Movie;
import com.example.project_D.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/movie")
public class MovieController {

    private MovieService service;

    @GetMapping
    public ResponseEntity<?> movies(){
        log.info("/api/movie GET request!");
        return ResponseEntity.ok().body(service.listAllServ());
    }


}
