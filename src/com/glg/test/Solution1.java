package com.glg.test;

import java.util.Arrays;

/*
* 最后的幸存者

有N支军队，每一回合，从中选出两支人数最多的军队决战。假设这两支军队的人数分别为 x 和 y，且 x <= y。那么决战的可能结果如下：

如果 x == y，那么两支军队都会同归于尽；
如果 x != y，那么人数为 x 的军队将会全军覆没，而人数为 y 的军队新人数为 y-x。
最后，最多只会剩下一支军队。返回此军队的人数。如果没有军队剩下，就返回 0。
*
*
* 示例：

输入：[2,7,4,1,8,1]
输出：1
解释：
先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那支军队的人数。

提示：

1 <= teams.length <= 30
1 <= teams[i] <= 1000
*
*
* */
public class Solution1 {

    public int rest(int[] nums) {
        int[] rest = play(nums);
        if (rest.length == 0) return 0;
        else return rest[0];
    }

    public int[] play(int[] nums) {
        if (nums.length < 1) {
            return nums;
        }
        Arrays.sort(nums);
        int x = nums[nums.length - 1];
        int y = nums[nums.length - 2];
        if (x == y) return play(Arrays.copyOfRange(nums, 0, nums.length - 3));
        else {
            int[] array = Arrays.copyOfRange(nums, 0, nums.length - 2);
            array[array.length - 1] = y - x;
            return play(array);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,7,4,1,8,1};

    }
}
