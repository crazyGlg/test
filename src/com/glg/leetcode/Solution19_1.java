package com.glg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution19_1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> indexMap = new HashMap<>();
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            indexMap.put(index++, curr);
            curr = curr.next;
        }
        ListNode lastNode = indexMap.get(index - n - 1);
        ListNode target = indexMap.get(index - n);
        target.next = null;
        ListNode next = null;
        if (index - n + 1 < index) {
            next = indexMap.get(index - n + 1);
        }
        if (lastNode == null) {
            head = next;
        }else {
            lastNode.next = next;
        }

        return head;
    }


}
