import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class BinarySearchBatman {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int currPosLargX = in.nextInt();
        int currPosAltY = in.nextInt();

        System.err.println("Largura: "+W);
        System.err.println("Altura: "+H);
        System.err.println("Pulos: "+N);
        System.err.println("pos init X: "+currPosLargX);
        System.err.println("pos init Y: "+currPosAltY);

        // top left corner
        int leftLimit = 0, rightLimit = W - 1; // range do eixo largura
        int topLimit = 0,  bottomLimit = H - 1; // range do eixo altura

        // se não tiver a posição inicial, pulo para o centro
        //X0 = (right) / 2;
        //Y0 = (bottom) / 2;
        //System.out.println(X0 + " " + YH);

        // game loop
        while (true) {

            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            System.err.println("bombDir: "+bombDir);

            // Write an action using System.out.println()
            // A atribuição das posições dependem de qual extremidade está o indice (0,0). Nesse caso "top left corner"
            if (bombDir.length() > 1) { // not linear direction - altera os dois eixos opostos
                if (bombDir.charAt(1) == 'L') { // UL or DL - to the left
                    rightLimit = currPosLargX - 1; //a ultima posição a direita recebe a pos atual, do eixo larg, MENOS 1. Delimita a direita
                } else if (bombDir.charAt(1) == 'R') { // UR or DR - to the right
                    leftLimit = currPosLargX + 1; //a ultima posição a esquerda recebe a pos atual, do eixo larg, MAIS 1. Delimita a esquerda
                }
                if (bombDir.charAt(0) == 'U') { // UR or UL - to the top
                    bottomLimit = currPosAltY - 1;
                } else { // DL or DR - to the bottom
                    topLimit = currPosAltY + 1;
                }
            } else { // linear direction - só altera a direção contrária
                if (bombDir.charAt(0) == 'L') {
                    rightLimit = currPosLargX - 1;
                } else if (bombDir.charAt(0) == 'R') {
                    leftLimit = currPosLargX + 1;
                } else if (bombDir.charAt(0) == 'U') {
                    bottomLimit = currPosAltY - 1;
                } else {
                    topLimit = currPosAltY + 1;
                }
            }
            //rule: dividir o range por 2 para achar o centro
            currPosLargX = (rightLimit + leftLimit) / 2;
            currPosAltY = (bottomLimit + topLimit) / 2;
            System.err.println("leftLimit:"+leftLimit + " " + "rightLimit:"+rightLimit + " " + "topLimit:"+topLimit + " " + "bottomLimit:"+bottomLimit);

            // the location of the next window Batman should jump to.
            System.out.println(currPosLargX + " " + currPosAltY); // Actually, her is the next pos to jump.
        }
    }
}