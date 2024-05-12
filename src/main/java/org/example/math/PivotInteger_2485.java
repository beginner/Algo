package org.example.math;

/**
 * Easy
 * https://leetcode.com/problems/find-the-pivot-integer/?envType=daily-question&envId=2024-03-13
 */
public class PivotInteger_2485 {

    public int pivotInteger_TP(int n) {
        if (n == 1) return 1;
        int leftSum = 1;
        int rightSum = n;
        int leftPtr = 1;
        int rightPtr = n;

        while (leftPtr < rightPtr) {
            if (leftSum < rightSum) {
                leftSum += ++leftPtr;
            } else {
                rightSum +=  --rightPtr;
            }

            if (leftSum == rightSum && leftPtr + 1 == rightPtr - 1) return leftPtr + 1;

        }
        return -1;
    }

    public int pivotInteger_BS(int n) {
        if (n == 1) return 1;
        int totalSum = (n *(n + 1)) / 2;

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (mid * mid == totalSum) {
                return mid;
            }
            if (mid * mid > totalSum) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return -1;

    }
}
