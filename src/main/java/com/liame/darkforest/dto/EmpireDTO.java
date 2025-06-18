package com.liame.darkforest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmpireDTO {
    private String name;
    private String type;
    private long owner_id;
}
