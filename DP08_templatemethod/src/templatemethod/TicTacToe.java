package templatemethod;

import java.util.Scanner;

/**
 * A game for two players, who take turns marking the spaces in a 3×3 grid. The
 * player who succeeds in placing three of their marks in a horizontal,
 * vertical, or diagonal row wins the game.
 *
 * @author Antti Nieminen
 */
public class TicTacToe extends Game {

    private char[][] drawnBoard;
    private int boardWidth = 3;
    private int boardHeight = 3;
    private int winRowLength = 3;
    private int winner = 0;
    private char[] squares;
    private boolean endOfGame = false;
    Scanner scanner = new Scanner(System.in);

    @Override
    void initializeGame() {
        if (super.playersCount > 2) {
            endOfGame = true;
            System.out.println("Too many players!");
        } else {
            drawnBoard = new char[boardHeight * 2 - 1][boardWidth * 2 - 1];
            squares = new char[boardHeight * boardWidth];
            for (int i = 0; i < squares.length; i++) {
                squares[i] = (char) (i + '1');
            }
            drawBoard();
        }
    }

    /**
     * Draw the game board to the console.
     */
    private void drawBoard() {
        initializeBoard();
        System.out.println();
        for (int i = 0; i < drawnBoard.length; i++) {
            for (int j = 0; j < drawnBoard[0].length; j++) {
                System.out.print(drawnBoard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Initialize the board by putting ASCII graphics to the border array.
     */
    private void initializeBoard() {
        char verticalBorder = '|';
        char horizontalBorder = '-';
        char crossBorder = '+';
        int counter = 0;

        for (int i = 0; i < drawnBoard.length; i++) {
            for (int j = 0; j < drawnBoard[0].length; j++) {
                if (!(i == 0 | i % 2 == 0)) {
                    if (!(j == 0 | j % 2 == 0)) {
                        drawnBoard[i][j] = horizontalBorder;
                    } else {
                        drawnBoard[i][j] = horizontalBorder;
                    }
                } else if ((j == 0 | j % 2 == 0)) {
                    drawnBoard[i][j] = (char) squares[counter];
                    counter++;
                } else if (!(j == 0 | j % 2 == 0)) {
                    drawnBoard[i][j] = (char) verticalBorder;
                }
            }
        }

    }

    /**
     * Players take turns to place markers to the board.
     */
    @Override
    void makePlay(int player) {
        System.out.printf("Player %d make your move (q quits): ", player);
        int square = -1;
        boolean validNumberEntered = false;
        while (!validNumberEntered) {
            String entry = scanner.nextLine();
            if (entry.equals("q")) {
                endOfGame = true;
                return;
            }
            try {
                square = Integer.parseInt(entry);
                if (square > squares.length) {
                    System.out.print("Please enter a number between 1 and " + squares.length + ": ");
                } else {
                    if (!Character.isDigit(squares[square - 1])) {
                        System.out.print("Please enter a squarenumber that has space: ");
                    } else {
                        validNumberEntered = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.print("Please enter valid number: ");
            }
        }

        if (player == 1) {
            squares[square - 1] = 'X';
        } else if (player == 2) {
            squares[square - 1] = 'O';
        }

        drawBoard();
        if (checkAdjacentSquaresIfWinConditionIsMet(square)) {
            endOfGame = true;
            winner = player;
        }

    }

    /**
     * Check the board for horizontal, vertical and diagonal lines of X's and
     * O's starting from the square that is given as a parameter
     */
    private boolean checkAdjacentSquaresIfWinConditionIsMet(int square) {
        // Select whether X or O is the one to be checked
        char markerToCheck = squares[square - 1];
        // How many adjancent markers found for said direction
        int markersFound = 1;
        // An arrayboard to help checking the adjancent squares
        char[][] board = new char[boardHeight][boardWidth];
        // The coordinate of the square given as parameter in the board
        int x = 0;
        int y = 0;

        // Map the squares array to the two-dimensional array
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = squares[i * boardWidth + j];
            }
        }

        // Find out the coordinate of the square in the board
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (square - 1 == i * boardWidth + j) {
                    x = j;
                    y = i;
                }
            }
        }

        // Check horizontal line for win condition
        markersFound = checkLeft(markersFound, board, x, y, markerToCheck, 1);
        markersFound = checkRight(markersFound, board, x, y, markerToCheck, 1);
        if (markersFound == winRowLength) {
            return true;
        }

        // Check vertical line for win condition
        markersFound = 1;
        markersFound = checkUp(markersFound, board, x, y, markerToCheck, 1);
        markersFound = checkDown(markersFound, board, x, y, markerToCheck, 1);
        if (markersFound == winRowLength) {
            return true;
        }

        // Check the diagonal lines for win condition
        markersFound = 1;
        markersFound = checkUpLeft(markersFound, board, x, y, markerToCheck, 1);
        markersFound = checkDownRight(markersFound, board, x, y, markerToCheck, 1);
        if (markersFound == winRowLength) {
            return true;
        }
        markersFound = 1;
        markersFound = checkUpRight(markersFound, board, x, y, markerToCheck, 1);
        markersFound = checkDownLeft(markersFound, board, x, y, markerToCheck, 1);
        if (markersFound == winRowLength) {
            return true;
        }

        return false;
    }

    /**
     * A recursive function to check how many adjacent markers are found to the
     * left of x and y
     */
    private int checkLeft(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (x - depth >= 0 && board[y][x - depth] == markerToCheck) {
            markersFound++;
            depth++;
            return checkLeft(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    /**
     * A recursive function to check how many adjacent markers are found to the
     * right of x and y
     */
    private int checkRight(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (x + depth < boardWidth && board[y][x + depth] == markerToCheck) {
            markersFound++;
            depth++;
            return checkRight(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    /**
     * A recursive function to check how many adjacent markers are found to
     * upwards of x and y
     */
    private int checkUp(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (y - depth >= 0 && board[y - depth][x] == markerToCheck) {
            markersFound++;
            depth++;
            return checkUp(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    /**
     * A recursive function to check how many adjacent markers are found to
     * downwards of x and y
     */
    private int checkDown(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (y + depth < boardHeight && board[y + depth][x] == markerToCheck) {
            markersFound++;
            depth++;
            return checkDown(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    /**
     * A recursive function to check how many adjacent markers are found to the
     * up and left of x and y
     */
    private int checkUpLeft(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (y - depth >= 0 && x - depth >= 0 && board[y - depth][x - depth] == markerToCheck) {
            markersFound++;
            depth++;
            return checkUpLeft(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    /**
     * A recursive function to check how many adjacent markers are found to the
     * down and right of x and y
     */
    private int checkDownRight(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (y + depth < boardHeight && x + depth < boardWidth && board[y + depth][x + depth] == markerToCheck) {
            markersFound++;
            depth++;
            return checkDownRight(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    /**
     * A recursive function to check how many adjacent markers are found to the
     * up and right of x and y
     */
    private int checkUpRight(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (y - depth >= 0 && x + depth < boardWidth && board[y - depth][x + depth] == markerToCheck) {
            markersFound++;
            depth++;
            return checkUpRight(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    private int checkDownLeft(int markersFound, char[][] board, int x, int y, char markerToCheck, int depth) {
        if (y + depth < boardHeight && x - depth >= 0 && board[y + depth][x - depth] == markerToCheck) {
            markersFound++;
            depth++;
            return checkDownLeft(markersFound, board, x, y, markerToCheck, depth);
        }
        return markersFound;
    }

    @Override
    boolean endOfGame() {
        return endOfGame;
    }

    @Override
    void printWinner() {
        if (winner != 0) {
            System.out.println("Player " + winner + " is the winner!");
        }
    }

}
