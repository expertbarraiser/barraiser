package com.company.SnakeAndLadder.entity;

public class Player {

    private static Integer playerIndex = 0;

    private String id;
    private String name;
    private Integer cellNo;

    public Player(final String name, final Integer cellNo) {
        this.id = "player_"+(++playerIndex);
        this.name = name;
        this.cellNo = cellNo;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getCellNo() {
        return cellNo;
    }

    public void setCellNo(final Integer cellNo) {
        this.cellNo = cellNo;
    }

    @Override public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellNo=" + cellNo +
                '}';
    }
}
