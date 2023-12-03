package com.teamsolid.javaproject;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.util.Random;
import java.util.HashSet;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;

public class HelloController {
    @FXML
    private GridPane gameBoard;

    private Obstacle[] obstacles; // 存储障碍物的数组
    @FXML
    private ImageView imageView; // 这是FXML中ImageView的引用
    @FXML
    private Button rollButton; // 这是FXML中Button的引用
    @FXML
    private TextFlow textFlow;

    File file1 = new File("src/main/resources/images/dice_1.png");
    String dice1 = file1.toURI().toString();

    File file2 = new File("src/main/resources/images/dice_1.png");
    String dice2 = file2.toURI().toString();

    File file3 = new File("src/main/resources/images/dice_2.png");
    String dice3 = file3.toURI().toString();
    File file4 = new File("src/main/resources/images/dice_3.png");
    String dice4 = file4.toURI().toString();
    File file5 = new File("src/main/resources/images/4.png");
    String dice5 = file5.toURI().toString();
    File file6 = new File("src/main/resources/images/dice_5.png");
    String dice6 = file6.toURI().toString();
    File file7 = new File("src/main/resources/images/dice_6.png");
    String dice7 = file7.toURI().toString();
    File file8 = new File("src/main/resources/images/dice_7.png");
    String dice8 = file8.toURI().toString();
    File file9 = new File("src/main/resources/images/dice_7.png");
    String dice9 = file9.toURI().toString();

    // 存储九张图片的文件名
    private final String[] imageFiles = {
            dice1,
            dice2,
            dice3,
            dice4,
            dice5,
            dice6,
            dice7,
            dice8,
            dice9
    };

    // 创建一个随机数生成器
    private final Random random = new Random();

    // 控制器的初始化方法，由FXML加载器在加载FXML文件时自动调用
    @FXML
    private void initialize() {
        initializeBoard();
        rollButton.setOnAction(event -> rollImage());
    }

    private void initializeBoard() {
        // 初始化棋盘的格子
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(100, 100);
                rect.setStroke(Color.BLACK); // 设置格子的边框颜色
                rect.setFill((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY); // 交替颜色
                gameBoard.add(rect, j, i);
            }
        }

        // 初始化障碍物
        Random random = new Random();
        obstacles = new Obstacle[3]; // 初始化3个障碍物
        HashSet<String> occupiedPositions = new HashSet<>(); // 用于记录已占用的位置

        for (int i = 0; i < obstacles.length; i++) {
            int x, y;
            String positionKey;
            do {
                x = random.nextInt(8);
                y = random.nextInt(8);
                positionKey = x + "," + y;
            } while (occupiedPositions.contains(positionKey)); // 确保位置不重复

            occupiedPositions.add(positionKey); // 记录这个位置

            // 随机选择障碍物类型
            String[] types = {"Fire", "BlackHole", "Spike"};
            String type = types[random.nextInt(types.length)];

            // 创建障碍物并放置在GridPane上
            //Obstacle obstacle = new Obstacle(type, new int[]{x, y});
            //obstacles[i] = obstacle;

            // 创建障碍物的可视表示（这里使用Rectangle，可以替换为其他图形或图片）
//            Rectangle obstacleView = new Rectangle(100, 100);
//            obstacleView.setFill(Color.RED); // 假设障碍物是红色的
//            gameBoard.add(obstacleView, x, y); // 将障碍物添加到棋盘的GridPane
        }
    }

    // 随机显示一张图片
    private void rollImage(){
        // 生成一个随机索引来选择图片
        int randomIndex = random.nextInt(imageFiles.length);



        // 获取选定的图片文件名
        String selectedImageFile = imageFiles[randomIndex];

        System.out.println(selectedImageFile+"\n\n\n");




        Image image = new Image(selectedImageFile);
        imageView.setImage(image);

    }

}
