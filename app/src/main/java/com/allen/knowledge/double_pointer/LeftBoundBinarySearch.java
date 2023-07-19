package com.allen.knowledge.double_pointer;

/**
 * 左边界的二分搜索
 * 如：[1,2,2,2,6] target=2，即寻找数组中最左侧的2的位置
 * 其实也可以理解成numbs中小于target=2的数有多少个。
 */
public class LeftBoundBinarySearch {


    // [1,2,2,2,6]
    public int binarySearch(int[] numbs, int target) {
        if (numbs == null || numbs.length == 0) {
            return -1;
        }
        // 搜索区间[left,right)
        // [0,5)
        int left = 0;
        int right = numbs.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbs[mid] == target) {//[left,mid) [0,2)
                right = mid;//搜索到target相等的数，先不进行返回，需要确保是最左侧的
            } else if (numbs[mid] < target) {//[mid+1,right)
                left = mid + 1;
            } else if (numbs[mid] > target) {//[left,mid)
                right = mid;
            }
        }
        return left;
    }


    public int binarySearch2(int[] numbs, int target) {
        if (numbs == null || numbs.length == 0) {
            return -1;
        }
        // [left,right]
        int left = 0;
        int right = numbs.length - 1;

        while (left <= right) { // 跳出循环的条件[right+1,right]
            int mid = left + (right - left) / 2;
            if (numbs[mid] == target) {//[left,mid-1]
                right = mid - 1;
            } else if (numbs[mid] < target) {
                left = mid + 1;
            } else if (numbs[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= numbs.length || numbs[left] != target) {
            return -1;
        }
        return left;
    }

}
