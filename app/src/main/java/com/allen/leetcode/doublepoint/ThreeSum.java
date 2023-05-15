package com.allen.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为0且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * 该题使用暴力枚举法，也可以求出答案，但是时间复杂度将会有O(N^3)
 * <p>
 * 使用排序+双指针解答该题可以降低时间复杂度。
 * <p>
 * 排序后不仅可以更方便处理重复元素，还可以方便查找
 *
 * @Author Allen
 * @Date 05-15-2023 周一 14:47
 */
public class ThreeSum {


    /**
     * [-1, 0, 1, 2, -1, -4]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println("nums:" + Arrays.toString(nums));
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            int num = nums[i];// 双指针查找的数据其实就是(0-num)，问题又简化成在有序数组中进行数的查找

            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(num, nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
