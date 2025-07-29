package com.liame.darkforest.model.memory;

import com.liame.darkforest.model.database.Empire;
import com.liame.darkforest.model.memory.utility.Vector2D;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private List<System> systems;
    private List<Empire> empires;

    public Game() {
        systems = new ArrayList<>();
        empires = new ArrayList<>();
        generateGalaxy();
    }

    //TODO: Make this not hardcoded
    private void generateGalaxy() {
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Ton",
                new Vector2D(10, 10)
        ));
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Mesa",
                new Vector2D(10, 30)
        ));
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Trout",
                new Vector2D(30, 30)
        ));
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Deneb",
                new Vector2D(50, 50)
        ));
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Spider",
                new Vector2D(70, 70)
        ));
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Ione",
                new Vector2D(90, 70)
        ));
        this.systems.add(new System(
                new ArrayList<>(),
                new ResourceBank(),
                "Deruk",
                new Vector2D(90, 90)
        ));

        this.systems.get(0).connectSystem(this.systems.get(1));
        this.systems.get(1).connectSystem(this.systems.get(0));

        this.systems.get(1).connectSystem(this.systems.get(2));
        this.systems.get(2).connectSystem(this.systems.get(1));

        this.systems.get(2).connectSystem(this.systems.get(3));
        this.systems.get(3).connectSystem(this.systems.get(2));

        this.systems.get(3).connectSystem(this.systems.get(4));
        this.systems.get(4).connectSystem(this.systems.get(3));

        this.systems.get(4).connectSystem(this.systems.get(5));
        this.systems.get(5).connectSystem(this.systems.get(4));

        this.systems.get(5).connectSystem(this.systems.get(6));
        this.systems.get(6).connectSystem(this.systems.get(5));
    }
}
