package com.example.project_D.local.dto;

import com.example.project_D.local.entity.Local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalDTO {

    private String localName;

    public LocalDTO(Local local){
        this.localName = local.getLocalName();
        this.LocalDTOList(localList());
    }

    private List<LocalDTO> list;
    public List<Local> localList() {
        return Arrays.asList(
                new Local("서울"),
                new Local("경기"),
                new Local("대전"),
                new Local("부산"),
                new Local("제주")
        );
    }

    public void LocalDTOList(List<Local> localList){
        List<LocalDTO> locals = new ArrayList<>();

        for (Local local : localList){
            locals.add(new LocalDTO(local));
        }
        this.list = locals;

    }


}
