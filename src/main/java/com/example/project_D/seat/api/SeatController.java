package com.example.project_D.seat.api;

import com.example.project_D.seat.dto.FindAllDTO;
import com.example.project_D.seat.dto.SeatDTO;
import com.example.project_D.seat.entity.Seat;
import com.example.project_D.seat.service.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/seat")
@RequiredArgsConstructor
@CrossOrigin
public class SeatController {

    private final SeatService service;

    @GetMapping
    public ResponseEntity<?> seat(String ScreenID) {
        log.info("/api/seat GET request!");
        return ResponseEntity.ok().body(service.findAllServ(ScreenID));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable String id) {
        log.info("/api/seat/{} GET request!", id);
        if (id == null) return ResponseEntity.badRequest().build();
        SeatDTO dto = service.findOneServ(id);

        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<?> create(Seat newSeat,
                                    String ScreenID) {
        newSeat.setScreenID(ScreenID);
        log.info("/api/seat POST request! - {}", ScreenID);

        try {
            FindAllDTO dto = service.createServ(newSeat);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> delete(@RequestBody Seat seat,
                                    String ScreenID) {
        seat.setScreenID(ScreenID);
        log.info("/api/seat PUT request! - {}", seat);

        try {
            FindAllDTO dto = service.update(seat);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id,
                                    String ScreenID) {
        log.info("/api/seat/{} DELETE request!", id);
        try {
            FindAllDTO dto = service.deleteServ(id, ScreenID);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}