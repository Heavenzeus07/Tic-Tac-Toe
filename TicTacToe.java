import java.util.Scanner;

public class TicTacToe {
    static char[] square = { 'o', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static void main(String[] args) {
        int player = 1; // Player 1 starts
        int status; // Game status (win, draw, or ongoing)
        int choice; // Player's chosen cell
        char mark; // Current player's marker (X or O)

        Scanner scanner = new Scanner(System.in);

        do {
            // Display the current board
            displayBoard();

            // Determine the current player
            player = (player % 2 != 0) ? 1 : 2;
            System.out.print("   Player " + player + ", enter a number: ");
            choice = scanner.nextInt();

            // Assign marker based on the player
            mark = (player == 1) ? 'X' : 'O';

            // Validate and mark the board
            if (choice >= 1 && choice <= 9 && square[choice] == (char) ('0' + choice)) {
                square[choice] = mark;
            } else {
                System.out.println("   Invalid move. Try again.");
                player--; // Retry the same player
            }

            // Check the game status
            status = checkWin();

            // Switch to the next player
            player++;
        } while (status == -1);

        // Display the final board
        displayBoard();

        // Announce the result
        if (status == 1) {
            System.out.println("   ==> Player " + (--player) + " wins!");
        } else {
            System.out.println("   ==> It's a draw!");
        }

        scanner.close();
    }

    static int checkWin() {
        // Check rows
        if (square[1] == square[2] && square[2] == square[3]) return 1;
        if (square[4] == square[5] && square[5] == square[6]) return 1;
        if (square[7] == square[8] && square[8] == square[9]) return 1;

        // Check columns
        if (square[1] == square[4] && square[4] == square[7]) return 1;
        if (square[2] == square[5] && square[5] == square[8]) return 1;
        if (square[3] == square[6] && square[6] == square[9]) return 1;

        // Check diagonals
        if (square[1] == square[5] && square[5] == square[9]) return 1;
        if (square[3] == square[5] && square[5] == square[7]) return 1;

        // Check for draw
        boolean draw = true;
        for (int i = 1; i <= 9; i++) {
            if (square[i] == (char) ('0' + i)) {
                draw = false;
                break;
            }
        }
        if (draw) return 0;

        // Game is still ongoing
        return -1;
    }

    static void displayBoard() {
        System.out.println("\n\n   -----------------------------");
        System.out.println("\t      Tic Tac Toe");
        System.out.println("   -----------------------------\n");
        System.out.println("   Player 1 (X)  -  Player 2 (O)\n");

        System.out.println("   -----------------------------");
        System.out.println("\t|     |     |     |");
        System.out.println("\t|  " + square[1] + "  |  " + square[2] + "  |  " + square[3] + "  |");
        System.out.println("\t|_____|_____|_____|");
        System.out.println("\t|     |     |     |");
        System.out.println("\t|  " + square[4] + "  |  " + square[5] + "  |  " + square[6] + "  |");
        System.out.println("\t|_____|_____|_____|");
        System.out.println("\t|     |     |     |");
        System.out.println("\t|  " + square[7] + "  |  " + square[8] + "  |  " + square[9] + "  |");
        System.out.println("\t|     |     |     |");
        System.out.println("   -----------------------------\n");
    }
}
