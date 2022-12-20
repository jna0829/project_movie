package com.example.project_D.screen.service;

import com.example.project_D.screen.dto.FindAllDTO;
import com.example.project_D.screen.dto.ScreenDTO;
import com.example.project_D.screen.entity.Screen;
import com.example.project_D.screen.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository repository;

    public FindAllDTO findAllServ(String TheaterID) {
        return new FindAllDTO(repository.findAll(TheaterID));
    }

    public ScreenDTO findOneServ(String id) {
        Screen screen = repository.findOne(id);
        log.info("findOneServ return data - {}", screen);

        return screen != null ? new ScreenDTO(screen) : null;
    }

    public FindAllDTO createServ(final Screen newScreen) {
        if (newScreen == null) {
            log.warn("newScreen cannot be null!");
            throw new RuntimeException("newScreen cannot be null!");
        }

        boolean flag = repository.save(newScreen);
        if (flag) log.info("새로운 영화관 [Id: {}]이 저장되었습니다.", newScreen.getScreenID());

        return flag ? findAllServ(newScreen.getTheaterID()) : null;
    }

    public FindAllDTO update(Screen screen) {
        boolean flag = repository.modify(screen);
        return flag ? findAllServ(screen.getTheaterID()) : new FindAllDTO();
    }

    public FindAllDTO deleteServ(String id, String TheaterID) {
        boolean flag = repository.remove(id);

        if (!flag) {
            log.warn("delete fail!! not found id [{}]", id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ(TheaterID);
    }

}
