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

    @GetMapping("/{theaterId}")
    public ResponseEntity<?> screen(@PathVariable String theaterId) {
        log.info("/api/screen/{theaterId} GET request! - {}",  theaterId);
        return ResponseEntity.ok().body(service.findAllServ(theaterId));
    }

    @GetMapping("/{theaterId}/{screenID}")
    public ResponseEntity<?> findOne(@PathVariable String theaterId,
                                     @PathVariable String screenID) {
        log.info("/api/screen/{}/{} GET request!", theaterId, screenID);
        if (screenID == null) return ResponseEntity.badRequest().build();

        ScreenDTO dto = service.findOneServ(screenID);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/{theaterId}")
    public ResponseEntity<?> create(@RequestBody Screen newScreen,
                                    @PathVariable String theaterId) {
        newScreen.setTheaterID(theaterId);
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

    @PutMapping("/{theaterId}")
    public ResponseEntity<?> delete(@RequestBody Screen screen,
                                    @PathVariable String theaterId) {
        screen.setTheaterID(theaterId);
        log.info("/api/screen PUT request! - {}", screen);

        try {
            FindAllDTO dto = service.update(screen);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{theaterId}/{screenId}")
    public ResponseEntity<?> delete(@PathVariable String theaterId,
                                    @PathVariable String screenId) {
        log.info("/api/screen/{}/{} DELETE request!", theaterId, screenId);

        try {
            FindAllDTO dto = service.deleteServ(theaterId, screenId);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}