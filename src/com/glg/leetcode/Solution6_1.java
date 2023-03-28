package com.glg.leetcode;

/*
 * N字型变换
 *
 * 用二维数组模拟Z型变换的过程
 * */
public class Solution6_1 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows < 2 || numRows > len) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int cols = (len / numRows + 1) * numRows;
        char[][] dp = new char[numRows][cols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = ' ';
            }
        }

        int row = 0, col = 0;
        int nextPoint = numRows - 1;
        boolean toDown = true;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0) {
                dp[0][0] = charArray[i];
                continue;
            }

            if (toDown) {
                dp[++row][col] = charArray[i];
            } else {
                dp[--row][++col] = charArray[i];
            }
            if (i == nextPoint) {
                toDown = !toDown;
                nextPoint = nextPoint + numRows - 1;
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] != ' ') {
                    res.append(dp[i][j]);
                }
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }

        return res.toString();
    }

    public String optimizeConvert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || numRows > len) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i) {
            mat[i] = new StringBuffer();
        }
        // t表示一个周期
        for (int i = 0, x = 0, t = numRows * 2 - 2; i < len; ++i) {
            mat[x].append(s.charAt(i));
            // 计算下次行数
            if (i % t < numRows - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6_1().convert("PAYPALISHIRING", 7));
    }
}
