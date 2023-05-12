package com.allen.leetcode;

import com.allen.leetcode.hashtable.GroupAnagrams;
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
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
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

}
