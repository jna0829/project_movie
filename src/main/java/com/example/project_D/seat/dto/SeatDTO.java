package com.example.project_D.seat.dto;

import com.example.project_D.seat.entity.Seat;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {

    private String SeatID;
    private String SeatNum;
    private String SeatState;

    public SeatDTO(Seat seat) {
        this.SeatNum = seat.getSeatNum();
        this.SeatState = seat.getSeatState();
    }

}