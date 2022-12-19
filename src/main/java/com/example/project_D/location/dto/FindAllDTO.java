package com.example.project_D.location.dto;

import com.example.project_D.location.entity.Location;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count; // 지역의 개수
    private List<LocationDTO> locDTOList; // 지역 목록

    public FindAllDTO(List<Location> locList) {
        this.count = locList.size();
        this.convertDTOList(locList);
    }

    // List<Location>를 받으면 List<LocationDTO>로 변환하는 메서드
    public void convertDTOList(List<Location> locList) {
        List<LocationDTO> dtos = new ArrayList<>();

        for (Location loc : locList) {
            dtos.add(new LocationDTO(loc));
        }
        this.locDTOList = dtos;
    }



}
