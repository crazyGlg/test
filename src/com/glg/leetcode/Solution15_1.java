package com.glg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 三数之和
 * nums[i] + nums[j] + nums[k] = 0
 * */
public class Solution15_1 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        // 枚举a
        for (int i = 0; i < len; i++) {
            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int k = len - 1;
            int target = -nums[i];
            for (int j = i + 1; j < len; j++) {
                // 需要和上一次枚举的数不相同
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (j < k && nums[j] + nums[k] > target) {
                    --k;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
