package com.example.project_D.movie.api;

import com.example.project_D.movie.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    @GetMapping("/movie-list")
    public List<Movie> movieList() {
        return Arrays.asList(
                new Movie("20227762", "올빼미", "안태진", "류준열","118","2022-11-23"),
                new Movie("20205106", "압꾸정", "임진순", "마동석","111","2022-11-30"),
                new Movie("20228313", "오늘 밤, 세계에서 이 사랑이 사라진다 해도", "미키 타카히로", "미치에다 슌스케","121","2022-11-30"),
                new Movie("20210364", "탄생", "박흥식", "윤시윤","150","2022-11-30"),
                new Movie("20228308", "극장판 뽀로로와 친구들: 바이러스를 없애줘!", "박영균", "이선","62","2022-12-01"),
                new Movie("20227885", "프레이 포 더 데블", "다니엘 스탬", "콜린 살몬","93","2022-12-07"),
                new Movie("20227445", "원피스 필름 레드", "타니구치 고로", "타나카 마유미","115","2022-11-30"),
                new Movie("20228640", "신비아파트 극장판 차원도깨비와 7개의 세계", "변영규", "김영은","103","2022-12-14"),
                new Movie("20226254", "블랙 팬서: 와칸다 포에버", "라이언 쿠글러", "레티티아 라이트","161","2022-11-09"),
                new Movie("20217905", "데시벨", "황인호", "김래원","109","2022-11-16")
        );
    }

}
