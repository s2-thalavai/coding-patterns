package com.leetcode.patterns.linkedlist;

import com.leetcode.patterns.model.ListNode;

/**
 * Pattern 9: In-place Linked List Reversal.
 *
 * <p>prev / cur / next, four lines per node. Use a dummy head when the head may change.
 */
public final class LinkedListReversal {

    private LinkedListReversal() {
    }

    /** LC 206. O(n), O(1). */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;   // save before overwriting
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /** Reverse positions left..right (1-indexed) by head insertion. LC 92. */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;
        for (int i = 1; i < left; i++) {
            before = before.next;
        }
        ListNode cur = before.next;
        for (int i = 0; i < right - left; i++) {
            ListNode move = cur.next;   // move cur.next to the front of the segment
            cur.next = move.next;
            move.next = before.next;
            before.next = move;
        }
        return dummy.next;
    }

    /** Reverse every group of k; leftover tail stays as-is. LC 25. */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode cur = groupPrev.next;
            while (cur != groupNext) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ListNode oldFirst = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldFirst;
        }
        return dummy.next;
    }
}
