package tetris;
// Class representing a Tetromino piece
public class Tetromino {
    private int[][] shape; // shape array
    private int x, y; // position on the board
// Constructor to initialize Tetromino with a shape
    public Tetromino(int[][] shape) {
        this.shape = shape;
        this.x = 4;
        this.y = 0;
    }
// Move the piece down by one unit
    public void moveDown() {
        y++;
    }
// Move the piece left by one unit
    public void moveLeft() {
        x--;
    }
// Move the piece right by one unit
    public void moveRight() {
        x++;
    }
// Rotate the piece clockwise
    public Tetromino rotate() {
        int rows = shape.length;
        int cols = shape[0].length;
        int[][] rotatedShape = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedShape[j][rows - 1 - i] = shape[i][j];
            }
        }
        Tetromino rotated = new Tetromino(rotatedShape);
        rotated.x = this.x;
        rotated.y = this.y;
        return rotated;
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
