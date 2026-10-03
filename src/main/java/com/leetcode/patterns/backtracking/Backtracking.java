package com.leetcode.patterns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pattern 23: Backtracking.
 *
 * <pre>
 * if (goal reached) { save COPY of path; return; }
 * for (each option) { if (invalid) continue/break; choose; recurse; un-choose; }
 * </pre>
 */
public final class Backtracking {

    private Backtracking() {
    }

    /** Every node is an answer; start index prevents reordered duplicates. LC 78. */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subsets(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsets(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /** Sort + skip equal values at the same tree level. LC 90. */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(sorted, 0, new ArrayList<>(), result);
        return result;
    }

    private static void subsetsWithDup(int[] nums, int start, List<Integer> path,
                                       List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDup(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    /** Order matters: loop from 0, track used[]. LC 46. */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private static void permute(int[] nums, boolean[] used, List<Integer> path,
                                List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permute(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    /** Reuse allowed (recurse with i) + prune on sorted input. LC 39. */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] sorted = candidates.clone();
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(sorted, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum(int[] c, int start, int remaining, List<Integer> path,
                                       List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < c.length; i++) {
            if (c[i] > remaining) {
                break;                               // prune
            }
            path.add(c[i]);
            combinationSum(c, i, remaining - c[i], path, result);
            path.remove(path.size() - 1);
        }
    }

    /** Constraint puzzle: columns and both diagonals as sets. LC 51 (returns count, LC 52). */
    public static int totalNQueens(int n) {
        return placeQueens(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }

    private static int placeQueens(int row, int n, boolean[] cols, boolean[] diag, boolean[] anti) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int c = 0; c < n; c++) {
            int d = row - c + n;
            int a = row + c;
            if (cols[c] || diag[d] || anti[a]) {
                continue;
            }
            cols[c] = diag[d] = anti[a] = true;
            count += placeQueens(row + 1, n, cols, diag, anti);
            cols[c] = diag[d] = anti[a] = false;
        }
        return count;
    }
}
