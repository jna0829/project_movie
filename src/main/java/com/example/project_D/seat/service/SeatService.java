package com.example.project_D.seat.service;

import com.example.project_D.seat.dto.FindAllDTO;
import com.example.project_D.seat.dto.SeatDTO;
import com.example.project_D.seat.entity.Seat;
import com.example.project_D.seat.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository repository;

    public FindAllDTO findAllServ(String ScreenID) {
        return new FindAllDTO(repository.findAll(ScreenID));
    }

    public SeatDTO findOneServ(String id) {
        Seat seat = repository.findOne(id);
        log.info("findOneServ return data - {}", seat);
        return seat != null ? new SeatDTO(seat) : null;
    }

    public FindAllDTO createServ(final Seat newSeat) {
        if (newSeat == null) {
            log.warn("newSeat cannot be null!");
            throw  new RuntimeException("newSeat cannot be null!");
        }

        boolean flag = repository.save(newSeat);
        if (flag) log.info("새로운 좌석 [Id: {}]이 저장되었습니다.", newSeat.getSeatID());
        return flag ? findAllServ(newSeat.getScreenID()) : null;
    }

    public FindAllDTO update(Seat seat) {
        boolean flag = repository.modify(seat);
        return flag ? findAllServ(seat.getScreenID()) : new FindAllDTO();
    }

    public FindAllDTO deleteServ(String id, String ScreenID) {
        boolean flag = repository.remove(id);

        if (!flag) {
            log.warn("delete fail!! not found id [{}]", id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ(ScreenID);
    }

}