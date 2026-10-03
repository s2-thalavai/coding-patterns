package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("4. Hashing")
class HashingTest {

    @Test
    @DisplayName("twoSum with complement lookup")
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, Hashing.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, Hashing.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, Hashing.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    @DisplayName("groupAnagrams groups by sorted key (order independent)")
    void groupAnagrams() {
        List<List<String>> groups = Hashing.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assertEquals(
                List.of(List.of("ate", "eat", "tea"), List.of("bat"), List.of("nat", "tan")),
                normalise(groups));
    }

    @Test
    @DisplayName("longestConsecutive")
    void longestConsecutive() {
        assertEquals(4, Hashing.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        assertEquals(9, Hashing.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        assertEquals(0, Hashing.longestConsecutive(new int[0]));
    }

    private static List<List<String>> normalise(List<List<String>> groups) {
        List<List<String>> out = new ArrayList<>();
        for (List<String> g : groups) {
            List<String> copy = new ArrayList<>(g);
            Collections.sort(copy);
            out.add(copy);
        }
        out.sort(Comparator.comparing(g -> g.get(0)));
        return out;
    }
}
