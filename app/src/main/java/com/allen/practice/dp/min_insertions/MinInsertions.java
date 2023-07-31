package com.allen.practice.dp.min_insertions;

/**
 * 动态规划练习题07：以最小插入次数构建回文串
 * <p>
 * （回文串：正着读与反着读都一样的字符）
 * 输入一个字符串s，可以在字符串的任意位置插入任意字符。如果要把s变成回文串，
 * 请计算最少要进行多少次插入？
 * 比如：输入s="abcea"，算法返回2，因为可以s插入2个字符变成回文串"abeceba"或者"aebcbea"。
 * 如果输入s="aba"，则算法返回0，因为s已经是回文串，不用插入任何字符。
 * <p>
 * dp(i,j) = s[i...j] 最少插入次数
 * dp(i,j) = dp(i+1,j-1) = x
 * base case: dp(i,j) -> i==j = 0
 * if s[i] == s[j]
 * return x;
 * eles
 * return x+2; // s = "ab" 其实只需要插入a就行，
 * <p>
 * abcbb -> abbcbba 在i位置插入s[j]，在j位置插入s[i] 需要+2
 * ab
 * <p>
 * ---- 0  1  2  3  4  j
 * i	a  b  c  e  a
 * 0	0  1  2  3  ?
 * 1	   0  1  2  3
 * 2	      0  1  2
 * 3	         0  1
 * 4	            0
 */
public class MinInsertions {

    public int minInsertions(String s) {
        return 0;
    }
}
