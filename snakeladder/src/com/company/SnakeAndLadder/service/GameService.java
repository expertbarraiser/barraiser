package com.company.SnakeAndLadder.service;

import java.util.List;
import java.util.Map;
import com.company.SnakeAndLadder.entity.Cell;
import com.company.SnakeAndLadder.entity.Game;
import com.company.SnakeAndLadder.entity.Player;


public interface GameService {

    String createGame(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Integer> playerId);

    Boolean holdDice(String gameId, int playerId);

    Boolean rollDiceAndMove(String gameId, Cell[][] board,  Player player);

    Game getGameById(String gameId);
}
