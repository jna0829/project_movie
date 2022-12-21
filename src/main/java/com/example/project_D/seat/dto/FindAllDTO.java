package com.example.project_D.seat.dto;

import com.example.project_D.seat.entity.Seat;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count;
    private List<SeatDTO> seats;

    public FindAllDTO(List<Seat> SeatList) {
        this.count = SeatList.size();
        this.convertDTOList(SeatList);
    }

    public void convertDTOList(List<Seat> SeatList) {
        List<SeatDTO> dto = new ArrayList<>();
        for (Seat seat : SeatList) {
            dto.add(new SeatDTO(seat));
        }
        this.seats = dto;
    }

}