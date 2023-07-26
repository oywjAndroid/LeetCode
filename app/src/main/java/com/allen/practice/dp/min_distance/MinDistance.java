package com.allen.practice.dp.min_distance;

/**
 * 动态规划练习题05：编辑距离
 * <p>
 * 给你两个单词 word1 和 word2 ,请返回将 word1 转换成 word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例1
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例2
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class MinDistance {


    /**
     * horse -> ros
     * <p>
     * 1. rorse  h -> r
     * rose   delete -> r
     * ros    delete -> e
     * 3
     * <p>
     * 2. rhorse   add -> r
     * rororse  add -> o
     * rosrorse add -> s
     * ...  delete -> r,o,r,s,e
     * 8
     * <p>
     * 3. orse  delete -> h
     * rorse add -> r
     * rose  delete -> r
     * ros   delete -> e
     * 4
     * <p>
     * 假设这个问题可以通过动态规划处理
     * 状态：增、删、改（这三个动作）错误
     * dp函数： String dp(int action)
     * <p>
     * 1、dp函数的定义：dp[i][j] = str1[0...i] str2[0...j]的最少操作数 (假设)
     * <p>
     * h o r s e
     * r
     * o       (i-1,j-1) (i-1,j)
     * s       (i,j-1)   (i,j)
     * <p>
     * dp[i-1][j-1] = hors ->   ro 最少操作数 3
     * dp[i-1][j]   = hourse -> ro 最少操作数 5
     * dp[i][j-1]   = hors ->   ros 最少操作数 2
     * dp[i][j]   = horse ->   ros 最少操作数 3
     * <p>
     * dp[0][0] = h -> r 最少操作数
     * h o r s e
     * r 1 2 2 3
     * <p>
     * 插入:dp[i][j-1]
     * 删除:dp[i-1][j]
     * 替换:dp[i-1][j-1]
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base case
        for (int row = 1; row < dp.length; row++)
            dp[row][0] = row;
        for (int col = 1; col < dp[0].length; col++)
            dp[0][col] = col;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }

}
