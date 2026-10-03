package com.leetcode.patterns.model;

import java.util.ArrayList;
import java.util.List;

/** Singly linked list node (LeetCode style) with helpers for building and printing lists. */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /** Builds a list from values, e.g. {@code ListNode.of(1, 2, 3)}. Returns null for no values. */
    public static ListNode of(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int v : values) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    /** Converts a list to java.util.List. Do not call on a cyclic list. */
    public static List<Integer> toList(ListNode head) {
        List<Integer> out = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            out.add(n.val);
        }
        return out;
    }

    @Override
    public String toString() {
        return toList(this).toString();
    }
}
