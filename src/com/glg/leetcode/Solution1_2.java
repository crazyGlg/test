package com.glg.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* 利用map保存前面遍历过的值与其下标
*  O(n)
* */
public class Solution1_2 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }
            map.put(diff, i);
        }
        return result;
    }
}

