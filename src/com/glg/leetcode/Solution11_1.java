package com.glg.leetcode;

/*
 * 成最多水的容器
 * 双指针
 *
 * */
public class Solution11_1 {

    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1;
        int max = 0;
        while (head < tail) {
            max = Math.max(max, Math.min(height[head], height[tail]) * (tail - head));
            if (height[head] <= height[tail]) {
                head++;
            }else {
                tail--;
            }
        }
        return max;
    }
}
