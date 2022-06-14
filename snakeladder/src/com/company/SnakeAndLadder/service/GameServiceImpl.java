package com.company.SnakeAndLadder.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.company.SnakeAndLadder.entity.Cell;
import com.company.SnakeAndLadder.entity.Game;
import com.company.SnakeAndLadder.entity.Ladder;
import com.company.SnakeAndLadder.entity.Player;
import com.company.SnakeAndLadder.entity.Snake;


public class GameServiceImpl implements GameService {

    private Map<String, Game> gameMap;
    private Map<String, Set<Integer>> gameChances = new HashMap<>();

    public GameServiceImpl() {
        this.gameMap = new HashMap<>();
    }

    @Override public String createGame(final int boardSize, final Map<Integer, Integer> snakes,
            final Map<Integer, Integer> ladders,
            final List<Integer> players) {

        Game game = new Game(players, boardSize);
        Cell[][] board = game.getBoard();

        int index = 1;
        for(int i = 0; i < board.length; i++){
            if(i % 2 == 0){
                for(int j = 0; j < board[i].length; j++){
                    board[i][j].setCellNum(index++);
                    if(snakes.containsKey(board[i][j].getCellNum())){
                        Snake snake = new Snake(board[i][j].getCellNum(), snakes.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(snake);
                    } else if (ladders.containsKey(board[i][j].getCellNum())) {
                        Ladder ladder = new Ladder(board[i][j].getCellNum(), snakes.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(ladder);
                    }
                }
            } else {
                for(int j = board[i].length - 1; j >= 0 ; j--){
                    board[i][j].setCellNum(index++);
                    if(snakes.containsKey(board[i][j].getCellNum())){
                        Snake snake = new Snake(board[i][j].getCellNum(), snakes.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(snake);
                    } else if (ladders.containsKey(board[i][j].getCellNum())) {
                        Ladder ladder = new Ladder(board[i][j].getCellNum(), snakes.get(board[i][j].getCellNum()));
                        board[i][j].setObstacle(ladder);
                    }
                }
            }
        }
        Set<Integer> chanceRemaining = new HashSet<>(players);
        gameChances.put(game.getId(), chanceRemaining);
        return game.getId().toString();
    }

    @Override public Boolean holdDice(final String gameId, final int playerId) {
        if(!gameChances.containsKey(gameId)){
            System.out.println("Issue");
            return false;
        }
        if(gameChances.get(gameId).contains(playerId)){
            gameChances.get(gameId).remove(playerId);
            if(gameChances.get(gameId).isEmpty()){
                gameChances.put(gameId,new HashSet<>(gameMap.get(gameId).getPlayers()));
            }
            return true;
        }
        return false;
    }

    @Override public Boolean rollDiceAndMove(final String gameId, final Cell[][] board, final Player player) {
        int dice = (int) (1 + ((Math.random() * 100) % 6));
        if(player.getCellNo() == 0){ // Not started
            if(getCellByNumber(board, board.length, dice).getCapacity() > board[0][dice].getPlayers().size()){
                List<Player> existingPlayers = board[0][dice].getPlayers();
                existingPlayers.add(player);
                player.setCellNo(dice);
            }
        } else { // Already
            Cell currentCell = getCellByNumber(board, board.length, player.getCellNo());
            Integer expected = currentCell.getCellNum();
            int d = dice;
            boolean found = false;
            for(int i = 0; i < board.length; i++){
                if(i %2 == 0) {
                    for(int j = 0; j < board[i].length; j++) {
                        if(!found){
                            if(currentCell == board[i][j]) {
                                found = true;
                            }
                        } else {
                            d--;
                            expected++;
                        }
                        if(d == 0){
                            break;
                        }
                    }
                } else {
                    for(int j = board[i].length; j >= 0; j--) {
                        if(!found){
                            if(currentCell == board[i][j]) {
                                found = true;
                            }
                        } else {
                            d--;
                            expected++;
                        }
                        if(d == 0){
                            break;
                        }
                    }
                }
            }
            if(expected < (board.length * board.length)){
                Cell dCell = getCellByNumber(board, board.length, expected);
                if(dCell.getPlayers().size() < dCell.getCapacity()){
                    List<Player> existingPlayers = dCell.getPlayers();
                    existingPlayers.add(player);
                    player.setCellNo(dice);
                }
            }
        }
        //
        return null;
    }

    @Override public Game getGameById(final String gameId) {
        return gameMap.get(gameId);
    }

    private Cell getCellByNumber(Cell[][] board, Integer boardSize, Integer number){
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(board[i][j].getCellNum() == number) {
                    return board[i][j];
                }
            }
        }
        return null;
    }
}
