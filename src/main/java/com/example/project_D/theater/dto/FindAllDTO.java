package com.example.project_D.theater.dto;

import com.example.project_D.theater.entity.Theater;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count;
    private List<TheaterDTO> theaters;

    public FindAllDTO(List<Theater> theaterList) {
        this.count = theaterList.size();
        this.convertDTOList(theaterList);
    }

    public void convertDTOList(List<Theater> theaterList) {
        List<TheaterDTO> dto = new ArrayList<>();

        for (Theater theater : theaterList) {
            dto.add(new TheaterDTO(theater));
        }
        this.theaters = dto;
    }

}