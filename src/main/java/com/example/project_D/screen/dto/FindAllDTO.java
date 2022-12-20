package com.example.project_D.screen.dto;

import com.example.project_D.screen.entity.Screen;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count;
    private List<ScreenDTO> screenList;

    public FindAllDTO(List<Screen> ScreenList) {
        this.count = ScreenList.size();
        this.convertDTOList(ScreenList);
    }

    public void convertDTOList(List<Screen> ScreenList) {
        List<ScreenDTO> dto = new ArrayList<>();

        for (Screen screen : ScreenList) {
            dto.add(new ScreenDTO(screen));
        }
        this.screenList = dto;
    }

}