package org.example.array;

import java.util.HashMap;

public class CountFrequency_3005 {

    /**
     * Single pass O(N)
     * @param nums
     * @return
     */
    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int existing = map.getOrDefault(num, 0);
            int temp = existing + 1;
            map.put(num, temp);
            if (temp > max) {
                max = temp;
                count = max;
            } else if (max == temp) {
                count += max;
            }


        }
        return count;




    }
}
