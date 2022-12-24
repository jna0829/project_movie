package com.example.project_D.theater.service;

import com.example.project_D.theater.dto.FindAllDTO;
import com.example.project_D.theater.dto.TheaterDTO;
import com.example.project_D.theater.entity.Theater;
import com.example.project_D.theater.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository repository;

    // 지점 전체조회 기능
    public FindAllDTO findAllServ(String LocationID) {
        return new FindAllDTO(repository.findAll(LocationID));
    }

    // 지점 생성 기능
    public FindAllDTO createServ(final Theater newTheater) {
        if (newTheater == null) {
            log.warn("newTheater cannot be null");
            throw new RuntimeException("newTheater cannot be null!");
        }

        boolean flag = repository.save(newTheater);
        if (flag) log.info("새로운 지점 [id: {}]이 저장되었습니다.", newTheater.getTheaterID());

        return flag ? findAllServ(newTheater.getLocationID()) : null;
    }

    // 지점 개별조회 기능
    public TheaterDTO findOneServ(String id) {
        Theater theater = repository.findOne(id);
        log.info("findOneServ return data - {}", theater);

        return theater != null ? new TheaterDTO(theater) : null;
    }

    // 지점 수정 기능
    public FindAllDTO update(Theater theater) {
        boolean flag = repository.modify(theater);

        return flag ? findAllServ(theater.getLocationID()) : new FindAllDTO();
    }

    // 지점 삭제 기능
    public FindAllDTO deleteServ(String id, String LocationID) {
        boolean flag = repository.remove(id);

        if (!flag) {
            log.warn("delete fail!! not found id [{}]", id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ(LocationID);
    }

}