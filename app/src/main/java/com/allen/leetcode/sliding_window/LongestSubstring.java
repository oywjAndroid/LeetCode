package com.allen.leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *
 *
 * 请注意，你的答案必须是 子串 的长度，"wke"是一个子序列，不是子串
 *
 * @Author Allen
 * @Date 05-19-2023 周五 17:46
 */
public class LongestSubstring {

    public static int lengthLongestSubstring(String s) {
        // 定义一个哈希集合，用于存储当前窗口内的字符
        Set<Character> set = new HashSet<>();

        int n = s.length(); // 字符串的长度
        int maxLen = 0; // 最长子串的长度
        int left = 0; // 滑动窗口的左边界

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            // 如果集合中已经存在当前字符，则需要移动左边界，直到集合中不再包含当前字符
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            // 将当前字符加入集合
            set.add(c);
            // 更新最长子串的长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


}
