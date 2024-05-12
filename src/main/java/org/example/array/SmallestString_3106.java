package org.example.array;

/**
 * Medium
 * https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/description/
 *
 */
public class SmallestString_3106 {

    public static void main(String[] args) {
        String s = "zbbz";
        int k = 3;
        SmallestString_3106 problem = new SmallestString_3106();
        System.out.println(problem.getSmallestString(s, k));
//        char test = 'y';
//            int distance = Math.min(test - 'a', 'z' - test + 1);
//        System.out.println(distance);

    }
    public String getSmallestString(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (k <= 0) break;

            char c = arr[i];
            int distance = Math.min(c - 'a', 'z' - c + 1);
            if (distance <= k || distance == 0) {
                arr[i] = 'a';
                k -= distance;
            } else { // cannot go to 'a
                char t = (char) (c - k);
                arr[i] = t ;
                k = 0;
            }
        }



        return new String(arr);
    }

}
