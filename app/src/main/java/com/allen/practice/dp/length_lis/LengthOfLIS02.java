package com.allen.practice.dp.length_lis;

/**
 * 自顶向下递归解法改成自底向上的动态规划解法思路
 * 1. 使用dp数组代替dp函数
 * 2. 确定base case
 * 3. 改变计算方向，自底向上推导原问题答案
 */
public class LengthOfLIS02 {

    public int lengthOfLIS(int[] numbs) {
        int[] dp = new int[numbs.length];
        dp[0] = 1;
        for (int i = 1; i < numbs.length; i++) {
            dp[i] = dp[i - 1] + (numbs[i] > numbs[i - 1] ? 1 : 0);
            System.out.println("dp[" + i + "]=" + dp[i]);
        }

        int maxLen = 0;
        for (int subDp : dp) {
            maxLen = Math.max(maxLen, subDp);
        }
        return maxLen;
    }

}
