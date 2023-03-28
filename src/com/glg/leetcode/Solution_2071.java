package com.glg.leetcode;

import java.util.*;

public class Solution_2071 {

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int worker : workers) {
            workerMap.put(worker, workerMap.getOrDefault(worker, 0) + 1);
        }
        int ans = 0;
        int l = 0, r = tasks.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (helper(tasks, new TreeMap<>(workerMap), pills, strength, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }

    private boolean helper(int[] tasks, TreeMap<Integer, Integer> workerMap, int pills, int strength, int mid) {
        for (int i = mid; i >= 0; i--) {
            Map.Entry<Integer, Integer> ceilingEntry = workerMap.ceilingEntry(tasks[i]);
            if (ceilingEntry != null) {
                //不使用药丸
                if (ceilingEntry.getValue() > 1) {
                    workerMap.put(ceilingEntry.getKey(), ceilingEntry.getValue() - 1);
                } else {
                    workerMap.remove(ceilingEntry.getKey());
                }
            } else {
                //使用药丸
                if (pills == 0) {
                    return false;
                }
                pills--;
                Map.Entry<Integer, Integer> entry = workerMap.ceilingEntry(tasks[i] - strength);
                if (entry != null) {
                    if (entry.getValue() > 1) {
                        workerMap.put(entry.getKey(), entry.getValue() - 1);
                    } else {
                        workerMap.remove(entry.getKey());
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

