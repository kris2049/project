package com.teamsolid.javaproject;

/**
 * Represents an obstacle in the game.
 * This class is used to define the various types of obstacles encountered on the game board,
 * such as fire, black holes, ground spikes, or portals, along with their positions.
 *
 * @author Jingzhi_Zhou
 */
public class Obstacle {
    private String type; // Type of obstacle, which can be "fire", "black hole", "ground spike", "portal"
    private int[] position; // Position of obstacles on the board
    /**
     * Retrieves the type of the obstacle.
     *
     * @return A string representing the type of the obstacle.
     */
    public String getType() {
        return type;
    }


    /**
     * Constructs a new Obstacle instance.
     *
     * @param type     The type of the obstacle (e.g., "fire", "black hole").
     * @param position The position of the obstacle on the game board, represented as an array [x, y].
     */
    public Obstacle(String type, int[] position) {
        this.type = type;
        this.position = position;
    }
    /**
     * Checks if the obstacle is at the given player position.
     *
     * @param playerPosition The position of the player to check against, represented as an array [x, y].
     * @return true if the obstacle is at the same position as the player, false otherwise.
     */
    public boolean isAtPosition(int[] playerPosition) {
        return position[0] == playerPosition[0] && position[1] == playerPosition[1];
    }
}