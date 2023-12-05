package com.teamsolid.javaproject;

/**
 * Represents the result of a game session.
 * This class stores the details of a player's performance in a game,
 * including their name and the number of throws they made.
 * It is used for tracking and comparing game results.
 *
 * @author Ziyuan Ning
 */
public class GameResult {
    private String Player;
    private int throwCount;

    /**
     * Constructs a new GameResult instance.
     *
     * @param Player     The name of the player.
     * @param throwCount The total number of throws made by the player in the game.
     */
    public GameResult(String Player, int throwCount) {
        this.Player = Player;
        this.throwCount = throwCount;
    }
    /**
     * Retrieves the name of the player.
     *
     * @return The name of the player associated with this game result.
     */
    public String getPlayer() {
        return Player;
    }
    /**
     * Retrieves the total number of throws made by the player.
     *
     * @return The count of throws made by the player in the game.
     */
    public int getThrowCount() {
        return throwCount;
    }

}
