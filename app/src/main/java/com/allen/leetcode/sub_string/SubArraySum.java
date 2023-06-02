package com.allen.leetcode.sub_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和：前缀和是一种常用的数组技巧，可用于快速计算数组中某一段区间的和。
 * <p>
 * 前缀和数组是指对原始数组进行预处理，计算出从数组起始位置到每个位置的元素之和，然后将这些和存储在一个新的数组中。
 * 假设原始数组为nums，前缀和数组为prefixSum，则prefixSum[i]表示原始数组nums中前i个元素的和。
 * <p>
 * public int[] calculatePrefixSum(int[] nums) {
 * int n = nums.length;
 * int[] prefixSum = new int[n];
 * prefixSum[0] = nums[0];
 * <p>
 * for (int i = 1; i < n; i++) {
 * prefixSum[i] = prefixSum[i-1] + nums[i];
 * }
 * <p>
 * return prefixSum;
 * }
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * prefixSum - k = x
 * <p>
 * prefixSum - x = k
 *
 * @Author Allen
 * @Date 05-31-2023 周三 11:40
 */
public class SubArraySum {

    public static int subArraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }


}
