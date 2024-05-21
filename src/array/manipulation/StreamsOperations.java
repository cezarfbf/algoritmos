package array.manipulation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsOperations {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(2, 3, 4, 1, 5, 2, 3);
        List<String> fruits = Arrays.asList("cherry", "banana", "coconut", "berry", "apple");

        Integer sum = getSum(integers);
        System.out.println("sum: " + sum);

        Integer max = findMaximumElement(integers);
        System.out.println("max: " + max);

        long countOdds = countOddNumbers(integers);
        System.out.println("countOdds: " + countOdds);

        long countFruits = countStartingWithLetter("b", fruits);
        System.out.println("countFruits: " + countFruits);

        String concatenatedFruits = concatenateWith(",",fruits);
        System.out.println("concatenatedFruits: " + concatenatedFruits);

        List<Integer> noDuplicates = removeDuplicatedValues(integers);
        System.out.println("noDuplicates: " + noDuplicates);

        String testA = "TestA";
        String testB = "TestB";
        testA = testB;
        System.out.println(testB);
        System.out.println(testA);


    }

    private static List<Integer> removeDuplicatedValues(List<Integer> integers) {
        return integers.stream().distinct().collect(Collectors.toList());
    }

    private static String concatenateWith(String delimiter, List<String> values) {
        return values.stream().collect(Collectors.joining(delimiter));
    }

    private static long countOddNumbers(List<Integer> integers) {
        return integers.stream().filter(i -> i % 2 == 1).count();
    }

    private static Integer getSum(List<Integer> integers) {

        return integers.stream().mapToInt(Integer::intValue).sum();
    }

    private static Integer findMaximumElement(List<Integer> integers) {

        return integers.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    private static long countStartingWithLetter(String letter, List<String> list) {

        return list.stream().filter(value -> value.startsWith(letter)).count();
    }
}
