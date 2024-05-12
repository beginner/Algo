package org.example.math;

/**
 * Medium
 * https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/description/
 *
 * The problem asks to count number of substring starting and ending with a character.
 * it does not matter what characters are between that character.
 * If we have n characters, then count is (n * (n + 1 )) / 2
 */
public class CountSubstring_3084 {

    public long countSubstrings(String s, char c) {
        int count = 0;

        for (char t : s.toCharArray()) {
            if (c == t) count++;
        }

        return 1L * count * (count + 1) / 2;
    }

    public long countSubstrings_WithoutFormula(String s, char c) {
        long ans = 0l;

        int count = 0;
        for (char t : s.toCharArray()) {
            if (t == c) {
                count++;
                ans += count;
            }
        }
        return ans;
    }
}
