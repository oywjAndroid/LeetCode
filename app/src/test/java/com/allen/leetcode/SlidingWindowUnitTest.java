package com.allen.leetcode;

import com.allen.leetcode.sliding_window.LongestSubstring;

import org.junit.Test;

/**
 * @Description TODO
 * @Author Allen
 * @Date 05-23-2023 周二 14:07
 */
public class SlidingWindowUnitTest {

    @Test
    public void longestSubstring() {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        //String s = "pwwkew";
        String s = "acehknqsz";
        System.out.println("s = " + s);
        int substringLength = LongestSubstring.lengthLongestSubstring(s);
        System.out.println("substringLength = " + substringLength);
    }
}
