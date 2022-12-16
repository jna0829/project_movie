package com.example.project_D.business.entity;

import com.example.project_D.local.entity.Local;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@AllArgsConstructor
public class Business {

    private String busName; //지점이름

    public Business() {}

}
