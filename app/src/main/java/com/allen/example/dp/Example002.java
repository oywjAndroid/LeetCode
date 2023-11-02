package com.allen.example.dp;

/**
 * 动态规划002 --- 凑零钱问题
 * <p>
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1。
 *
 * @Author Allen
 * @Date 11-02-2023 周四 13:57
 */
public class Example002 {

    public int coinChange_1(int[] coins, int amount) {
        // coins: 1, 2, 3   amount 8
        // 3,3,2  -> 3
        // 3,3,1,1
        // 3,2,2,1
        // 3,2,1,1,1
        // 3,1,1,1,1,1
        // 2,3,3
        // 2,3,2,1
        // 2,3,1,1,1
        // 2,2,3,1
        // 2,2,2,2
        // 2,2,2,1,1
        // 2,2,1,1,1,1
        // 2,1,1,1,1,1,1
        // 1,3,3,1
        // 1,3,2,2
        // 1,3,2,1,1
        // 1,2,3,2
        // 1,2,3,1,1
        // 1,2,2,3
        // 1,2,2,2,1
        // 1,2,2,1,1,1
        // ...
        // 1,1,1,1,1,1,1,1

        if (amount <= 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount == coin) {
                return 1;
            }
            minCount = Math.min(coinChange_1(coins, amount - coin) + 1, minCount);
            System.out.println("amount=" + amount + ",minCount=" + minCount);
        }

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

}
