package com.allen.practice.dp.max_longest_comm_subseq;

/**
 * 动态规划练习题04：最长公共子序列
 * <p>
 * 输入：str1 = "abcde" ，str2 = "aceb"，算法应该输出3，
 * 因为 str1 和 str2 的最长公共子序列是"ace"，它的长度是3。
 *
 * 什么是公共子序列？
 * 在str1、str2中都存在的字符。
 *
 * str1 = "abcde" ，str2 = "aceb"
 * -----------------
 *    ‘’ a b c d e
 * ‘’ 0  0 0 0 0 0
 * a  0  1 1 1 1 1
 * c  0  1 1 2 2 2
 * e  0  1 1 2 2 3
 * b  0  1 2 2 2 3
 *
 *
 *
 * str1 = "babcde" ，str2 = "ace"
 * -----------------
 *    ‘’ b a b c d e  i
 * ‘’ 0  0 0 0 0 0 0
 * a  0  0 1 1 1 1 1
 * c  0  0 1 1 2 2 2
 * e  0  0 1 1 2 2 3
 *
 * j
 *
 * a c e
 *
 * 1、dp数组的定义：dp[i][j] = str1[0...i] 和 str2[0...j] 中最大公共子序列长度
 *
 * 2、状态转移方程：dp[i][j] = max(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) : max(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1;
 *
 * 3、base case
 *  dp[0][0] 按照上面的状态转移方程，将会出现越界问题，通过增加一行一列的空字符，来解决这个问题，空字符和其他字符组成的子序列长度都是0
 */
public class MaxLongestCommSubsequence {

    public int longestCommSubsequence(String str1, String str2) {
        if (str1 == null || str2 == null){
            return 0;
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int col = charArr1.length + 1;
        int row = charArr2.length + 1;

        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //dp[i-1]

                //dp[i][j] =
            }
        }

        return 0;
    }

}
