package com.example.project_D.theater.repository;

import com.example.project_D.theater.entity.Theater;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TheaterRepository {

    // 지점 생성 기능
    boolean save(Theater theater);

    // 지점 전체조회 기능
    List<Theater> findAll(String locationID);

    // 지점 개별조회 기능
    Theater findOne(String id);

    // 지점 수정 기능
    boolean modify(Theater theater);

    // 지점 삭제 기능
    boolean remove(String id);

}