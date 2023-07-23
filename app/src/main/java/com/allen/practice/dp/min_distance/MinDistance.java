package com.allen.practice.dp.min_distance;

/**
 * 动态规划练习题05：编辑距离
 *
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
     *
     * 1. rorse  h -> r
     *    rose   delete -> r
     *    ros    delete -> e
     *    3
     *
     * 2. rhorse   add -> r
     *    rororse  add -> o
     *    rosrorse add -> s
     *    ...  delete -> r,o,r,s,e
     *    8
     *
     * 3. orse  delete -> h
     *    rorse add -> r
     *    rose  delete -> r
     *    ros   delete -> e
     *    4
     *
     * 假设这个问题可以通过动态规划处理
     * 状态：增、删、改（这三个动作）错误
     * dp函数： String dp(int action)
     *
     */
    public int minDistance(String word1,String word2){

        return 0;
    }

}
