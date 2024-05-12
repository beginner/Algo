package org.example.string;

import java.util.HashMap;

public class IsoMorphicString_105 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            char q = t.charAt(i);

            if (map1.containsKey(p)) {
                if (map1.get(p) != q) return false;
            }
            if (map2.containsKey(q)) {
                if (map2.get(q) != p) return false;
            }
            map1.put(p, q);
            map2.put(q, p);

        }

        return true;
    }
}
