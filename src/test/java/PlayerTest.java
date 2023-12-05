import com.teamsolid.javaproject.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Test class for the Player class in the com.teamsolid.javaproject package.
 * This class contains unit tests to verify the functionality of the Player class.
 */
public class PlayerTest {
    private Player player;
    /**
     * Sets up the testing environment before each test method.
     * This method is executed before each test. It initializes the Player object.
     */
    @Before
    public void setUp() {
        player = new Player();
    }
    /**
     * Tests the basic movement functionality of the Player.
     * Verifies that the player moves correctly for a given number of steps.
     */
    @Test
    public void testMoveBasic() {
        player.move(3);
        int[] expectedPosition = {3, 0};
        assertArrayEquals(expectedPosition, player.getPosition());
    }
    /**
     * Tests the movement functionality of the Player at boundary conditions.
     * Verifies that the player's position is correctly updated at the boundaries of the board.
     */
    @Test
    public void testMoveBoundary() {
        player.move(8);
        int[] expectedPosition = {7, 1};
        assertArrayEquals(expectedPosition, player.getPosition());

        player.move(7);
        expectedPosition = new int[]{6, 7};
        assertArrayEquals(expectedPosition, player.getPosition());
    }
    /**
     * Tests the movement functionality of the Player beyond boundary conditions.
     * Verifies that the player's position is correctly updated when moving beyond the board's boundaries.
     */
    @Test
    public void testMoveBeyondBoundary() {
        player.move(64);
        int[] expectedPosition = {3, 4};
        assertArrayEquals(expectedPosition, player.getPosition());
    }
    /**
     * Tests the teleport functionality of the Player.
     * Verifies that the player is teleported to a valid random position on the board.
     */
    @Test
    public void testTeleportToRandomLocation() {
        player.teleportToRandomLocation();
        int[] position = player.getPosition();
        assertTrue(position[0] >= 0 && position[0] < 8);
        assertTrue(position[1] >= 0 && position[1] < 8);
    }
    /**
     * Tests the throw count increment functionality of the Player.
     * Verifies that the player's throw count is correctly incremented.
     */
    @Test
    public void testIncrementThrowCount() {
        player.incrementThrowCount();
        assertEquals(1, player.getThrowCount());
    }
    /**
     * Tests the distance calculation functionality of the Player.
     * Verifies that the distance is correctly calculated based on the player's position on the board.
     */
    @Test
    public void testCalculateDistance() {
        assertEquals(1, player.calculateDistance(0, 0));
        assertEquals(28, player.calculateDistance(0, 1));
        assertEquals(2, player.calculateDistance(1, 0));
        assertEquals(29, player.calculateDistance(1, 1));
    }
}