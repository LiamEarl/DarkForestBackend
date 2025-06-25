package com.liame.darkforest.controllers;
import com.liame.darkforest.dto.UserDTO;
import com.liame.darkforest.model.Game;
import com.liame.darkforest.model.User;
import com.liame.darkforest.service.GameService;
import com.liame.darkforest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private GameService gameService;
    private UserService userService;

    public GameController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @PostMapping("/create/{gameCode}")
    public ResponseEntity<String> createGame(@PathVariable String gameCode, Authentication authentication) {
        String username = authentication.getName();
        User gameOwner = userService.find(username);
        if(gameOwner == null) {
            System.out.println("Game creator not found");
            return null;
        }

        ResponseEntity<String> response = gameService.createGame(gameCode);
        gameService.joinGame(gameCode, gameOwner);
        return response;
    }

    @PostMapping("/join/{gameCode}")
    public ArrayList<UserDTO> join(@PathVariable String gameCode, Authentication authentication) {
        String username = authentication.getName();

        User prospectivePlayer = userService.find(username);
        if(prospectivePlayer == null) {
            System.out.println("Prospective player not found");
            return null;
        }

        ArrayList<User> users = gameService.joinGame(gameCode, prospectivePlayer);
        return getUserDTOsFromBaseUsers(users);
    }

    @GetMapping("/getConnected/{gameCode}")
    public ArrayList<UserDTO> getUsers(@PathVariable String gameCode) {
        return getUserDTOsFromBaseUsers(
            gameService.getUsers(gameCode)
        );
    }

    @GetMapping("/{gameCode}")
    public Game getGame(@PathVariable String gameCode) {
        return gameService.getGame(gameCode);
    }

    private ArrayList<UserDTO> getUserDTOsFromBaseUsers(ArrayList<User> users) {
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        for(User user:users) {
            userDTOs.add(new UserDTO(user));
        }
        return userDTOs;
    }
}