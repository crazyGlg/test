package com.glg.leetcode;


/*
 * 最长回文子串
 * 动态规划
 *
 * */
public class Solution5_2 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 枚举回文子串长度
        for (int l = 2; l <= len; l++) {
            // 枚举左边界
            for (int i = 0; i < len; i++) {
                // 右边界
                int j = i + l - 1;
                if (j >= len) break;
                if (charArray[i] == charArray[j]) {
                    if (l == 2) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j -1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 >maxLen) {
                    maxLen = l;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
