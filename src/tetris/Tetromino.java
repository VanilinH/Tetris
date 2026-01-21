package tetris;

public class Tetromino {
    private int[][] shape; // shape array
    private int x, y; // position on the board

    public Tetromino(int[][] shape) {
        this.shape = shape;
        this.x = 4;
        this.y = 0;
    }

    public void moveDown() {
        y++;
    }
    public void moveLeft() {
        x--;
    }
    public void moveRight() {
        x++;
    }

    public void rotate() {
        int n = shape.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = shape[i][j];
            }
        }
        shape = rotated;
    }

    public int[][] getShape() {
        return shape;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}