package com.leetcode.patterns.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.leetcode.patterns.model.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("8. Fast & Slow Pointers")
class FastSlowPointersTest {

    @Test
    @DisplayName("middle of odd and even lists")
    void middle() {
        assertEquals(3, FastSlowPointers.middle(ListNode.of(1, 2, 3, 4, 5)).val);
        assertEquals(4, FastSlowPointers.middle(ListNode.of(1, 2, 3, 4, 5, 6)).val);
    }

    @Test
    @DisplayName("cycle detection and entry point")
    void cycle() {
        ListNode head = ListNode.of(3, 2, 0, -4);
        ListNode entry = head.next;
        head.next.next.next.next = entry;          // -4 -> 2
        assertTrue(FastSlowPointers.hasCycle(head));
        assertSame(entry, FastSlowPointers.detectCycleStart(head));

        ListNode noCycle = ListNode.of(1, 2, 3);
        assertFalse(FastSlowPointers.hasCycle(noCycle));
        assertNull(FastSlowPointers.detectCycleStart(noCycle));
        assertNull(FastSlowPointers.detectCycleStart(null));
    }

    @Test
    @DisplayName("happy number on an implicit sequence")
    void happy() {
        assertTrue(FastSlowPointers.isHappy(19));
        assertFalse(FastSlowPointers.isHappy(2));
    }
}
