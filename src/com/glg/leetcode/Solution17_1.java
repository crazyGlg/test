package com.glg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 0017 电话组合
 * 回溯算法 todo 弄懂？
 */
public class Solution17_1 {

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
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        backTrack(result, digits, 0, "");
        return result;
    }

    public static void backTrack(List<String> result, String digits, int index, String com) {
        if (index == digits.length()) {
            result.add(com);
            return;
        }
        List<String> coms = phone.get(digits.charAt(index));
        for (int i = 0; i < coms.size(); i++) {
            backTrack(result, digits, index + 1, com + coms.get(i));
        }
    }
}
