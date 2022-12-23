package com.example.project_D.screen.dto;

import com.example.project_D.screen.entity.Screen;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDTO {

    private String ScreenID; // 영화관 ID
    private String ScreenCD; // 영화관 ID
    private String ScreenNm; // 영화관 이름
    private int ScreenSeat; // 영화관 좌석수
    private String TheaterID; //지점 ID(fk)

    public ScreenDTO(Screen screen) {
        this.ScreenID = screen.getScreenID();
        this.ScreenCD = screen.getScreenCD();
        this.ScreenNm = screen.getScreenNm();
        this.ScreenSeat = screen.getScreenSeat();
        this.TheaterID = screen.getTheaterID();
    }

}