package com.company.SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.company.SnakeAndLadder.entity.Game;
import com.company.SnakeAndLadder.entity.Player;
import com.company.SnakeAndLadder.entity.Snake;
import com.company.SnakeAndLadder.service.GameService;
import com.company.SnakeAndLadder.service.GameServiceImpl;
import com.company.SnakeAndLadder.service.PlayerService;
import com.company.SnakeAndLadder.service.PlayerServiceImpl;


public class SnakeLadderGame {

    private static GameService gameService = new GameServiceImpl();
    private static PlayerService playerService = new PlayerServiceImpl();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------");
        while(true){
            System.out.println("Command : ");
            Command cmd = Command.valueOf(sc.nextLine());
            switch (cmd){
                case create_game: {
                    System.out.println("Board Size :");
                    int boardSize = Integer.parseInt(sc.nextLine());
                    System.out.println("Players :");
                    int playerCount = Integer.parseInt(sc.nextLine());
                    List<Integer> playerIdList = new ArrayList<>();
                    for(int i = 0; i < playerCount; i++){
                        playerService.createPlayer("Player"+(i+1));
                    }
                    Map<Integer, Integer> ladders = new HashMap<>();
                    ladders.put(1,38);
                    ladders.put(4,14);
                    ladders.put(8,30);
                    ladders.put(21,42);
                    ladders.put(28,76);
                    ladders.put(50,67);
                    ladders.put(80,99);
                    ladders.put(71,92);

                    Map<Integer, Integer> snakes = new HashMap<>();
                    snakes.put(97,78);
                    snakes.put(95,56);
                    snakes.put(88,24);
                    snakes.put(62,18);
                    snakes.put(36,6);
                    snakes.put(32,10);
                    System.out.println(gameService.createGame(boardSize, snakes, ladders,playerIdList));
                }
                case play:{
                    while (true){
                        String gameId = sc.nextLine();
                        int playerId = Integer.parseInt(sc.nextLine());
                        if(gameService.holdDice(gameId, playerId)){
                            Game game = gameService.getGameById(gameId);
                            Player player = playerService.getPlayer(playerId);
                            gameService.rollDiceAndMove(gameId, game.getBoard(), player);
                        }
                        if(false){
                            break;
                        }
                    }

                    break;
                }
                case exit: {
                    return;
                }

            }
        }
    }
}
