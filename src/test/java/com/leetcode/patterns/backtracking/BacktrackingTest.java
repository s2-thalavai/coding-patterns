package com.leetcode.patterns.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("23. Backtracking")
class BacktrackingTest {

    @Test
    @DisplayName("subsets: 2^n results, all unique")
    void subsets() {
        List<List<Integer>> result = Backtracking.subsets(new int[]{1, 2, 3});
        assertEquals(8, result.size());
        assertEquals(8, new HashSet<>(result).size());
        assertEquals(List.of(), result.get(0));
    }

    @Test
    @DisplayName("subsets with duplicate input")
    void subsetsWithDup() {
        assertEquals(List.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2)),
                Backtracking.subsetsWithDup(new int[]{1, 2, 2}));
    }

    @Test
    @DisplayName("permutations: n! results")
    void permute() {
        List<List<Integer>> result = Backtracking.permute(new int[]{1, 2, 3});
        assertEquals(6, result.size());
        assertEquals(6, new HashSet<>(result).size());
    }

    @Test
    @DisplayName("combination sum with reuse")
    void combinationSum() {
        assertEquals(List.of(List.of(2, 2, 3), List.of(7)),
                Backtracking.combinationSum(new int[]{2, 3, 6, 7}, 7));
        assertEquals(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)),
                Backtracking.combinationSum(new int[]{5, 3, 2}, 8));
    }

    @ParameterizedTest(name = "n={0} -> {1}")
    @CsvSource({"1, 1", "4, 2", "6, 4", "8, 92"})
    @DisplayName("N-Queens solution count")
    void nQueens(int n, int expected) {
        assertEquals(expected, Backtracking.totalNQueens(n));
    }
}
