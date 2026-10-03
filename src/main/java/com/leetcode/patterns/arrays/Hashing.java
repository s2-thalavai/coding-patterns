package com.leetcode.patterns.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Pattern 4: Hashing (frequency map / seen-set / group by canonical key).
 */
public final class Hashing {

    private Hashing() {
    }

    /** Store value -> index, look up the complement. LC 1. O(n). */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOf = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = indexOf.get(target - nums[i]);
            if (j != null) {
                return new int[]{j, i};
            }
            indexOf.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /** Group by a canonical key (sorted letters). LC 49. */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);                        // CHANGE: how to build the key
            groups.computeIfAbsent(new String(key), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    /** Only start counting at sequence starts (x-1 absent). LC 128. O(n). */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int length = 1;
                while (set.contains(x + length)) {
                    length++;
                }
                best = Math.max(best, length);
            }
        }
        return best;
    }
}
