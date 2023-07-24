package com.allen.practice.dp.max_sub_array;

import java.util.Arrays;

/**
 * 动态规划练习题03：最大子数组问题
 * 子数组：连续数组的一个切片(即占据连续位置)，并且固有地保持元素的顺序。
 * <p>
 * 输入一个整数数组 nums，请你在其中找一个和最大的子数组，返回这个子数组的和。
 * <p>
 * 示例：输入 nums = [-3,1,3,-1,2,-4,2]，算法返回5，因为最大子数组 [1,3,-1,2]的和为5。
 * <p>
 * <p>
 * 状态转移方程：dp[i] = dp[i-1] + numbs[i] 不对，这个方程计算的是[0...i]的和。
 */
public class MaxSubArray {

// 计算的结果不符合题意，计算的[0...i]的和，实际上最大子数组不一定是从i=0开始
// dp数组定义的是 dp[i]等于 numbs[0...i] 的最大子数组的和，实际计算过程中发现最大子数组和并不一定是在[0...i]区间产生
// 对于dp[i] 无法通过dp[i-1]进行推算
//    public int maxSubArray(int[] numbs) {
//        int[] dp = new int[numbs.length];
//        // base case
//        dp[0] = numbs[0];
//        for (int i = 1; i < dp.length; i++) {
//            // state change equation
//            dp[i] = dp[i - 1] + numbs[i];
//        }
//        int maxSum = 0;
//        for (int sum : dp) {
//            maxSum = Math.max(sum, maxSum);
//        }
//        return maxSum;
//    }

    /**
     * 修改 dp数组的定义，dp[i] = 以 numbs[i] 结尾的子数组的最大子数组的和
     * <p>
     * dp[i] = numbs[i] : dp[i-1]+numbs[i]
     * 要么dp[i] = numbs[i] ,要么就是 dp[i-1] + numbs[i]
     */
    public int maxSubArray(int[] numbs) {
        int[] dp = new int[numbs.length];
        // base case
        dp[0] = numbs[0];
        for (int i = 1; i < numbs.length; i++) {
            dp[i] = Math.max(numbs[i], dp[i - 1] + numbs[i]);
        }
        System.out.println(Arrays.toString(dp));

        int maxSum = Integer.MIN_VALUE;
        for (int j : dp) {
            maxSum = Math.max(j, maxSum);
        }
        return maxSum;
    }

}
