package org.example.array;

import java.util.*;

public class ArrayIntersection_349 {


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;

        final List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }
        return list.stream().mapToInt(num -> num).toArray();
    }

    public int[] intersection_2(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();


        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j=0;

        while ( i < nums1.length && j < nums2.length) {
            if( nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;

            } else if ( nums1[i] > nums2[j]) {
                j++;
            } else i++;

        }

        int[] res = new int[result.size()];
        i = 0;
        for(int t : result) {
            res[i++] = t;
        }
        return res;
    }

}
