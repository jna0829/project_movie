package com.example.project_D.local.repository;


import com.example.project_D.local.dto.LocalDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LocalRepositoryTest {

    @Autowired LocalRepository repository;

    @Test
    @DisplayName("지역 데이터 전체를 조회해야 한다.")
    void findAllTest(){
        //given

        //when
        List<LocalDTO> localDTOList = repository.findAll();

        //then
        assertNotNull(localDTOList);

    }


}