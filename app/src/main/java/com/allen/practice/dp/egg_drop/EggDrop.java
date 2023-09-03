package com.allen.practice.dp.egg_drop;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划练习题09：高楼扔鸡蛋
 * 假设有从1～N工N层的楼，然后给你K个鸡蛋（K至少为1），现在确定这栋楼存在楼层F（0<=F<=N）
 * 在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于F的楼层都会碎，低于F的楼层都不会碎），
 * 最坏的情况下，至少要扔几次鸡蛋，才能确定这个楼层F呢？
 * <p>
 * 动态规划三要素：最优子结构、状态转移方程、重叠子问题
 * 动态规划解题思想：利用状态转移方程计算子问题的结果并最终推导出原问题的结果
 * <p>
 * 解题思路：
 * 1、该问题是否具有最优子结构？在 i 层扔鸡蛋的结果与在 i-1 层 i+1层扔鸡蛋的结果互不影响，则认为存在最优子结构
 * 2、状态转移方程：
 * 2.1 状态：在子问题和原问题都存在的变量，
 * 原问题：K个鸡蛋，N层楼，最坏情况下至少尝试次数？
 * 假设原问题中恰好摔不碎的楼层为i，其尝试次数会分为两种情况计算出来，摔碎尝试次数，摔不碎尝试次数。
 * 碎，子问题：k-i个鸡蛋，k-i层下的尝试次数？
 * 没碎，子问题：k个鸡蛋，i-1层下的尝试次数？
 * max(碎,没碎)+1 -> 就是i层最坏情况下的尝试次数。
 * 2.2 选择：会影响状态的改变
 * 选择不同楼层 1<=i<=N, min(max(碎,没碎)+1) -> 就是最坏情况下至少尝试次数。
 * 2.3 base case,最简单的情况, k=1,return N & k=0,return 0
 * 2.4 定义dp数组/dp函数来表现状态和选择
 */
public class EggDrop {
    private final Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        // base case
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }

        String s = k + ":" + n;
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 假设i层为恰好摔不碎的楼层时，最坏情况下至少尝试次数
            int maxCount = Math.max(
                    // 碎，最坏情况下至少尝试次数
                    dp(k - 1, i - 1),
                    // 没碎，最坏情况下至少尝试次数
                    dp(k, n - i)
            ) + 1;// 在i层扔了一次
            res = Math.min(res, maxCount);
            System.out.println("k=" + k + ",n=" + n + ",maxCount=" + maxCount+",res="+res);
            memo.put(s, res);
        }

        return res;
    }
}
