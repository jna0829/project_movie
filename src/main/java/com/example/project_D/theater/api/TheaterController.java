package com.example.project_D.theater.api;

import com.example.project_D.theater.dto.FindAllDTO;
import com.example.project_D.theater.dto.TheaterDTO;
import com.example.project_D.theater.entity.Theater;
import com.example.project_D.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/theater")
@RequiredArgsConstructor
@CrossOrigin
public class TheaterController {

    private final TheaterService service;

    // 지역별 지점 전체조회 요청
    @GetMapping("/{locationId}")
    public ResponseEntity<?> theater(@PathVariable String locationId) {
        log.info("/api/theater/{locationId} GET request! - {}",  locationId);
        return ResponseEntity.ok().body(service.findAllServ(locationId));
    }

    // 지점 개별조회 요청
    @GetMapping("/{locationId}/{theaterId}")
    public ResponseEntity<?> findOne(@PathVariable String locationId,
                                     @PathVariable String theaterId) {
        log.info("/api/theater/{}/{} GET request!", locationId, theaterId);

        if (theaterId == null) return ResponseEntity.badRequest().build();

        TheaterDTO dto = service.findOneServ(theaterId);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    // 지점 등록 요청
    @PostMapping("/{locationId}")
    public ResponseEntity<?> create(@RequestBody Theater newTheater,
                                    @PathVariable String locationID) {
        newTheater.setLocationID(locationID);
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
    @PutMapping("/{locationId}")
    public ResponseEntity<?> delete(@RequestBody Theater theater,
                                    @PathVariable String locationID) {
        theater.setLocationID(locationID);
        log.info("/api/theater PUT request! - {}", theater);

        try {
            FindAllDTO dto = service.update(theater);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 지점 삭제 기능
    @DeleteMapping("/{locationId}/{theaterId}")
    public ResponseEntity<?> delete(@PathVariable String locationId,
                                    @PathVariable String theaterId) {
        log.info("/api/theater/{}/{} DELETE request!", locationId, theaterId);

        try {
            FindAllDTO dto = service.deleteServ(locationId, theaterId);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
