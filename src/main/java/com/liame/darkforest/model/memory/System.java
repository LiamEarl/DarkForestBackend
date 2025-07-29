package com.liame.darkforest.model.memory;

import com.liame.darkforest.model.memory.utility.Vector2D;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class System {
    private List<System> connectedSystems;
    private ResourceBank availableResources;
    private String name;
    private Vector2D position;
    public void connectSystem(System s) {
        connectedSystems.add(s);
    }
    public void disconnectSystem(System s) {
        connectedSystems.remove(s);
    }
}
