package com.glg.leetcode;

public class Solution2_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int carry = 0;
        int sum = l1.val + l2.val;
        if (sum >= 10) {
            result.val = sum - 10;
            carry = 1;
        } else {
            result.val = sum;
        }
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        ListNode current = result;
        while (l1Next.next != null || l2Next.next != null) {
            int l1NextVal, l2NextVal;
            if (l1Next.next != null) {
                l2Next = l2Next.next;
                l1NextVal = l1Next.val;
            } else {
                l1NextVal = 0;
            }
            if (l2Next.next != null) {
                l1Next = l1Next.next;
                l2NextVal = l2Next.val;
            } else {
                l2NextVal = 0;
            }
            sum = l1NextVal + l2NextVal + carry;
            ListNode next = new ListNode();
            if (sum >= 10) {
                next.val = sum - 10;
                carry = 1;
            } else {
                next.val = sum;
                carry = 0;
            }
            current.next = next;
            current = next;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return result;
    }
}

