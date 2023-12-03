package com.teamsolid.javaproject;

import java.util.Random;

public class Obstacle {
    private String type; // 障碍物类型，可以是 "火"、"黑洞"、"地刺"、"传送门"
    private int[] position; // 障碍物在棋盘上的位置


    public Obstacle(String type, int[] position) {
        this.type = type;
        this.position = position;
    }

    public boolean isAtPosition(int[] playerPosition) {
        return position[0] == playerPosition[0] && position[1] == playerPosition[1];
    }

    public void encounter(Player player) {

        // 根据不同类型的障碍物执行不同的操作
        switch (type) {
            case "Fire":
                player.skipCurrentTurn(true); // 遇到火，暂停一回合
                break;
            case "BlackHole":
                player.teleportToRandomLocation(); // 遇到黑洞，随机传送到一个位置
                break;
            case "Spike":
                int roll = rollDice(); // 摇骰子
                if (roll > 5) {
                    player.move(roll-5);
                }
                break;
            case "TP":
                player.teleportToBegin(); // 遇到传送门，传送到起始位置
                break;
        }
    }



    private int rollDice() {
        // 摇骰子并返回点数
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
}