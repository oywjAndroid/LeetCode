package com.allen.practice.dp.longest_comm_subseq;

import java.util.Arrays;

/**
 * 动态规划练习题04：最长公共子序列
 * <p>
 * 输入：str1 = "abcde" ，str2 = "aceb"，算法应该输出3，
 * 因为 str1 和 str2 的最长公共子序列是"ace"，它的长度是3。
 * <p>
 * 什么是公共子序列？
 * 在str1、str2中都存在的子序列。
 * <p>
 * str1 = "abcde" ，str2 = "aceb"
 * -----------------
 * --a b c d e
 * a 1 0 0 0 0
 * c 1 1 2 2 2
 * e 1 1 2 2 3
 * b 1 2 2 2 3
 * str1 = "babcde" ，str2 = "ace"
 * -----------------
 * -- '' b a b c d e
 * '' 0  0 0 0 0 0 0
 * a  0  0 1 1 1 1 1
 * c  0  0 1 1 2 2 2
 * e  0  0 1 1 2 2 3
 * <p>
 * a c e
 * -----------------
 * <p>
 * -- d  b  d  k  s  d  k  f  n  a  l  k  d  f  a
 * s [0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
 * d [1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4]
 * k [1, 1, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5]
 * l [1, 1, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
 * s [1, 1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5]
 * <p>
 * <p>
 * -- d b d s s d
 * s  0 0 0 1 1 1
 * d  1 1 1 1 1 2
 * k  1 1 1 2 1 2
 * <p>
 * 按照longestCommSubsequence_error的状态转移方程，str1="dbdssd"，str2="sdk"，计算的dp[i][j]就是错误的
 * 比如：dp[0][4]就会=2，base case 如果是
 * <p>
 * -- '' d b d s s d
 * '' 0  0 0 0 0 0 0
 * s  0  0 0 0 1 1 1
 * d  0  1 1 1 1 1 2
 * k  0  1 1 1 2 1 2
 *
 * <p>
 * 1、dp数组的定义：dp[i][j] = str1[0...i] 和 str2[0...j] 中最大公共子序列长度
 * <p>
 * 2、状态转移方程：
 * ERROR --> dp[i][j] = max(dp[i-1][j],dp[i][j-1]) : max(dp[i-1][j],dp[i][j-1]) + 1;
 * --
 * CORRECT --> dp[i][j] = str1[i] == str2[j] ? dp[i-1][j-1] + 1 : max(dp[i-1][j],dp[i][j-1])
 *
 * <p>
 * 3、base case
 * ERROR --> dp[0][0] 按照上面的状态转移方程，将会出现越界问题，通过增加一行一列的空字符，来解决这个问题，空字符和其他字符组成的子序列长度都是0
 * --
 * CORRECT --> dp[0][...]、dp[...][0]
 */
public class LongestCommSubsequence {

    public int longestCommSubsequence_error(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        // dp数组
        int[][] dp = new int[chars1.length][chars2.length];

        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (i == 0 && j == 0) {
                    // base case
                    dp[i][j] = chars1[i] == chars2[j] ? 1 : 0;
                } else if (i == 0 || j == 0) {
                    if (i == 0) {
                        int max = Math.max(dp[0][j - 1], dp[0][j]);
                        // 直接这样计算
                        dp[i][j] = chars1[i] == chars2[j] ? max + 1 : max;
                    }
                    if (j == 0) {
                        int max = Math.max(dp[i - 1][0], dp[i][0]);
                        dp[i][j] = chars1[i] == chars2[j] ? max + 1 : max;
                    }
                } else {
                    // 状态转移方程
                    int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = chars1[i] == chars2[j] ? max + 1 : max;
                }
                //System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[chars1.length - 1][chars2.length - 1];
    }


    public int longestCommSubsequence(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int row = chars1.length + 1;
        int col = chars2.length + 1;
        // base case 为dp[0][...]和dp[...][0]且值都为0
        int[][] dp = new int[row][col];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 状态转移方程
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

}
