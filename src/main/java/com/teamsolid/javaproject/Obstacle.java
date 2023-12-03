package com.teamsolid.javaproject;

import java.util.Random;

public class Obstacle {
    private String type; // 障碍物类型，可以是 "火"、"黑洞"、"地刺"、"传送门"
    private int[] position; // 障碍物在棋盘上的位置

    public String getType() {
        return type;
    }

    public int[] getPosition() {
        return position;
    }

    public Obstacle(String type, int[] position) {
        this.type = type;
        this.position = position;
    }

    public boolean isAtPosition(int[] playerPosition) {
        return position[0] == playerPosition[0] && position[1] == playerPosition[1];
    }






}