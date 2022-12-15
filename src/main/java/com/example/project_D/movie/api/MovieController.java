package com.example.project_D.movie.api;

import com.example.project_D.movie.dto.ListAllDTO;
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

    @GetMapping("/{movieCd}")
    public ResponseEntity<?> findOne(@PathVariable String movieCd){
        log.info("/movie/{} GET request!", movieCd);

        if (movieCd == null) return  ResponseEntity.badRequest().build();

        ListAllDTO dto = service.findOneServ(movieCd);

        if (dto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dto);
    }


}
