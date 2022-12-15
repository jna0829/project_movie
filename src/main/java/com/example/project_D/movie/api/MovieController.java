package com.example.project_D.movie.api;

import com.example.project_D.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/movie")
@RequiredArgsConstructor
@CrossOrigin
public class MovieController {

    private final MovieService service;

    @GetMapping
    public ResponseEntity<?> movies(){
        log.info("/movie GET request!");
        return ResponseEntity.ok().body(service.listAllServ());
    }


}
