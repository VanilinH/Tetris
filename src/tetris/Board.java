package tetris;

public class Board {
    private final int wigth = 10;
    private final int height = 20;
    private int[][] grid;

    public Board() {
        grid = new int[height][wigth];
    }

    public void render(Tetromino piece) {

        for (int i = 0; i < height; i++) System.println();

        for (int y = 0; y < height; y++) {
            System.print("|");
            for (int x = 0; x < width; x++) {
                if (isPieceAt(x, y, piece)) {
                    System.out.print("[]");
                } else if (grind[y][x] != 0) {
                    System.out.print("##")
                } else {
                    System.out.print(" .");
                }
                }
                System.out.println("|");
            }
            System.out.println("----------");
            }
            private boolean isPieceAt(int gridX, int gridY, Tetromino p) {
                
            }
        }
            
    }
}