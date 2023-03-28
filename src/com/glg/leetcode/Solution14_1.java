package com.glg.leetcode;

/*
* 最长公共前缀
*
* */
public class Solution14_1 {

    public String longestCommonPrefix(String[] strs) {
        StringBuffer prefix = new StringBuffer();
        String first = strs[0];
        out:for (int i = 0; i < first.length(); i++) {
            in:for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) break out;
                if (first.charAt(i) != strs[j].charAt(i)) {
                    break out;
                }
            }
            prefix.append(first.charAt(i));
        }

        return prefix.toString();
    }
}
