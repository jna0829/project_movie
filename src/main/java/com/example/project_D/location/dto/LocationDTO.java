package com.example.project_D.location.dto;

import com.example.project_D.location.entity.Location;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private String LocationID; // 지역 ID
    private String LocationNm; // 지역 이름

    public LocationDTO(Location location){
        this.LocationID = location.getLocationID();
        this.LocationNm = location.getLocationNm();
    }

}
