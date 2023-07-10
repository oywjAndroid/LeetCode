package com.allen.knowledge.tree.dp;

import java.util.Arrays;

/**
 * 经典动态规划案例：凑零钱问题
 * 示例1: coins = [1,2,5] amount = 11
 * CoinChangeTopDown演示自顶向下，通过暴力递归一步步优化得到的类似dp的解法。
 * <p>
 * 选择1：1+1+1+1+1+1+1+1+1+1+1 = 11，15次
 * <p>
 * 选择2：2+2+2+2+2+1 = 11，6次
 * <p>
 * 选择3：5+5+1 = 11，3次
 * <p>
 * 最优子结构：
 * 11 = 10 + 1;
 * 11 = 9 + 2;
 * 11 = 6 + 5;
 * amount = amount - coin + coin，
 * 由此可知：dp(amount) = dp(amount-count) + 1, dp(amount)表示凑出 amount 金额最少需要凑多少次，count表示面额
 * <p>
 * 暴力递归思路：
 * 1、确定状态，也就是原问题、子问题中变化的变量。
 * 2、确定dp函数的定义
 * 3、确定选择，并求出最优解，对于每个状态，可以做出什么选择改变当前状态。
 * 4、确定base case
 * <p>
 * 重叠子问题处理方案：
 * 1、通过dp table把已经计算过的数据缓存起来，后面再使用到该数直接取缓存，则可以消除重叠子问题。
 * 2、通过dp数组迭代求解，有最小子问题推算出原问题，并使用dp数组缓存已计算的数据，同样也达到消除重叠子问题。
 */
public class CoinChangeTopDown {
    private static final int DPS_DEF_VAL = -888;
    private int[] dps;

    public int coinChange(int[] coins, int amount) {
        // 1.确定状态，状态是子问题和原问题中都会变化的变量
        // 2.确定dp函数
        // 3.确定选择
        // 4.确定base case
        // 5.使用dp table优化重叠子问题
        dps = new int[amount + 1];
        Arrays.fill(dps, DPS_DEF_VAL);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }

        if (dps[amount] != DPS_DEF_VAL) {
            return dps[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subAmount = dp(coins, amount - coin);
            if (subAmount == -1) {
                continue;
            }
            dps[amount] = Math.min(res, subAmount + 1);
        }
        return dps[amount];
    }


}
