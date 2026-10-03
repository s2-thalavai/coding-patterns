package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("5. Cyclic Sort")
class CyclicSortTest {

    @Test
    @DisplayName("firstMissingPositive")
    void firstMissingPositive() {
        assertEquals(3, CyclicSort.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(2, CyclicSort.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(1, CyclicSort.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        assertEquals(2, CyclicSort.firstMissingPositive(new int[]{1, 1}));
    }

    @Test
    @DisplayName("findDuplicates")
    void findDuplicates() {
        List<Integer> dups = new ArrayList<>(CyclicSort.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        Collections.sort(dups);
        assertEquals(List.of(2, 3), dups);
        assertEquals(List.of(), CyclicSort.findDuplicates(new int[]{1}));
    }
}
