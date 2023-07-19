package com.allen.knowledge.double_pointer.left_right_pointer;

/**
 * 右边界二分搜索
 * 如：[1,2,2,2,6] target = 2,返回的索引位置为3
 * 也可以理解为查询数组中大于target的数个数
 */
public class RightBoundBinarySearch {

    public int binarySearch(int[] numbs, int target) {
        if (numbs == null || numbs.length == 0) {
            return -1;
        }
        // [left,right)
        int left = 0;
        int right = numbs.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbs[mid] == target) {
                left = mid + 1;//[mid+1,right)
            } else if (numbs[mid] > target) {
                right = mid;//[left,mid)
            } else if (numbs[mid] < target) {
                left = mid + 1;//[mid+1,right)
            }
        }
        return left - 1;
    }

    public int binarySearch2(int[] numbs, int target) {
        if (numbs == null || numbs.length == 0) {
            return -1;
        }
        //[left,right]
        int left = 0;
        int right = numbs.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbs[mid] == target) {
                left = mid + 1;//[mid+1,right]
            } else if (numbs[mid] < target) {
                left = mid + 1;//[mid+1,right]
            } else if (numbs[mid] > target) {
                right = mid - 1;//[left,mid -1]
            }
        }

        if (right < 0 || numbs[right] != target) {
            return -1;
        }
        return right;
    }


}
