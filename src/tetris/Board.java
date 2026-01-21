package tetris;

public class Board {
    private final int width = 10;
    private final int height = 20;
    private int[][] grid;

    public Board() {
        grid = new int[height][width];
    }

    public void render(Tetromino piece, int score) {

        for (int i = 0; i < height; i++) System.out.println();

        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                if (isPieceAt(x, y, piece)) {
                    System.out.print("[]");
                } else if (grid[y][x] != 0) {
                    System.out.print("##");
                } else {
                    System.out.print(" .");
                }
                }
                System.out.println("|");
            }
            System.out.println("----------------------");
            System.out.println("Score: " + score);
            }
            private boolean isPieceAt(int gridX, int gridY, Tetromino p) {
                int[][] shape = p.getShape();
                int pieceX = p.getX();
                int pieceY = p.getY();

                if (gridX >= pieceX && gridX < pieceX + shape[0].length &&
                    gridY >= pieceY && gridY < pieceY + shape.length) {
                    return shape[gridY - pieceY][gridX - pieceX] != 0;
                }
                return false;
            }

            public boolean canMove(Tetromino p, int nextX, int nextY) {
        int[][] shape = p.getShape();
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    int targetX = nextX + col;
                    int targetY = nextY + row;

                    if (targetY < 0) continue;

                    if (targetX < 0 || targetX >= width || targetY >= height) {
                        return false;
                    }

                    if (grid[targetY][targetX] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public void freezePiece(Tetromino p) {
        int[][] shape = p.getShape();
        int pieceX = p.getX();
        int pieceY = p.getY();

        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    int targetX = pieceX + col;
                    int targetY = pieceY + row;
                    if (targetY >= 0 && targetY < height && targetX >= 0 && targetX < width) {
                        grid[targetY][targetX] = 1;
                    }
                }
            }
        }
    }

    public int clearLines() {
    int linesCleared = 0;
    
    for (int y = height - 1; y >= 0; y--) {
        boolean fullLine = true;
        for (int x = 0; x < width; x++) {
            if (grid[y][x] == 0) {
                fullLine = false;
                break;
            }
        }

        if (fullLine) {
            for (int row = y; row > 0; row--) {
                System.arraycopy(grid[row - 1], 0, grid[row], 0, width);
            }
            for (int x = 0; x < width; x++) {
                grid[0][x] = 0;
            }
            
            linesCleared++;
            
            y++; 
        }
    }
    return linesCleared;
    } 
}
