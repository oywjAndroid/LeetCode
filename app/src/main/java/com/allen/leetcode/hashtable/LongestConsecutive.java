package com.allen.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4200
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * HashSet底层使用的HashMap实现的，HashSet中的每个元素都会被保存到 HashMap中的key中，对应的value是一个常量Object对象。
 * Java中哈希表的数据结构体现：HashMap、HashSet，具体使用则看需要保存键值对，还是键。
 *
 * @Author Allen
 * @Date 05-12-2023 周五 16:25
 */
public class LongestConsecutive {


    /**
     * 由于内部使用了快速排序，快速排序的平均情况的时间复杂度是O(nlogN)，再加上排序之后还有for循环的嵌套，
     * 因此总的时间复杂度是O(nlogN+n^2)
     * 无法满足题目中O(N)的时间复杂度
     */
    public static int longestConsecutive1(int[] nums) {
        // 1.获取整数数组中最长数字序列的长度
        int maxLen = 0;

        // 2.如何计算数字序列,随便从数组中取出一个数 x , 如果其他数据满足 Math.abs(x - num) = 1，
        // 通过上面的计算只能知道两个数是否相邻，如果整数数组是无序的无法判断,因此需要先进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int len = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - num == 1) {
                    num = nums[j];
                    len += 1;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    /**
     * 要想把时间复杂度提升到O(N)，只能从优化序列元素查找的方面下手，而且不能进行排序，查找时间复杂度O(1)的数据结构有哈希表，
     * 将数据结构替换成哈希表，是否能达到目的呢？
     */
    public static int longestConsecutive2(int[] nums) {
        // 1.将元素保存到哈希表中，不仅可以去重还可以将元素查询的时间复杂度降到O(1)
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int maxLen = 0;
        for (int num : hashSet) {
            int curNum = num;
            int curLen = 1;

            // 2.如果存在相邻的数在其左侧，则本次不需要处理，当处理其相邻数的时候，会把该数计算在内
            if (hashSet.contains(curNum - 1)) {
                continue;
            }

            while (hashSet.contains(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }


}
