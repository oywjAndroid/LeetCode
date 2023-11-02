package com.allen.example.dp;

/**
 * 动态规划001 --- 斐波那契数
 * (Tips:该例子用于理解动态规划的推导过程非常简单明了)
 * 1、动态规划是对暴力递归解法的优化策略，处理这类最值问题，尝试从暴力递归解法入手；
 * 2、递归的核心思想，相同的处理策略，不同的数据规模，尝试找出子问题，并写出其处理策略，最终按照数据规模执行递归；
 * 3、递归处理策略的实现考虑问题中涉及的状态、选择、base case出发；
 * 4、递归策略完成后进行重叠子问题的优化，采用备忘录优化穷举过程，避免重复计算；
 * 5、最终优化成自底向上的迭代法完成动态规划的优化。
 *
 * @Author Allen
 * @Date 11-01-2023 周三 11:19
 */
public class Example001 {

    /**
     * fib_1:暴力递归策略
     */
    public int fib_1(int n) {
        // 非法数校验
        if (n < 0) {
            return -1;
        }

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // 递归策略:(n-1)与(n-2)的斐波那契数之和
        // 数据规模:n-1、n-2
        return fib_1(n - 1) + fib_1(n - 2);
    }


    private int[] memo;

    /**
     * fib_2: 使用备忘录优化子问题
     */
    public int fib_2(int n) {
        // 非法数校验
        if (n < 0) {
            return -1;
        }

        // 备忘录优化
        if (memo == null) {
            memo = new int[n + 1];
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        // base case
        if (n == 0 || n == 1) {
            memo[n] = 1;
            return memo[n];
        }

        // 递归策略:n=(n-1)与(n-2)对应的斐波那契数之和
        // Tips:写递归策略时应该只关注递归树的当前层
        memo[n] = fib_2(n - 1) + fib_2(n - 2);

        return memo[n];
    }

    /**
     * fib_3:使用动态规划实现
     */
    public int fib_3(int n) {
        if (n < 0) {
            return -1;
        }

        int[] dp = new int[n + 1];
        // base case
        dp[0] = dp[1] = 1;

        // 状态转移方程
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
