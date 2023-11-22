package TeamSolid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;

public class Obstacle {
    private String type; // 障碍物类型，可以是 "火"、"黑洞"、"地刺"、"传送门"
    private boolean active; // 障碍物是否激活

    public Obstacle(String type) {
        this.type = type;
        this.active = true; // 障碍物默认为激活状态
    }

    public void encounter(Player player) {
        if (!active) {
            return; // 如果障碍物不激活，不执行任何操作
        }

        // 根据不同类型的障碍物执行不同的操作
        switch (type) {
            case "Fire":
                player.setSkipTurn(true); // 遇到火，暂停一回合
                break;
            case "BlackHole":
                player.teleportToRandomLocation(); // 遇到黑洞，随机传送到一个位置
                break;
            case "Spike":
                int roll = rollDice(); // 摇骰子
                if (roll > 5) {
                    // 摇到大于5的点数，可以行动
                    // 在这里执行相关行动逻辑
                }
                break;
            case "TP":
                player.teleportToMatchingPortal(); // 遇到传送门，传送到对应的门处
                break;
        }
    }

    public void deactivate() {
        active = false; // 停用障碍物
    }

    private int rollDice() {
        // 摇骰子并返回点数
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
}