package com.example.project_D.theater.dto;

import com.example.project_D.theater.entity.Theater;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDTO {

    private String TheaterID; // 지점 ID
    private String TheaterNm; // 지점 이름
    private String Address; // 주소
    private String Tell; // 전화번호
    private String LocationID; //지역 ID(fk)

    public TheaterDTO(Theater theater) {
        this.TheaterID = theater.getTheaterID();
        this.TheaterNm = theater.getTheaterNm();
        this.Address = theater.getAddress();
        this.Tell = theater.getTell();
        this.LocationID = theater.getLocationID();
    }

}