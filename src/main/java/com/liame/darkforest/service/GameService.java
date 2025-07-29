package com.liame.darkforest.service;

import com.liame.darkforest.model.database.Game;
import com.liame.darkforest.model.database.User;
import com.liame.darkforest.repo.GameRepository;
import com.liame.darkforest.repo.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {
    private Map<Long, Set<Long>> connectedUsers = new ConcurrentHashMap<>();

    private UserRepository userRepository;
    private GameRepository gameRepository;

    public GameService(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public Game getGame(String gameCode) {
        return gameRepository.findByCode(gameCode);
    }

    public ResponseEntity<String> createGame(String gameCode) {
        if(gameRepository.findByCode(gameCode) != null) return ResponseEntity.badRequest().body("Game code already in use.");
        Game game = new Game();
        game.setCode(gameCode);
        gameRepository.save(game);
        connectedUsers.put(game.getId(), ConcurrentHashMap.newKeySet());
        return ResponseEntity.ok().body("Successfully created the game.");
    }

    public ArrayList<User> addUser(Long gameID, User user) {
        if(!connectedUsers.containsKey(gameID)) throw new IllegalArgumentException("At addUser(), game " + gameID + " doesn't exist.");
        connectedUsers.get(gameID).add(user.getId());
        return getUsers(gameID);
    }

    public ArrayList<User> addUser(String gameCode, User user) {
        Game game = gameRepository.findByCode(gameCode);
        if(game == null) return null;
        Long gameID = game.getId();
        if(!connectedUsers.containsKey(gameID)) throw new IllegalArgumentException("At addUser(), game " + gameID + " doesn't exist.");
        connectedUsers.get(gameID).add(user.getId());
        return getUsers(gameID);
    }

    public ArrayList<User> joinGame(String gameCode, User user) {
        Game game = gameRepository.findByCode(gameCode);
        if(game == null) return null;
        Long gameID = game.getId();
        return addUser(gameID, user);
    }

    public ArrayList<User> getUsers(String gameCode) {
        Game game = gameRepository.findByCode(gameCode);
        if(game == null) return null;
        return getUsers(game.getId());
    }

    public ArrayList<User> getUsers(Long gameID) {
        if(!connectedUsers.containsKey(gameID)) throw new IllegalArgumentException("At getUsers(), game " + gameID + " doesn't exist.");
        ArrayList<User> users = new ArrayList<>();

        Iterator<Long> iterator = connectedUsers.get(gameID).iterator();

        while (iterator.hasNext()) {
            Long userId = iterator.next();
            try {
                users.add(userRepository.findById(userId).get());
            }catch(NoSuchElementException e) {
                iterator.remove();
            }
        }
        return users;
    }
}
