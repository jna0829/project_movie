package com.example.project_D.local.repository;

import com.example.project_D.local.dto.LocalDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocalRepository {

    // 지역 데이터 전체 조회 기능
    List<LocalDTO> findAll();


}
