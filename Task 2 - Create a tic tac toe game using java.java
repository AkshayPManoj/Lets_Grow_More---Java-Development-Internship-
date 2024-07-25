//Task 2 - Create a tic tac toe game using java

import java.util.Random;
import java.util.Scanner;

public class TicTacToe 
{

    private static char[][] board = new char[3][3]; // 3x3 Tic-Tac-Toe board
    private static char currentPlayer = 'X'; // Player X starts the game
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) 
    {
        initializeBoard();

        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean gameEnded = false;
        while (!gameEnded) 
        {
            displayBoard();

            if (currentPlayer == 'X') 
            {
                playerMove();
            } else 
            {
                computerMove();
            }

            // Check if game is over
            if (isGameOver()) 
            {
                gameEnded = true;
                displayBoard();
                if (currentPlayer == 'X') 
                {
                    System.out.println("Congratulations! You win!");
                } else {
                    System.out.println("Computer wins! Better luck next time.");
                }
            } 
            else if (isBoardFull()) 
            {
                gameEnded = true;
                displayBoard();
                System.out.println("It's a draw!");
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Initialize the board with empty spaces
    private static void initializeBoard() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current board state
    private static void displayBoard() 
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) 
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) 
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Player's move
    private static void playerMove() 
    {
        boolean validMove = false;
        while (!validMove) 
        {
            System.out.print("Enter your move (row[1-3] column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline after nextInt()

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') 
            {
                board[row][col] = currentPlayer;
                validMove = true;
            } 
            else 
            {
                System.out.println("Invalid move! Please try again.");
            }
        }
    }

    // Computer's move (AI)
    private static void computerMove() 
    {
        // Simple AI: Randomly choose an empty cell
        boolean validMove = false;
        while (!validMove) 
        {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (board[row][col] == ' ') 
            {
                board[row][col] = currentPlayer;
                validMove = true;
            }
        }
        System.out.println("Computer played: ");
    }

    // Check if the game is over (someone wins or draw)
    private static boolean isGameOver() 
    {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    // Check if any row has all three cells equal
    private static boolean checkRows() 
    {
        for (int i = 0; i < 3; i++) 
        {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') 
            {
                return true;
            }
        }
        return false;
    }

    // Check if any column has all three cells equal
    private static boolean checkColumns() 
    {
        for (int j = 0; j < 3; j++) 
        {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') 
            {
                return true;
            }
        }
        return false;
    }

    // Check if any diagonal has all three cells equal
    private static boolean checkDiagonals() 
    {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
    }

    // Check if the board is full (draw condition)
    private static boolean isBoardFull() 
    {
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if (board[i][j] == ' ') 
                {
                    return false;
                }
            }
        }
        return true;
    }
}
