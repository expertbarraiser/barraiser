package com.company.SnakeAndLadder.service;

import java.util.HashMap;
import java.util.Map;
import com.company.SnakeAndLadder.entity.Player;


public class PlayerServiceImpl implements PlayerService{

    private Map<String, Player> playerMap;

    public PlayerServiceImpl() {
        playerMap = new HashMap<>();
    }

    @Override public Player createPlayer(final String name) {
        if(name == null){
            return null;
        }
        Player player = new Player(name, 0);
        playerMap.put(player.getId(), player);
        return player;
    }

    @Override public Player getPlayer(final int playerId) {
        return playerMap.get(playerId);
    }
}
