package com.example.project_D.location.api;

import com.example.project_D.location.dto.FindAllDTO;
import com.example.project_D.location.dto.LocationDTO;
import com.example.project_D.location.entity.Location;
import com.example.project_D.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/location")
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {

    private final LocationService service;

    // 지역 전체 조회 요청
    @GetMapping
    public ResponseEntity<?> location() {
        log.info("/api/location GET request!");
        return ResponseEntity.ok().body(service.findAllServ());
    }

    // 지역 개별 조회 요청
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable String id) {
        log.info("/api/location/{} GET request!", id);

        if (id == null) return ResponseEntity.badRequest().build();

        LocationDTO dto = service.findOneServ(id);
        if (dto == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dto);
    }

    // 지역 추가 요청
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Location newLoc) {

        try {
            FindAllDTO dto = service.createServ(newLoc);

            log.info("/api/location POST request! - {}", newLoc);

            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    // 지역 수정 요청
    @PutMapping
    public ResponseEntity<?> delete(@RequestBody Location location) {
        log.info("/api/location PUT request! - {}", location);

        try {
            FindAllDTO dtos = service.update(location);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 지역 삭제 요청
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        log.info("/api/location/{} DELETE request!", id);

        try {
            FindAllDTO dtos = service.deleteServ(id);
            return ResponseEntity.ok().body(dtos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
