package com.glg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 电话组合
 * 穷举法
 */
public class Solution17_2 {

    private static Map<Character, List<String>> phone = new HashMap<>();

    static {
        phone.put('2', List.of("a", "b", "c"));
        phone.put('5', List.of("j", "k", "l"));
        phone.put('4', List.of("g", "h", "i"));
        phone.put('6', List.of("m", "n", "o"));
        phone.put('7', List.of("p", "q", "r", "s"));
        phone.put('3', List.of("d", "e", "f"));
        phone.put('8', List.of("t", "u", "v"));
        phone.put('9', List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        List<String> result = List.of("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            if (phone.containsKey(digits.charAt(i))) {
                List<String> str = phone.get(digits.charAt(i));
                for (String s : result) {
                    for (String s1 : str) {
                        temp.add(s + s1);
                    }

                }
                result = temp;
            }
        }
        return result;
    }
}
