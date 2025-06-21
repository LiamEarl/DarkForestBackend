package com.liame.darkforest.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
}
