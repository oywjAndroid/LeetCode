package com.allen.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Allen
 * @Date 05-11-2023 周四 13:50
 */
public class TwoSum {

    /**
     * 暴力求解法，两数之和求解的 y = target-x，通过一次遍历可以得到nums中的所有数，这些都需要作为x,
     * 再遍历其他的数，就可以看数组中有没有合适的y值。
     */
    public static int[] twoSum1(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int diff = target - nums[i];
                if (nums[j] == diff) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 暴力求解法的时间复杂度为O(N^2)，如果使用哈希表这种数据结构，可以降低时间复杂度
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
