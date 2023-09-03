package com.allen.leetcode.dp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        return dp(0, s.length() - 1, s);
    }

    // babad
    private String dp(int left, int right, String s) {
        if (isPalindromeStr(left, right, s)) {
            String subStr = s.substring(left, right + 1);
            System.out.println("Yes,[" + left + "," + right + "] = " + subStr);
            return subStr;
        }

        if (left <= right) {
            String subStr = s.substring(left, right + 1);
            System.out.println("No,[" + left + "," + right + "] = " + subStr);
        }

        String leftStr = dp(left, right - 1, s);
        System.out.println("leftStr=" + leftStr);
        String rightStr = dp(left + 1, right, s);
        System.out.println("rightStr=" + rightStr);
        return leftStr.length() >= rightStr.length() ? leftStr : rightStr;
    }


    private boolean isPalindromeStr(int left, int right, String s) {
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
