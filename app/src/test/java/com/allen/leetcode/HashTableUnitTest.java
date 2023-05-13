package com.allen.leetcode;

import com.allen.leetcode.hashtable.GroupAnagrams;
import com.allen.leetcode.hashtable.LongestConsecutive;
import com.allen.leetcode.hashtable.TwoSum;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 哈希表数据结构题的单元测试
 * @Author Allen
 * @Date 05-12-2023 周五 16:05
 */
public class HashTableUnitTest {

    @Test
    public void twoSum1() {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        System.out.println("nums:" + Arrays.toString(nums) + ",target:" + target);
        int[] twoSum = TwoSum.twoSum1(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    @Test
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        System.out.println("nums:" + Arrays.toString(nums) + ",target:" + target);
        int[] twoSum = TwoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    @Test
    public void groupAnagrams() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "atb", "tab"};
        System.out.println("strs:" + Arrays.toString(strs));
        List<List<String>> lists = GroupAnagrams.groupAnagrams(strs);
        System.out.println("result:" + Arrays.toString(lists.toArray()));
    }

    @Test
    public void longestConsecutive1() {
        int[] nums = new int[]{100, 5, 7, 6, 100, 100, 4, 200, 1, 3, 2, 9, 9, 8, 10};
        //int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println("nums:" + Arrays.toString(nums));
        long before = System.currentTimeMillis();
        int maxLen = LongestConsecutive.longestConsecutive1(nums);
        long after = System.currentTimeMillis();
        System.out.println("maxLen:" + maxLen + ",run time:" + (after - before));
    }


    @Test
    public void longestConsecutive2() {
        int[] nums = new int[]{100, 5, 7, 6, 100, 100, 4, 200, 1, 3, 2, 9, 9, 8, 10};
        //int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("nums:" + Arrays.toString(nums));
        long before = System.currentTimeMillis();
        int maxLen = LongestConsecutive.longestConsecutive2(nums);
        long after = System.currentTimeMillis();
        System.out.println("maxLen:" + maxLen + ",run time:" + (after - before));
    }
}
