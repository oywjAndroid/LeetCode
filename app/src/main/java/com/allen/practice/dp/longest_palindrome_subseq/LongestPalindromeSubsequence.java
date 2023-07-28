package com.allen.practice.dp.longest_palindrome_subseq;

import java.util.Arrays;

/**
 * 动态规划练习题06：最长回文子序列长度
 * 输入一个字符串s，请找出s中的最长回文子序列长度
 * 比如输入 s="aecda" ，算法返回3，因为最长回文子序列是"aca"
 * a、e、c、d
 * aa
 * aca
 * -> 3
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * <p>
 * 题意分析：
 * 1. 回文串从左右两端进行遍历其 s[i] == s[j] && i <= j。
 * 2. 最长回文子序列，肯定是在所有子序列中，那么如何拿到所有的子序列呢？仅仅从 i=0,j=n-1 双向遍历并不能枚举所有的子序列
 * 3. 枚举出所有的子序列后，判断该序列是否为回文串，并取出最大回文序列的长度。
 * <p>
 * 子序列+最值题必定考察动态规划技巧
 * i i+1  ...   j-1 j
 * ? b   x a b   y  ?
 * i=0 j=n-1
 *
 * <p>
 * dp数组定义：dp[i][j] = s[i] ~ s[j]的最长回文子序列长度
 * <p>
 * <p>
 * // 它俩一定在最长回文子序列中
 * if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
 * // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
 * else dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
 *
 * <p>
 * base case -> i == j  dp[i][j] = 1
 * <p>
 * i = 0 , j = n-1
 * a e c d a
 * 1       dp[0][n-1]
 * 1   dp[i+1][j-1]
 * 1
 * 1
 * 1
 * <p>
 * 0    1   2   3
 * 0 0,0 0,1 0,2 0,3
 * 1     1,1 1,2 1,3
 * 2         2,2 2,3
 * 3             3,3
 * <p>
 * for(int i = 3;i >= 0;i++){
 * for(int j = i+1;i < n;i++){
 * ...
 * }
 * }
 */
public class LongestPalindromeSubsequence {

    public int longestPalindromeSubsequence(String s) {
        if (s == null) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[0][n - 1];
    }
}
