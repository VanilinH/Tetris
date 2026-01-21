package tetris;
import java.util.Scanner;
import java.util.Random; 

public class Main {
    private static final int[][][] ALL_SHAPES = {
        {{1, 1, 1, 1}}, // I
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
        Menu();
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("1")) runGame(scanner);
        else if (choice.equals("2")) System.exit(0);
        else {
            System.out.println("Invalid choice. Exiting.");
            System.exit(0);
        }
    }

    private static void runGame(Scanner scanner) {
        Board board = new Board();
        Random random = new Random();
        Tetromino currentPiece = new Tetromino(ALL_SHAPES[random.nextInt(ALL_SHAPES.length)]);

        while (true) {
            board.render(currentPiece);
            System.out.println("Controls: ");
            System.out.println("a - left, d - right, s - down, w - rotate, q - quit to menu");
            String input = scanner.nextLine();

            if (input.equals("q")) return;
        }
    }
}
