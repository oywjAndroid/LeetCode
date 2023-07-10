package com.allen.knowledge.tree.dp;

import java.util.Arrays;

/**
 * 经典动态规划案例：凑零钱问题
 * 示例1: coins = [1,2,5] amount = 11
 * CoinChangeTopDown演示自底向上，通过dp数组的迭代解法消除子问题，最终推算出原问题答案。
 */
public class CoinChangeBottomUp {

    private int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


}
