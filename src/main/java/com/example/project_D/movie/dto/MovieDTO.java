package com.example.project_D.movie.dto;

import com.example.project_D.movie.entity.Movie;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private String movieCd;
    private String movieNm;
    private String directors;
    private String actors;
    private String showTm;
    private String openDt;

    public MovieDTO(Movie movie){
        this.movieCd = movie.getMovieCd();
        this.movieNm = movie.getMovieNm();
        this.directors = movie.getDirectors();
        this.actors = movie.getActors();
        this.showTm = movie.getShowTm();
        this.openDt = movie.getOpenDt();
    }

}
