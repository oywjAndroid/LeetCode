package com.allen.practice.dp;

import com.allen.leetcode.dp.LongestPalindrome;

import org.junit.Test;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/09/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class LeetCodeDpQuestionUnitTest {

    @Test
    public void runLongestPalindrome() {
        String inputStr = "babad";
        String str = new LongestPalindrome().longestPalindrome(inputStr);
        System.out.println("str=" + str);
    }

}
