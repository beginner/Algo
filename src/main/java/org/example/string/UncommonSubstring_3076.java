package org.example.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Medium
 * https://leetcode.com/problems/shortest-uncommon-substring-in-an-array/
 */
public class UncommonSubstring_3076 {

    public static void main(String[] args) {
        String[] arr = {"gfnt","xn","mdz","yfmr","fi","wwncn","hkdy"};
        UncommonSubstring_3076 problem = new UncommonSubstring_3076();
        System.out.println(problem.shortestSubstrings(arr));
    }
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        HashSet<String>[] substrings = new HashSet[n];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            substrings[i] = substrings(arr[i], map);
            for (String s : substrings[i]) {
                int existing = map.getOrDefault(s, 0);
                map.put(s, existing + 1);
            }
        }

        final String[] result = new String[n];

        for (int i = 0; i < arr.length; i++) {
            String candidate = null;
            for (String s : substrings[i]) {
                int existing = map.getOrDefault(s, 0);
                map.put(s, existing - 1);

                if (map.get(s) == 0) {
                    if (candidate == null || candidate.length() > s.length() || (s.compareTo(candidate) < 0 && s.length() == candidate.length())) {
                        candidate = s;
                    }
                }
            }
            for (String s : substrings[i]) {
                int existing = map.getOrDefault(s, 0);
                map.put(s, existing + 1);
            }
            result[i] = candidate == null ? "" : candidate;

        }

        return result;

    }

    private HashSet<String> substrings(String s, Map<String, Integer> map) {
        final HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);

                set.add(temp);
            }
        }
        return set;
    }
}
