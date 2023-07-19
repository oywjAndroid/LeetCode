package com.allen.knowledge.double_pointer.left_right_pointer;

/**
 * 寻找一个数，基本的二分搜索
 * 经典二分算法
 */
public class BinarySearch1 {


    public int binarySearch(int[] numbs, int target) {
        int left = 0;
        int right = numbs.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbs[mid] == target) {
                return mid;
            } else if (numbs[mid] < target) {
                left = mid + 1;
            } else if (numbs[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
