package com.example.project_D.seat.repository;

import com.example.project_D.seat.entity.Seat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeatRepository {

    // 좌석 전체 조회
    List<Seat> findAll(String ScreenCD);

    // 좌석 개별 조회
    Seat findOne(String id);

    // 좌석 생성
    boolean save(Seat seat);

    // 좌석 수정
    boolean modify(Seat seat);

    // 좌석 삭제
    boolean remove(String id);

}