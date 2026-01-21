package tetris;

public class Tetromino {
    private int[][] shape; // shape array
    private int x, y; // position on the board

    public Tetromino(int[][] shape) {
        this.shape = shape;
        this.x = 4;
        this.y = 0;
    }
}