import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class CloseToZero {

    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(); // the number of temperatures to analyse
        List<Integer> temps = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            temps.add(in.nextInt());// a temperature expressed as an integer ranging from -273 to 5526
//            System.err.println("Debug messages:"+in.nextInt());
//        }

        temps.add(1);
        temps.add(-2);
        temps.add(-8);
        temps.add(4);
        temps.add(5);

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(getClosestToZero(temps));
    }

    private static String getClosestToZero(List<Integer> temps) {
        if(temps.isEmpty()) return "0";
        int closestIndex = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < temps.size(); i++) {
            int abs = Math.abs(temps.get(i));
            if (abs < diff) {
                closestIndex = i;
                diff = abs;
            } else if (abs == diff && temps.get(i) > 0 && temps.get(closestIndex) < 0) {
                //same distance to zero but positive
                closestIndex = i;
            }
        }
        return  temps.get(closestIndex).toString();
    }


}