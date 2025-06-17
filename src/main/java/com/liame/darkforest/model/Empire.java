package com.liame.darkforest.model;

import jakarta.persistence.*;

@Entity
@Table(name="Empires")
public class Empire {
    @Id
    @GeneratedValue
    private long id;
    @Id
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User user;

    private String type;
    private String name;

    public Empire(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Empire() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
