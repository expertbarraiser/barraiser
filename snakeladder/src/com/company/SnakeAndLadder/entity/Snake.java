package com.company.SnakeAndLadder.entity;

public class Snake extends Obstacle {

    private ObstacleType obstacleType ;

    public Snake(final Integer from, final Integer end) {
        super(from, end);
        obstacleType = ObstacleType.SNAKE;
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public void setObstacleType(final ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    @Override public String toString() {
        return "Snake{" +
                "obstacleType=" + obstacleType +
                '}';
    }
}
