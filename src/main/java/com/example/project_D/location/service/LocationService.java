package com.example.project_D.location.service;

import com.example.project_D.location.dto.FindAllDTO;
import com.example.project_D.location.dto.LocationDTO;
import com.example.project_D.location.entity.Location;
import com.example.project_D.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    // 지역 전체 조회
    public FindAllDTO findAllServ() {
        return new FindAllDTO(repository.findAll());
    }

    // 지역 개별 조회
    public LocationDTO findOneServ(String id) {
        Location location = repository.findOne(id);
        log.info("findOneServ return data - {}", location);

        return location != null ? new LocationDTO(location) : null;
    }

    // 지역 추가
    public FindAllDTO createServ(final Location newLoc) {
        if (newLoc == null) {
            log.info("newLocation cannot be null!");
            throw new RuntimeException("newLocation cannot be null!");
        }

        boolean flag = repository.save(newLoc);
        if (flag) log.info("새로운 지역 [ID:{}]이 저장되었습니다.", newLoc.getLocationID());

        return flag ? findAllServ() : null;
    }

    // 지역 수정
    public FindAllDTO update(Location location){
        boolean flag = repository.modify(location);

        return flag ? findAllServ() : new FindAllDTO();
    }

    // 지역 삭제
    public FindAllDTO deleteServ(String id){
        boolean flag = repository.remove(id);

        if(!flag){
            log.warn("delete fail new found id - {}", id);
            throw new RuntimeException("delete fail!");
        }
        return findAllServ();
    }


}
