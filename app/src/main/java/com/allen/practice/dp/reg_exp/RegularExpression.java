package com.allen.practice.dp.reg_exp;

/**
 * 动态规划练习题08：正则表达式
 * <p>
 * 实现一个简单的正则匹配算法，包括"."通配符和"*"通配符。
 * 其中"."可以匹配任意一个字符，"*"可以让之前的那个字符重复任意次数(包括0次)。
 * 比如模式串".a*b"就可以匹配文本"zaaab"，也可以匹配"cb"；模式串"a..b"可以匹配文本"amnb";二模式串".*"可以匹配任何文本。
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class RegularExpression {

//    public boolean isMatch(String s, String p) {
//        int i = 0;
//        int j = 0;
//
//        while (i < s.length() && j < p.length()) {
//            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {// 匹配
//                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
//                    // 存在'*'通配符，能够匹配0次或多次
//                    // aaa  a*
//                    i++;
//                } else {
//                    // 不存在'*'通配符，只能匹配一次
//                    i++;
//                    j++;
//                }
//            } else { // 不匹配
//                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
//                    // 存在'*'通配符，只能匹配0次
//                } else {
//                    // 无'*'通配符，匹配结束
//                    return false;
//                }
//            }
//        }
//
//        return i == j;
//    }


    /**
     * demo 1
     * - a a
     * a
     * <p>
     * s[i] == p[j](a=a)
     * j >= p.length && i < s.length 匹配不成功
     * <p>
     * demo 2
     * - a a
     * a
     * .
     * i >= s.length && j >= p.length 匹配成功
     * <p>
     * demo 3
     * - a a
     * b
     * *
     * a
     * *   ?
     * <p>
     * <p>
     * dp(i,j) => s[0...i] 和 p[0...j] 是否匹配成功
     * 选择：模版字符串中的字符，其实分为两类：* 和 !
     */
    public boolean isMatch(String s, String p) {
        // 1.状态:i,j分别为s,p的指针
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // base case
        if (j == n) {
            return i == m;
        }
        // s="a" p="ab*c*"
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }

            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        System.out.println("i=" + i + ",j=" + j);
        boolean isMatchAsterisk = j + 1 < p.length() && p.charAt(j + 1) == '*';
        // 字符相同或者模版字符为任意匹配符号
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (isMatchAsterisk) {
                // 下一个字符是'*'则表示匹配的次数是0次与多次
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                return dp(s, i + 1, p, j + 1);
            }
        } else {
            if (isMatchAsterisk) {
                return dp(s, i, p, j + 2);
            } else {
                return false;
            }
        }
    }


}
