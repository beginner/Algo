package org.example.math;

/**
 * Medium
 * https://leetcode.com/problems/water-bottles-ii/
 */
public class WaterBottles2_3100 {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            sum++;
            empty -= numExchange;
            numExchange++;
            empty++;
        }
        return sum;
    }
}
