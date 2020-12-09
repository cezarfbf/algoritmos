import java.util.*;
import java.io.*;
import java.math.*;

public class SevenSegment {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();

        List<String> numbList = new ArrayList();
        String numbRep = new String();
        int count = 0;

        for (int i=0; i < line1.length(); i++){
            String firstLineCh = String.valueOf(line1.charAt(i));
            String secondtLineCh = String.valueOf(line2.charAt(i));
            String thirdLineCh = String.valueOf(line3.charAt(i));

            numbRep = numbRep.concat(firstLineCh+""+secondtLineCh+""+thirdLineCh).trim();

            if(++count == 3) {
                numbList.add(numbRep);
                numbRep = "";
                count = 0;
            }
        }
        System.out.println(convertRepresantationToNumbers(numbList));
    }

    private static String convertRepresantationToNumbers(List<String> numbList) {
        String numbers = "";

        for (String rep : numbList) {
            switch (rep) {
                case "||_ _ ||":
                    numbers = numbers.concat("0");
                    break;
                case "||":
                    numbers = numbers.concat("1");
                    break;
                case "|___ |":
                    numbers = numbers.concat("2");
                    break;
                case "___ ||":
                    numbers = numbers.concat("3");
                    break;
                case "| _ ||":
                    numbers = numbers.concat("4");
                    break;
                case "|___  |":
                    numbers = numbers.concat("5");
                    break;
                case "||___  |":
                    numbers = numbers.concat("6");
                    break;
                case "_ ||":
                    numbers = numbers.concat("7");
                    break;
                case "||___ ||":
                    numbers = numbers.concat("8");
                    break;
                case "|___ ||":
                    numbers = numbers.concat("9");
                    break;
            }
//            System.err.println("Debug messages: "+numbers);

        }
        return numbers;
    }
}
