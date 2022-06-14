package com.company.SnakeAndLadder.service;

import com.company.SnakeAndLadder.entity.Player;


public interface PlayerService {

    Player createPlayer(String name);

    Player getPlayer(int playerId);

}
