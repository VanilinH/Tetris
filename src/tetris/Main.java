package tetris;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int[][][] ALL_SHAPES = {
        {{0, 0, 0, 0},{1, 1, 1, 1},{0, 0, 0, 0},{0, 0, 0, 0}}, // I
        {{1, 1}, {1, 1}}, // O
        {{0, 1, 0}, {1, 1, 1}}, // T
        {{1, 0, 0}, {1, 1, 1}}, // J
        {{0, 0, 1}, {1, 1, 1}}, // L
        {{1, 1, 0}, {0, 1, 1}}, // S
        {{0, 1, 1}, {1, 1, 0}}  // Z
    };

    private static void Menu() {
        System.out.println("----- TETRIS ----");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu();
            String choice = scanner.nextLine();
            if (choice.equals("1")) runGame(scanner);
            else if (choice.equals("2")) System.exit(0);
            else {
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
            }
        }
    }

    private static void runGame(Scanner scanner) {
        Board board = new Board();
        Random random = new Random();
        int score = 0;
        Tetromino currentPiece = new Tetromino(ALL_SHAPES[random.nextInt(ALL_SHAPES.length)]);

        while (true) {
            board.render(currentPiece, score);
            System.out.println("Controls: ");
            System.out.println("a - left, d - right, s - down, w - rotate, q - quit to menu");
            String input = scanner.nextLine();

            if (input.equals("q")) return;
            if (input.equals("a")) {
                if (board.canMove(currentPiece, currentPiece.getX() - 1, currentPiece.getY())) {
                    currentPiece.moveLeft();
                }
            }
            if (input.equals("d")) {
                if (board.canMove(currentPiece, currentPiece.getX() + 1, currentPiece.getY())) {
                    currentPiece.moveRight();
                }
            }
            if (input.equals("s")) {
                if (board.canMove(currentPiece, currentPiece.getX(), currentPiece.getY() + 1)) {
                    currentPiece.moveDown();
                } else {
                    board.freezePiece(currentPiece);
                    int cleared = board.clearLines();
                    if (cleared == 1) score += 100;
                    else if (cleared == 2) score += 300;
                    else if (cleared == 3) score += 500;
                    else if (cleared >= 4) score += 800;
                    currentPiece = new Tetromino(ALL_SHAPES[random.nextInt(ALL_SHAPES.length)]);
                    if (!board.canMove(currentPiece, currentPiece.getX(), currentPiece.getY())) {
                        board.render(currentPiece, score);
                        System.out.println("Game Over!, Your Score: " + score);
                        System.out.println("Press Enter to return to menu...");
                        scanner.nextLine();
                        return;
                    }
                }
            }
            if (input.equals("w")) {
                Tetromino rotated = currentPiece.rotate();
                if (board.canMove(rotated, rotated.getX(), rotated.getY())) {
                    currentPiece = rotated;
                }
            }
        }
    }
}
