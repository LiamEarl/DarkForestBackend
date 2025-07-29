package com.liame.darkforest.model.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="empires")
public class Empire {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private String type;
    private String name;

    public Empire() {}
}
