package com.leetcode.patterns.design;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("31a. LRU Cache")
class LRUCacheTest {

    @Test
    @DisplayName("LeetCode sample sequence")
    void sample() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);                 // evicts 2
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);                 // evicts 1
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    @DisplayName("updating a key refreshes recency without growing size")
    void update() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10);                // 1 is now most recent
        cache.put(3, 3);                 // evicts 2
        assertEquals(10, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.size());
    }

    @Test
    @DisplayName("rejects non-positive capacity")
    void invalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new LRUCache(0));
    }
}
