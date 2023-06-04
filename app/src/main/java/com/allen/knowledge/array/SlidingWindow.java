package com.allen.knowledge.array;

import android.annotation.SuppressLint;

import java.util.HashMap;
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
     * 最小覆盖字串
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


}
