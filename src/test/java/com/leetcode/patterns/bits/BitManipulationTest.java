package com.leetcode.patterns.bits;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("29. Bit Manipulation")
class BitManipulationTest {

    @Test
    @DisplayName("single number via XOR")
    void singleNumber() {
        assertEquals(4, BitManipulation.singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(-7, BitManipulation.singleNumber(new int[]{-7, 3, 3}));
    }

    @Test
    @DisplayName("counting bits")
    void countBits() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, BitManipulation.countBits(5));
    }

    @ParameterizedTest(name = "popcount({0}) = {1}")
    @CsvSource({"0, 0", "11, 3", "128, 1", "-1, 32", "-2147483648, 1"})
    @DisplayName("hamming weight, including negatives")
    void hammingWeight(int n, int expected) {
        assertEquals(expected, BitManipulation.hammingWeight(n));
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({"1, true", "16, true", "3, false", "0, false", "-16, false", "1073741824, true"})
    @DisplayName("power of two")
    void powerOfTwo(int n, boolean expected) {
        assertEquals(expected, BitManipulation.isPowerOfTwo(n));
    }

    @Test
    @DisplayName("bitmask subsets")
    void subsets() {
        assertEquals(8, BitManipulation.subsetsBitmask(new int[]{1, 2, 3}).size());
        assertEquals(java.util.List.of(1, 3), BitManipulation.subsetsBitmask(new int[]{1, 2, 3}).get(5));
    }
}
