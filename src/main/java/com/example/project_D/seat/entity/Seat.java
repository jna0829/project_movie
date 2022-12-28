package com.example.project_D.seat.entity;

import lombok.*;

import java.util.UUID;

@Setter @Getter @ToString
@AllArgsConstructor
public class Seat {

    private String SeatID; // 좌석 ID
    private String SeatNum; // 좌석번호
    private String SeatState; // 좌석상태(default- 0, 예약완료-1)
    private String ScreenID; //영화관 코드(fk)

}