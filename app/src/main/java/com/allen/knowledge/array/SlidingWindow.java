package com.allen.knowledge.array;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口，快慢指针的应用场景，适用于解决子串问题。
 *
 *
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/06/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@SuppressLint("NewApi")
public class SlidingWindow {

    /**
     * 1.最小覆盖字串
     * <p>
     * 给定一个字符串s,字符串t。返回s中覆盖t所有字符的最小字串。如果不存在覆盖t所有字符的子串，就返回空字符串""。
     * <p>
     * 示例1:
     * 输入：s="ADOBECODEBANC" t="ABC"
     * 输出："BANC"
     * <p>
     * 示例2:
     * 输入：s = "a", t = "a"
     * 输出："a"
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCount = 0;// 记录字符出现的有效次数

        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 扩大窗口
            char cR = s.charAt(right);
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            right++;

            // 如果字符在needs和window中同时存在且出现的次数一致，记录有效次数
            if (needs.containsKey(cR) && window.get(cR).equals(needs.get(cR))) {
                validCount++;
            }

            System.out.printf("window: [%d, %d)\n", left, right);

            // 有效次数等于needs大小时，说明window中包含了needs中所有的字符
            // 需要进行窗口的缩小
            while (left < right && validCount == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char cL = s.charAt(left);
                if (needs.containsKey(cL) && window.get(cL).equals(needs.get(cL))) {
                    validCount--;
                }

                window.put(cL, window.get(cL) - 1);
                left++;
            }
        }

        System.out.printf("subString: [%d, %d)\n", start, start + len);
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    /**
     * 2.字符串排列
     * <p>
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * <p>
     * 示例 1：
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * <p>
     * 示例 2：
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCount = 0;


        while (right < s2.length()) {
            char cR = s2.charAt(right);
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            right++;

            if (needs.containsKey(cR) && window.get(cR).equals(needs.get(cR))) {
                validCount++;
            }

            while (right - left >= s1.length()) {
                // 字符出现的次数与长度都是一致，则说明存在该字串
                if (validCount == needs.size()) {
                    return true;
                }

                char cL = s2.charAt(left);
                if (needs.containsKey(cL) && window.get(cL).equals(needs.get(cL))) {
                    validCount--;
                }

                window.put(cL, window.get(cL) - 1);
                left++;
            }
        }

        return false;
    }

    /**
     * 3.找所有字母异位词
     * <p>
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * <p>
     * 示例1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * <p>
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int validCount = 0;
        for (; right < s.length(); right++) {
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            if (needs.containsKey(c1) && window.get(c1).equals(needs.get(c1))) {
                validCount++;
            }

            // 当窗口大小 >= 字符串p的长度时，需缩小窗口
            if ((right - left + 1) >= p.length()) {
                if (validCount == needs.size()) {
                    result.add(left);
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2) && window.get(c2).equals(needs.get(c2))) {
                    validCount--;
                }
                // window中总是包含了left指向的内容，这是快慢指针的特点
                window.put(c2, window.get(c2) - 1);
                left++;
            }
        }
        return result;
    }

    /**
     * 4.最长无重复子串
     * <p>
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
     * <p>
     * 示例1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char cR = s.charAt(right);
            window.put(cR, window.getOrDefault(cR, 0) + 1);
            right++;

            while (window.get(cR) > 1) {
                char cL = s.charAt(left);
                window.put(cL, window.get(cL) - 1);
                left++;
            }

            // 更新结果
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }


}
