package array.manipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    /*
    Two Sum: Given an array of integers and a target value, find two numbers in the
    array that add up to the target. Return their indices. Example: [2, 7, 11, 15],
    target: 9 → Output: [0, 1] (indices of 2 and 7).
    */

    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement is present in the HashMap, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, add the number and its index to the HashMap
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array
        return new int[] {};
    }

    public int[] twoSumStream(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        return IntStream.range(0, nums.length)
                .filter(i -> {
                    int complement = target - nums[i];
                    if (map.containsKey(complement)) {
                        return true;
                    }
                    map.put(nums[i], i);
                    return false;
                })
                .mapToObj(i -> new int[] { map.get(target - nums[i]), i })
                .findFirst()
                .orElse(new int[] {});
    }
}
