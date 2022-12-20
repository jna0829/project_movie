package com.example.project_D.screen.entity;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Screen {

    private String ScreenID; // 영화관 ID
    private String ScreenNm; // 영화관 이름
    private int ScreenSeat; // 영화관 좌석수
    private String TheaterID; //지점 ID(fk)

}