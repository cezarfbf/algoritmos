// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class HouseCells
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        int statesCopy[] = IntStream.of(states).toArray();
        // WRITE YOUR CODE HERE
        while (days > 0){

            for(int i = 0; i < states.length; i++){
                if (i > 0 && i < states.length-1)
                   states[i] = statesCopy[i-1] == statesCopy[i+1] ? 0 : 1;
                else if (i == 0)
                    states[i] = statesCopy[i+1] == 0 ? 0 : 1;
                else
                    states[i] = statesCopy[i-1] == 0 ? 0 : 1;
            }
            statesCopy = IntStream.of(states).toArray();
            days -= 1;
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
    // METHOD SIGNATURE ENDS

//    public int generalizedGCD(int num, int[] arr)
//    {
//        // WRITE YOUR CODE HERE
//        BigInteger result;
//        result.
//        return Arrays.stream(arr).reduce(0, (x, y) -> gcd(x, y));
//    }

    public static void main(String[] args) {
        cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1).forEach(System.out::print);
    }
}