package com.allen.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @Author Allen
 * @Date 05-24-2023 周三 10:51
 */
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        // 创建哈希表，保存字符串p中每个字符出现的次数
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        // 创建哈希表，用于保存滑动窗口中字符的出现次数
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (pMap.containsKey(c) && windowMap.get(c).equals(pMap.get(c))) {
                count++;
            }

            if (right - left + 1 == p.length()) {
                if (count == pMap.size()) {
                    result.add(left);
                }

                char leftChar = s.charAt(left);
                if (pMap.containsKey(leftChar) && windowMap.get(leftChar).equals(pMap.get(leftChar))) {
                    count--;
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }

                left++;
            }

            right++;
        }


        return result;
    }


}
