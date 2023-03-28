package com.glg.leetcode;

/*
 * 字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）
 * 数学计算
 *
 * */
public class Solution8_1 {
    public int myAtoi(String s) {
        boolean begin = false, isMinus = false;
        int res = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (!begin) {
                if (s.charAt(i) == ' ') continue;
                else if (s.charAt(i) == '-') {
                    isMinus = true;
                    begin = true;
                    continue;
                }else if (s.charAt(i) == '+') {
                    begin = true;
                    continue;
                }
                else if (Character.isDigit(s.charAt(i))) {
                    begin = true;
                }else break;
            }
            if (Character.isDigit(s.charAt(i))) {
                long boundary = isMinus ?  -(long)Integer.MIN_VALUE : (long)Integer.MAX_VALUE;
                if (res > boundary / 10) {
                    return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }else if (res == boundary / 10) {
                    if ((long) res * 10 + s.charAt(i) - '0' >= boundary) {
                        return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                }
                res = res * 10 + s.charAt(i) - '0';

            }else break;
        }

        return isMinus ? -res : res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution8_1().myAtoi(" -42"));
    }
}
