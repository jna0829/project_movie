package com.example.project_D.location.repository;

import com.example.project_D.location.entity.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationRepository {

    // 지역 전체 조회
    List<Location> findAll();

    // 지역 개별 조회
    Location findOne(String id);

    // 지역 추가
    boolean save(Location location);

    // 지역 수정
    boolean modify(Location location);

    // 지역 삭제
    boolean remove(String id);

}