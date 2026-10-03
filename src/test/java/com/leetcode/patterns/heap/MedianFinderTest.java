package com.leetcode.patterns.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("14. Two Heaps")
class MedianFinderTest {

    private MedianFinder finder;

    @BeforeEach
    void setUp() {
        finder = new MedianFinder();
    }

    @Test
    @DisplayName("median updates as numbers stream in")
    void streamingMedian() {
        finder.addNum(1);
        assertEquals(1.0, finder.findMedian());
        finder.addNum(2);
        assertEquals(1.5, finder.findMedian());
        finder.addNum(3);
        assertEquals(2.0, finder.findMedian());
        finder.addNum(-10);
        assertEquals(1.5, finder.findMedian());
    }

    @Test
    @DisplayName("no overflow when averaging large values")
    void largeValues() {
        finder.addNum(Integer.MAX_VALUE);
        finder.addNum(Integer.MAX_VALUE);
        assertEquals((double) Integer.MAX_VALUE, finder.findMedian());
    }

    @Test
    @DisplayName("empty finder throws")
    void empty() {
        assertThrows(IllegalStateException.class, () -> finder.findMedian());
    }
}
