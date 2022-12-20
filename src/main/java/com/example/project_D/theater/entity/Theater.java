package com.example.project_D.theater.entity;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    private String TheaterID; // 지점 ID
    private String TheaterNm; // 지점 이름
    private String Address; // 주소
    private String Tell; // 전화번호
    private String LocationID; //지역 ID

}