package com.company.SnakeAndLadder.entity;

public class Obstacle {

    private static Integer obstacleIndex = 0;

    private Integer id;
    private Integer from;
    private Integer end;

    public Obstacle(final Integer from, final Integer end) {
        this.id = ++obstacleIndex;
        this.from = from;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(final Integer from) {
        this.from = from;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(final Integer end) {
        this.end = end;
    }

    @Override public String toString() {
        return "Obstacle{" +
                "id=" + id +
                ", from=" + from +
                ", end=" + end +
                '}';
    }
}
