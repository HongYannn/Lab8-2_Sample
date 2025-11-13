import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    public void testXWinsHorizontally() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(1, 0); // O
        game.set(0, 1); // X
        game.set(1, 1); // O
        game.set(0, 2); // X wins
        assertEquals('X', game.evaluate());
    }

    @Test
    public void testOWinsDiagonally() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(1, 0); // X
        game.set(1, 1); // O
        game.set(2, 2); // X
        game.set(2, 1); // O wins
        assertEquals('O', game.evaluate());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        // X O X
        // X X O
        // O X O
        game.set(0, 0); game.set(0, 1);
        game.set(0, 2); game.set(1, 0);
        game.set(1, 2); game.set(1, 1);
        game.set(2, 1); game.set(2, 0);
        game.set(2, 2);
        assertEquals('D', game.evaluate());
    }

    @Test
    public void testGameNotFinished() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        assertEquals(' ', game.evaluate());
    }
}
