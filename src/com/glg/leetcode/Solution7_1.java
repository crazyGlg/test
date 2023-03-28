package com.glg.leetcode;

/*
 * 整数反转 32位有符号整数 假设环境不允许存储 64 位整数（有符号或无符号）
 * 超过 32 位的有符号整数的范围 [−231,  231 − 1] 返回0;
 * 注意： 反转之后的范围和负数
 *
 * */
public class Solution7_1 {

    public int reverse(int x) {
        boolean isMinus = false;
        String valueOf = String.valueOf(x);
        if (valueOf.contains("-")) {
            isMinus = true;
            valueOf = valueOf.replace("-", "");
        }
        StringBuffer buffer = new StringBuffer(valueOf);
        buffer = buffer.reverse();
        if (isMinus) buffer.insert(0, "-");
        long result = Long.parseLong(buffer.toString());
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
