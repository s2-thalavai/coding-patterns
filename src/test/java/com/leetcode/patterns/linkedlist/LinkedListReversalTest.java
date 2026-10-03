package com.leetcode.patterns.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.leetcode.patterns.model.ListNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("9. In-place Reversal")
class LinkedListReversalTest {

    @Test
    @DisplayName("reverse whole list")
    void reverse() {
        assertEquals(List.of(5, 4, 3, 2, 1),
                ListNode.toList(LinkedListReversal.reverse(ListNode.of(1, 2, 3, 4, 5))));
        assertNull(LinkedListReversal.reverse(null));
    }

    @Test
    @DisplayName("reverse a sublist, including from the head")
    void reverseBetween() {
        assertEquals(List.of(1, 4, 3, 2, 5),
                ListNode.toList(LinkedListReversal.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 2, 4)));
        assertEquals(List.of(3, 2, 1, 4),
                ListNode.toList(LinkedListReversal.reverseBetween(ListNode.of(1, 2, 3, 4), 1, 3)));
    }

    @Test
    @DisplayName("reverse in groups of k")
    void reverseKGroup() {
        assertEquals(List.of(2, 1, 4, 3, 5),
                ListNode.toList(LinkedListReversal.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2)));
        assertEquals(List.of(3, 2, 1, 4, 5),
                ListNode.toList(LinkedListReversal.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3)));
    }
}
