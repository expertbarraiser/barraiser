package com.company.SnakeAndLadder.entity;

import java.util.Arrays;
import java.util.List;


public class Game {

    private static Integer gameIndex = 0;

    private String id;
    private List<Integer> players;
    private Cell[][] board;

    public Game(final List<Integer> players, final Integer boardSize) {
        this.id = "game_"+(++gameIndex);
        this.players = players;
        this.board = new Cell[boardSize][boardSize];
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Integer> players) {
        this.players = players;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(final Cell[][] board) {
        this.board = board;
    }

    @Override public String toString() {
        return "Game{" +
                "id=" + id +
                ", players=" + players +
                ", board=" + Arrays.toString(board) +
                '}';
    }
}
