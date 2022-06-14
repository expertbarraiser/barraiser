package com.company.SnakeAndLadder.entity;

import java.util.ArrayList;
import java.util.List;


public class Cell {

    private static Integer cellIndex = 0;

    private Integer id;
    private Integer cellNum;
    private List<Player> players;
    private Obstacle obstacle;
    private Integer capacity;

    public Cell(final Integer cellNum, final Obstacle obstacle) {
        this.id = ++cellIndex;
        this.cellNum = cellNum;
        this.players = new ArrayList<>();
        this.obstacle = obstacle;
        this.capacity = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getCellNum() {
        return cellNum;
    }

    public void setCellNum(final Integer cellNum) {
        this.cellNum = cellNum;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(final List<Player> players) {
        this.players = players;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(final Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    @Override public String toString() {
        return "Cell{" +
                "id=" + id +
                ", cellNum=" + cellNum +
                ", players=" + players +
                ", obstacle=" + obstacle +
                '}';
    }
}
