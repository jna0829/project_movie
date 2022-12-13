package com.example.project_D.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Setter @Getter @ToString
@AllArgsConstructor
public class Movie {

    private String movieCd; //영화 코드번호
    private String movieNm; //영화 타이틀
    private String directors; //감독
    private String actors; //주연배우
    private String showTm; //상영시간
    private String openDt; //상영일

    public Movie() {
        this.movieCd = getMovieCd();
        this.movieNm = getMovieNm();
        this.directors = getDirectors();
        this.actors = getActors();
        this.showTm = getShowTm();
        this.openDt = getOpenDt();
    }

}
