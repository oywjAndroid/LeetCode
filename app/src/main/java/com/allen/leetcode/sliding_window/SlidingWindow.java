package com.allen.leetcode.sliding_window;

/**
 *
 * 一、滑动窗口算法思路：
 *     1、初始化左指针和右指针，将它们都指向滑动窗口的起始位置。
 *     2、开始移动右指针，扩展滑动窗口，同时更新窗口内的状态。
 *     3、当满足特定条件时，记录或处理当前窗口的结果。
 *     4、如果窗口内的状态不满足条件，移动左指针，缩小窗口，同时更新窗口内的状态。
 *     5、重复步骤2到4，直到右指针到达数组或字符串的末尾。
 *
 * 二、具体实例
 *
 *      给定一个字符串s，找出其中不含重复字符的最长子串的长度。例子：s = "abcabcbb"
 *
 *      (1) 解决思路：
 *          1、初始化一个空的滑动窗口和最大长度变量。
 *          2、开始移动右指针，逐步扩展滑动窗口。
 *          3、如果当前字符不在窗口中，将其加入窗口，并更新最大长度。
 *          4、如果当前字符已经在窗口中，移动左指针，缩小窗口直到不包含重复字符。
 *          5、重复步骤2到4，直到右指针到达字符串末尾。
 *      (2) 详细过程:
 *
 * @Author Allen
 * @Date 05-17-2023 周三 17:07
 */
public class SlidingWindow {
}
