package com.leetcode.patterns.linkedlist;

import com.leetcode.patterns.model.ListNode;

/**
 * Pattern 8: Fast &amp; Slow Pointers (Floyd's tortoise and hare).
 *
 * <p>Slow moves 1 step, fast moves 2. Finds the middle, detects cycles, finds cycle entry.
 * O(n) time, O(1) space.
 */
public final class FastSlowPointers {

    private FastSlowPointers() {
    }

    /** Middle node; second middle for even length. LC 876. */
    public static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /** LC 141. */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cycle entry. LC 142. After meeting, distance(head, entry) == distance(meet, entry)
     * modulo cycle length, so walk one pointer from head and one from the meeting point.
     */
    public static ListNode detectCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    /** Fast/slow on an implicit sequence n -> sumOfSquares(n). LC 202. */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
