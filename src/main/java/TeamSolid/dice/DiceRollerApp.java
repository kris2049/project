package TeamSolid.dice;

import TeamSolid.dice.DiceRoller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DiceRollerApp extends Application {
    private ImageView diceImageView;
    private DiceRoller diceRoller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dice Roller");

        diceImageView = new ImageView();
        diceRoller = new DiceRoller();

        StackPane root = new StackPane();
        root.getChildren().add(diceImageView);
        primaryStage.setScene(new Scene(root, 300, 300));

        primaryStage.show(); // 调用 rollDiceAndDisplay 方法来投掷骰子并显示图像
        rollDiceAndDisplay();
    }

    private void rollDiceAndDisplay() {
        int diceResult = diceRoller.diceRandom(); // 投骰子
        String diceImagePath = "dice_" + diceResult + ".png"; // 对应的骰子图像文件
        Image diceImage = new Image(getClass().getResourceAsStream(diceImagePath));

        diceImageView.setImage(diceImage); // 显示对应的骰子图像
    }
}