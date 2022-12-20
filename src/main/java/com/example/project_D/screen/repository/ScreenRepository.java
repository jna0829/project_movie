package com.example.project_D.screen.repository;

import com.example.project_D.screen.entity.Screen;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScreenRepository {

    // 영화관 생성 기능
    boolean save(Screen screen);

    // 영화관 전체 조회
    List<Screen> findAll(String TheaterID);

    // 영화관 개별 조회
    Screen findOne(String id);

    // 영화관 수정 기능
    boolean modify(Screen screen);

    // 영화관 삭제 기능
    boolean remove(String id);

}