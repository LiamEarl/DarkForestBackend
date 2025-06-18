package com.liame.darkforest.dto;

import com.liame.darkforest.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String username;
    private Long id;
    public UserDTO(User user) {
        this.username = user.getUsername();
        this.id = user.getId();
    }
}
