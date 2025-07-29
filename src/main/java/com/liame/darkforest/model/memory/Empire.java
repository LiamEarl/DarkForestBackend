package com.liame.darkforest.model.memory;

import com.liame.darkforest.model.database.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empire {
    private String name;
    private EmpireType type;
    private User owner;
    private ResourceBank bank;
    private ArrayList<System> ownedSystems;
}
