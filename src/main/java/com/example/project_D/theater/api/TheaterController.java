package com.example.project_D.theater.api;

import com.example.project_D.theater.dto.FindAllDTO;
import com.example.project_D.theater.dto.TheaterDTO;
import com.example.project_D.theater.entity.Theater;
import com.example.project_D.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/theater")
@RequiredArgsConstructor
@CrossOrigin
public class TheaterController {

    private final TheaterService service;

    // 지점 전체조회 요청
    @GetMapping
    public ResponseEntity<?> theater(String LocationID) {
        log.info("/api/theater GET request!");
        return ResponseEntity.ok().body(service.findAllServ(LocationID));
    }

    // 지점 개별조회 요청
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(String id) {
        log.info("/api/theater/{} GET request!", id);

        if (id == null) return ResponseEntity.badRequest().build();

        TheaterDTO dto = service.findOneServ(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    // 지점 등록 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Theater newTheater,
                                    String LocationID) {
        newTheater.setLocationID(LocationID);
        log.info("/api/theater POST request! - {}", newTheater);

        try {
            FindAllDTO dto = service.createServ(newTheater);

            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 지점 수정 기능
    @PutMapping
    public ResponseEntity<?> delete(@RequestBody Theater theater,
                                    String LocationID) {
        theater.setLocationID(LocationID);
        log.info("/api/theater PUT request! - {}", theater);

        try {
            FindAllDTO dto = service.update(theater);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 지점 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id,
                                    String LocationID) {
        log.info("/api/theater/{} DELETE request!", id);

        try {
            FindAllDTO dto = service.deleteServ(id, LocationID);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
