package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
