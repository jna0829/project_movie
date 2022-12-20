package com.example.project_D.screen.api;

import com.example.project_D.screen.dto.FindAllDTO;
import com.example.project_D.screen.dto.ScreenDTO;
import com.example.project_D.screen.entity.Screen;
import com.example.project_D.screen.service.ScreenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/screen")
@RequiredArgsConstructor
@CrossOrigin
public class ScreenController {

    private final ScreenService service;

    @GetMapping
    public ResponseEntity<?> screen(String TheaterID) {
        log.info("/api/screen GET request!");
        return ResponseEntity.ok().body(service.findAllServ(TheaterID));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable String id) {
        log.info("/api/screen/{} GET request!", id);
        if (id == null) return ResponseEntity.badRequest().build();

        ScreenDTO dto = service.findOneServ(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Screen newScreen,
                                    String TheaterID) {
        newScreen.setTheaterID(TheaterID);
        log.info("/api/screen POST request! - {}", newScreen);

        try {
            FindAllDTO dto = service.createServ(newScreen);

            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> delete(@RequestBody Screen screen,
                                    String TheaterID) {
        screen.setTheaterID(TheaterID);
        log.info("/api/screen PUT request! - {}", screen);

        try {
            FindAllDTO dto = service.update(screen);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id,
                                    String TheaterID) {
        log.info("/api/screen/{} DELETE request!", id);

        try {
            FindAllDTO dto = service.deleteServ(id, TheaterID);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}