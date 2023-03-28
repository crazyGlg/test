package com.glg.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * 有效的括号
 * */
public class Solution20_1 {


    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) return false;
        Map<Character, Character> pair = new HashMap<Character, Character>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pair.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pair.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
