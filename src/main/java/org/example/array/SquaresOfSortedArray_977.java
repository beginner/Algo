package org.example.array;

import java.util.Arrays;

/**
 * Easy
 * https://leetcode.com/problems/squares-of-a-sorted-array/?envType=daily-question&envId=2024-03-02
 */
public class SquaresOfSortedArray_977 {

    /**
     * Use a two pointer approach one from 0th position and another from (N-1)th position, and fill the resulting array from (N-1)th position
     * Square of a negative number is positive.
     * Time -> O(N)
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        int write = n - 1;
        int[] result = new int[n];
        while (left <= right) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];

            if (b > a) {
                result[write] = b;
                right--;
            } else {
                result[write] = a;
                left++;
            }
            write--;
        }
        return result;

    }

    /**
     * Time -> O(NlogN) due to sorting.
     * @param nums
     * @return
     */
    public int[] sortedSquares__BruteForce(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
