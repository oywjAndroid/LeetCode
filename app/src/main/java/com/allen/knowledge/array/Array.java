package com.allen.knowledge.array;

/**
 * 数组算法涉及到的常见技巧代码
 */
public class Array {


    //======================快慢指针法=======================

    /**
     * 删除有序数组中的重复项
     * 例：[0,0,1,2,2,3,3] 不可创建新数组，求出不重复数组的长度.
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


    //======================左右指针法=======================

    /**
     * 利用左右指针实现二分法查找
     * <p>
     * [left         mid       right]
     * <p>
     * [mid] < target，[left        mid    target    right]
     * <p>
     * [mid] > target，[left    target     mid       right]
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 两数之和，使用左右指针法进行两数之和求解，需要保证数组有序
     * <p>
     * numbers[2,7,11,15] sum = 9
     */
    public static int[] twoSum(int[] nums, int sum) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum == sum) {
                return new int[]{left, right};
            } else if (twoSum < sum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * 反转数组或字符串
     */
    public static String reverseString(String string) {
        char[] chars = string.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char tempChar = chars[left];
            chars[left] = chars[right];
            chars[right] = tempChar;
            left++;
            right--;
        }
        return new String(chars);
    }

    /**
     * 回文字符串判断
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
