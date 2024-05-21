import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        printGameBoard(gameBoard);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter your placement (1-9):");
            int pos = scanner.nextInt();
            System.out.print("Enter your sign (X or O):");
            String sign = scanner.next();

            writeInBoard(pos, sign, gameBoard);

        }
    }

    private static void writeInBoard(int pos, String sign, char[][] gameBoard) {

        switch (pos) {
            case 1:
                gameBoard[0][0] = sign.charAt(0);
                break;
            case 2:
                gameBoard[0][2] = sign.charAt(0);
                break;
            case 3:
                gameBoard[0][4] = sign.charAt(0);
                break;
            case 4:
                gameBoard[2][0] = sign.charAt(0);
                break;
            case 5:
                gameBoard[2][2] = sign.charAt(0);
                break;
            case 6:
                gameBoard[2][4] = sign.charAt(0);
                break;
            case 7:
                gameBoard[4][0] = sign.charAt(0);
                break;
            case 8:
                gameBoard[4][2] = sign.charAt(0);
                break;
            case 9:
                gameBoard[4][4] = sign.charAt(0);
                break;
            default:
                break;
        }

        printGameBoard(gameBoard);
    }

    private static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
