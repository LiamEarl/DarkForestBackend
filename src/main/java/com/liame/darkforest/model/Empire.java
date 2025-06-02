package com.liame.darkforest.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.*;
@Getter
@Setter
public class Empire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false, unique = true)
    private User owner;

    private double alloys;
    private double energy;
    private double food;
    private double science;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    private String name;
    private String type;

    public Empire(String empirename, String empireType) {
        this.name = empirename;
        this.type = empireType;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}
