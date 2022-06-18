import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ticktacktoe {
    public static void main(String[] args) {

        char[][] gameBoard = new char[3][3];
        // The matrix is ​​filled with spaces '_'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = '_';
            }
        }

        boolean moveCounter = true;
        while(true) {
            printBoard(gameBoard);

            // to insert coordinates
            boolean insert = insertCoordinates(gameBoard, moveCounter);

            // for player change
            if (insert) {
                moveCounter = !moveCounter;
            }

            // to analyze the game
            boolean isFinished = isGameFinished(gameBoard);

            if (!isFinished) {
                boolean status = spacesBlank(gameBoard);
                if (status) {
                    continue;
                } else {
                    printBoard(gameBoard);
                    System.out.println("draw");
                }
            }

            break;
        }
    }

    private static void printBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.println("|" + " " + gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2] + " " + "|");
        System.out.println("|" + " " + gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2] + " " + "|");
        System.out.println("---------");
    }

    public static boolean insertCoordinates(char[][] gameBoard, boolean moveCounter) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coordinates: ");
        String indexX = scanner.next();
        String indexY = scanner.next();

        char x = 'X';
        char o = 'O';

        if (!indexX.matches("[+-]?\\d*(\\.\\d+)?") || !indexY.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("You should enter numbers!");
        } else if (parseInt(indexX) < 1 || parseInt(indexX) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else if (parseInt(indexY) < 1 || parseInt(indexY) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else if (gameBoard[parseInt(indexX) - 1][parseInt(indexY) - 1] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            if (moveCounter) {
                gameBoard[parseInt(indexX) - 1][(parseInt(indexY)) - 1] = x;
            } else {
                gameBoard[parseInt(indexX) - 1][(parseInt(indexY)) - 1] = o;
            }
            return true;
        }
        return false;
    }

    public static boolean spacesBlank(char[][] gameBoard) {
        for (char[] chars: gameBoard) {
            for (char aChar: chars) {
                if (aChar == '_' || aChar == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private static Boolean isGameFinished(char[][] gameBoard) {
        if (isTheWinner(gameBoard, 'X')) {
        printBoard(gameBoard);
            System.out.println("X wins");
            return true;
        }
        if (isTheWinner(gameBoard, 'O')) {
        printBoard(gameBoard);
            System.out.println("O wins");
            return true;
        }

        return false;
    }

    private static boolean isTheWinner(char[][] gameBoard, char symbol) {
        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
            (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
            (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||

            (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
            (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
            (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||

            (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
            (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);


    }
}