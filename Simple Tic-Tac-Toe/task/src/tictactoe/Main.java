package tictactoe;

import java.util.Scanner;

public class Main {
    private static final char[][] gamePlan = new char[3][3];
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean xTurn;

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gamePlan[i][j] = ' ';
            }
        }

        xTurn = true;
        drawGamePlan();

        while (checkGameState()) {
            makeAMove();
            drawGamePlan();
            xTurn = !xTurn;
        }
    }

    public static void makeAMove() {
        System.out.print("Enter the coordinates: ");
        String userMoveVerticalInput = scanner.next();
        String userMoveHorizontalInput = scanner.next();

        if (!isValidInput(userMoveVerticalInput) || !isValidInput(userMoveHorizontalInput)) {
            System.out.println("You should enter numbers!");
            makeAMove();

        } else {
            int userMoveV = Integer.parseInt(userMoveVerticalInput);
            int userMoveH = Integer.parseInt(userMoveHorizontalInput);

            if (userMoveV < 1 || userMoveV > 3 || userMoveH < 1 || userMoveH > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                makeAMove();
            } else if (gamePlan[userMoveV -1][userMoveH -1] == 'X' || gamePlan[userMoveV -1][userMoveH -1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                makeAMove();
            } else if (xTurn) {
                gamePlan[userMoveV - 1][userMoveH - 1] = 'X';
            } else if (!xTurn) {
                gamePlan[userMoveV - 1][userMoveH - 1] = 'O';
            }
        }
    }

    private static boolean isValidInput(String str) {
        return str != null && str.matches("[0-9]");
    }

    public static boolean checkGameState() {
        boolean threeXInARow = false;
        boolean threeOInARow = false;
        boolean gridHasEmptyCells;
        boolean differenceTooBig;

        int X = 0;
        int O = 0;
        int emptyCount = 0;

        int XInARowDiagonalCount = 0;
        int OInARowDiagonalCount = 0;

        for (int i = 0; i < 3; i++) {

            if (gamePlan[i][i] == 'X') {
                XInARowDiagonalCount += 1;
                if (XInARowDiagonalCount == 3) {
                    threeXInARow = true;
                }
            } else if (gamePlan[i][i] == 'O') {
                OInARowDiagonalCount += 1;
                if (OInARowDiagonalCount == 3) {
                    threeOInARow = true;
                }
            }

            int XInARowHorizontalCount = 0;
            int OInARowHorizontalCount = 0;

            for (int j = 0; j < 3; j++) {
                if (gamePlan[i][j] == 'X') {
                    X += 1;
                    XInARowHorizontalCount += 1;
                    if (XInARowHorizontalCount == 3) {
                        threeXInARow = true;
                    }
                } else if (gamePlan[i][j] == 'O') {
                    O += 1;
                    OInARowHorizontalCount += 1;
                    if (OInARowHorizontalCount == 3) {
                        threeOInARow = true;
                    }
                } else if (gamePlan[i][j] == ' ' || gamePlan[i][j] == '_') {
                    emptyCount += 1;
                }
            }
        }

        int XInARowAntiDiagonalCount = 0;
        int OInARowAntiDiagonalCount = 0;

        for (int j= 0; j < 3; j++) {

            if (gamePlan[j][2-j] == 'X') {
                XInARowAntiDiagonalCount += 1;
                if (XInARowAntiDiagonalCount == 3) {
                    threeXInARow = true;
                }
            } else if (gamePlan[j][2-j] == 'O') {
                OInARowAntiDiagonalCount += 1;
                if (OInARowAntiDiagonalCount == 3) {
                    threeOInARow = true;
                }
            }

            int XInARowVerticalCount = 0;
            int OInARowVerticalCount = 0;

            for (int i = 0; i < 3; i++) {
                if (gamePlan[i][j] == 'X') {
                    XInARowVerticalCount += 1;
                    if (XInARowVerticalCount == 3) {
                        threeXInARow = true;
                    }
                } else if (gamePlan[i][j] == 'O') {
                    OInARowVerticalCount += 1;
                    if (OInARowVerticalCount == 3) {
                        threeOInARow = true;
                    }
                }
            }
        }

        gridHasEmptyCells = emptyCount > 0;
        differenceTooBig = Math.abs(X - O) > 1;

        if (differenceTooBig || (threeOInARow && threeXInARow)) {
            System.out.println("Impossible");
            return false;
        } else if (!threeXInARow && !threeOInARow && gridHasEmptyCells) {
            return true; // Game not finished
        } else if (!threeXInARow && !threeOInARow && !gridHasEmptyCells) {
            System.out.println("Draw");
            return false;
        } else if (threeXInARow) {
            System.out.println("X wins");
            return false;
        } else if (threeOInARow) {
            System.out.println("O wins");
            return false;
        } else {
            System.out.println("Error!");
            return false;
        }
    }

    public static void drawGamePlan() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gamePlan[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
