package com.example.project_D.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
public class Cinema {
    private String local; // 극장 지역
    private String cinemaPlace; // 극장 위치(지점)
    private String cinemaAddress; // 극장 주소

    public Cinema() {}

}
