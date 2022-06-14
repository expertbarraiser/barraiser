package com.company.SnakeAndLadder.entity;

public class Ladder extends Obstacle{

    private ObstacleType obstacleType;

    public Ladder(final Integer from, final Integer end) {
        super(from, end);
        obstacleType = ObstacleType.LADDER;
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public void setObstacleType(final ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    @Override public String toString() {
        return "Ladder{" +
                "obstacleType=" + obstacleType +
                '}';
    }
}
