package org.example.array;

import java.util.Arrays;

public class MaximizeHappiness_3075 {


    /**
     * Time -> O(HlogH) + O(k)
     * @param happiness
     * @param k
     * @return
     */
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int minus = 0;
        int index = happiness.length - 1;
        long total = 0l;
        while(k-- > 0) {
            total += Math.max(0, happiness[index--] - minus++);
        }
        return total;
    }
}
