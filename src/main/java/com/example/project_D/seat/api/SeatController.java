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

    @GetMapping("/{screenID}")
    public ResponseEntity<?> seat(@PathVariable String screenID) {
        log.info("/api/seat GET request! - {}", screenID);
        return ResponseEntity.ok().body(service.findAllServ(screenID));
    }

    @GetMapping("/{screenID}/{seatId}")
    public ResponseEntity<?> findOne(@PathVariable String screenID,
                                     @PathVariable String seatId) {
        log.info("/api/seat/{}/{} GET request!", screenID, seatId);
        if (seatId == null) return ResponseEntity.badRequest().build();
        SeatDTO dto = service.findOneServ(seatId);


        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/{screenID}")
    public ResponseEntity<?> create(@RequestBody Seat newSeat,
                                    @PathVariable String screenID) {
        newSeat.setScreenID(screenID);
        log.info("/api/seat POST request! - {}", screenID);

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

    @PutMapping("/{screenID}")
    public ResponseEntity<?> delete(@RequestBody Seat seat,
                                    @PathVariable String screenID) {
        seat.setScreenID(screenID);
        log.info("/api/seat PUT request! - {}", seat);

        try {
            FindAllDTO dto = service.update(seat);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{screenID}/{seatId}")
    public ResponseEntity<?> delete(@PathVariable String seatId,
                                    @PathVariable String screenID) {
        log.info("/api/seat/{}/{} DELETE request!", screenID, seatId);
        try {
            FindAllDTO dto = service.deleteServ(screenID, seatId);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}