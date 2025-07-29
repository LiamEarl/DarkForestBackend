package com.liame.darkforest.model.memory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResourceBank {
    private double food, energy, alloys, credits;
    public ResourceBank() {
        this.food = 0.0;
        this.energy = 0.0;
        this.alloys = 0.0;
        this.credits = 0.0;
    }
}
