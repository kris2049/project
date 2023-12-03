package com.teamsolid.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class GameController {
    @FXML
    private GridPane gameBoard;

    private Obstacle[] obstacles; // 存储障碍物的数组

    @FXML
    private ImageView imageView; // 这是FXML中ImageView的引用
    private ImageView player1View;
    private ImageView player2View;

    @FXML
    private Button rollButton; // 这是FXML中Button的引用
    @FXML
    private TextFlow textFlow;

    private int currentPlayer;
    private Player player1;
    private Player player2;



    File file1 = new File("src/main/resources/images/dice_1.png");
    String dice1 = file1.toURI().toString();

    File file2 = new File("src/main/resources/images/dice_2.png");
    String dice2 = file2.toURI().toString();

    File file3 = new File("src/main/resources/images/dice_3.png");
    String dice3 = file3.toURI().toString();
    File file4 = new File("src/main/resources/images/dice_4.png");
    String dice4 = file4.toURI().toString();
    File file5 = new File("src/main/resources/images/dice_5.png");
    String dice5 = file5.toURI().toString();
    File file6 = new File("src/main/resources/images/dice_6.png");
    String dice6 = file6.toURI().toString();
    File file7 = new File("src/main/resources/images/dice_7.png");
    String dice7 = file7.toURI().toString();
    File file8 = new File("src/main/resources/images/dice_8.png");
    String dice8 = file8.toURI().toString();
    File file9 = new File("src/main/resources/images/dice_9.png");
    String dice9 = file9.toURI().toString();
    File file_blackhole = new File("src/main/resources/images/blackhole.png");
    String blackhole = file_blackhole.toURI().toString();
    File file_fire = new File("src/main/resources/images/fire.png");
    String fire = file_fire.toURI().toString();
    File file_spike = new File("src/main/resources/images/spike.jpg");
    String spike = file_spike.toURI().toString();
    File file_end = new File("src/main/resources/images/end.png");
    String end = file_end.toURI().toString();
    File P1 = new File("src/main/resources/images/p1.png");
    String p1 = P1.toURI().toString();
    File P2 = new File("src/main/resources/images/p2.png");
    String p2 = P2.toURI().toString();

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
        player1 = new Player();
        player2 = new Player();
        rollButton.setOnAction(event -> rollDice());
        // 随机选择开始的玩家
        currentPlayer = random.nextInt(2) + 1; // 生成 1 或 2
        updateTextFlow("Player" + currentPlayer + " starts.");
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
        obstacles = new Obstacle[7];
        // 指定每种障碍物的位置
        int[][] positions = {{3,0},{1, 1}, {6, 1}, {1, 6},{6,7}, {6, 6}, {3, 4}}; // 指定位置
        String[] types = {"Fire", "BlackHole", "Spike","Fire","BlackHole", "Spike", "End"}; // 指定类型


        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            String type = types[i];

            Obstacle obstacle = new Obstacle(type, new int[]{x, y});
            obstacles[i] = obstacle;

            ImageView obstacleView = createObstacleView(type, x, y);
            gameBoard.add(obstacleView, x, y);
        }

        // 初始化玩家视图
        player1View = createPlayerView(p1); // 替换为玩家1的图片路径
        player2View = createPlayerView(p2); // 替换为玩家2的图片路径

        // 将玩家放置在棋盘的起始位置
        positionPlayersInView(0, 0);


    }
    private void positionPlayersInView(int x, int y) {
        // 确保视图只被添加一次
        if (!gameBoard.getChildren().contains(player1View)) {
            gameBoard.add(player1View, x, y);
        }
        GridPane.setConstraints(player1View, x, y);
        player1View.setTranslateX(0); // 玩家1向左偏移

        if (!gameBoard.getChildren().contains(player2View)) {
            gameBoard.add(player2View, x, y);
        }
        GridPane.setConstraints(player2View, x, y);
        player2View.setTranslateX(50); // 玩家2向右偏移
    }

    // 更新玩家位置的方法
    public void updatePlayerPosition(ImageView playerView, int newX, int newY) {
        GridPane.setConstraints(playerView, newX, newY);
        // 如果两个玩家在同一个格子，调整它们的位置
        if (GridPane.getColumnIndex(player1View) == GridPane.getColumnIndex(player2View) &&
                GridPane.getRowIndex(player1View) == GridPane.getRowIndex(player2View)) {
            player1View.setTranslateX(0); // 向左偏移
            player2View.setTranslateX(50); // 向右偏移
        } else {
            player1View.setTranslateX(0); // 重置偏移
            player2View.setTranslateX(0); // 重置偏移
        }
    }

    private ImageView createPlayerView(String imagePath) {
        ImageView view = new ImageView(new Image(imagePath));
        view.setFitWidth(50);
        view.setFitHeight(50);
        return view;
    }

    private ImageView createObstacleView(String type, int x, int y) {
        ImageView view = new ImageView();
        Image image = switch (type) {
            case "Fire" -> new Image(fire);
            case "BlackHole" -> new Image(blackhole);
            case "Spike" -> new Image(spike);
            case "End" -> new Image(end);
            default -> null;
        };
        view.setImage(image);
        view.setFitWidth(100);
        view.setFitHeight(100);
        return view;
    }

    // 随机显示一张图片
    private void rollDice(){
        // 生成一个随机索引来选择图片
        int randomIndex = random.nextInt(imageFiles.length);

        // 获取选定的图片文件名
        String selectedImageFile = imageFiles[randomIndex];

        System.out.println(selectedImageFile+"\n\n\n");


        Image image = new Image(selectedImageFile);
        imageView.setImage(image);

        textFlow.getChildren().clear();
        updateTextFlow("Player" +currentPlayer+  " rolls number " + (randomIndex+1));
        Player player = (currentPlayer == 1) ? player1 : player2;
        if(player.isStoppedBySpike()&&(randomIndex+1)<3){
            updateTextFlow("\nThe number is less than 3, you have to wait one round!!!");
        } else if (player.isStoppedBySpike()&&(randomIndex+1)>=3) {
            player.setStoppedBySpike(false);
        }
        else{
            movePlayer(currentPlayer,randomIndex+1);}

        currentPlayer = (currentPlayer == 1) ? 2 : 1;

    }

    private void movePlayer(int playerNumber, int steps) {
        ImageView playerView = (playerNumber == 1) ? player1View : player2View;
        Player player = (playerNumber == 1) ? player1 : player2;

        player.move(steps); // 更新玩家位置
        int[] newPosition = player.getPosition();
        checkForObstacles(newPosition,playerNumber);
        updatePlayerPosition(playerView,player.getPosition()[0],player.getPosition()[1]);
        checkForWin(newPosition,playerNumber);
    }

    private void checkForWin(int[] position,int playerNumber){
        if(position[0]==3&&position[1]==4){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText("Player"+playerNumber+"wins!!!");
            alert.showAndWait();
            System.exit(0); // 关闭程序
        }
    }

    private void checkForObstacles(int[] position, int playerNumber) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.isAtPosition(position)) {
                Player player = (playerNumber == 1) ? player1 : player2;
                encounterObstacle(player,obstacle);
                break; // 假设每个格子只有一个障碍物
            }
        }
    }

    private void encounterObstacle(Player player, Obstacle obstacle){
        switch (obstacle.getType()){
            case "Fire":
                player.reborn(); // 遇到火，被烧死出发点复活
                updateTextFlow("\nYou were burned to death. Lets start from the beginning!!!");
                break;
            case "BlackHole":
                player.teleportToRandomLocation(); // 遇到黑洞，随机传送到一个位置
                updateTextFlow("\nOps! Where are you?");
                break;
            case "Spike":
                player.setStoppedBySpike(true);
                break;
        }
    }

    private void updateTextFlow(String message) {
        Text text = new Text(message ); // 添加换行符以便下一条消息显示在新的一行
        text.setFont(new Font("Arial",20));
        textFlow.getChildren().add(text);
    }


}
