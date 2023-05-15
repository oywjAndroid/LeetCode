package com.allen.leetcode.doublepoint;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 该题考查的是数组的操作技巧，双指针法。
 * <p>
 * 双指针法：使用两个指针来遍历一个数组或列表，通常这两个指针分别从序列的头和尾分别向中间靠拢，直到两个指针相遇。
 * <p>
 * 双指针法使用的场景：用于一个有序数组或列表进行遍历和查找操作。
 * <p>
 * 双指针还可以解决一些其他的问题，比如：反转一个字符串或数组，或者在一个无序数组中查找一段连续的子数组。
 *
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/05/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MoveZeroes {

    /**
     * [0,1,0,3,12]
     * 将0移动到数组末尾
     */
    public static void moveZeroes2Tail(int[] nums) {
        int size = nums.length;
        int left = 0;
        int right = 0;
        while (right < size) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }


    public static void moveZeroes2Header(int[] nums){
        int size = nums.length;
        int left = size - 1;
        int right = size - 1;
        while (left >= 0){
            if (nums[left] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
            left--;
        }
    }

}
