package com.glg.leetcode;

/*
* 回文数
* 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
*   例如，121 是回文，而 123 不是
* */
public class Solution9_1 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int head = 0,  tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head) == s.charAt(tail)) {
                head++;
                tail--;
            }else return false;
        }
        return true;
    }
}
