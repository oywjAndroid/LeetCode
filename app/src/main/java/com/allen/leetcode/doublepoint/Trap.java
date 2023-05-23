package com.allen.leetcode.doublepoint;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例一
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1] , size=12
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例二
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * 木桶效应，能装多少水取决于最短的那个木板，比较height[left]、height[right]找到谁是木桶短板边，
 * 则从哪边进行处理，并按列计算盛水量。
 *
 * @Author Allen
 * @Date 05-16-2023 周二 18:19
 */
public class Trap {

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {// 短板在左边
                if (height[left] > leftMaxHeight) {
                    leftMaxHeight = height[left];
                } else {
                    water += leftMaxHeight - height[left];
                }
                left++;
            } else {// 短板在右边
                if (height[right] > rightMaxHeight) {
                    rightMaxHeight = height[right];
                } else {
                    water += rightMaxHeight - height[right];
                }
                right--;
            }
        }
        return water;
    }


//        int n = height.length;
//        int L = 0;
//        int R = L + 1;
//        int trapSum = 0;
//
//        while (L < R && R < n) {
//            int w = R - L;
//            if (w <= 1) {
//                R++;
//            } else {
//                int minHeight = Math.min(height[L], height[R]);
//                if (minHeight > 0) {
//                    if (height[L] <= height[R]) {
//
//                        for (int i = L + 1; i < R; i++) {
//                            int trap = minHeight - height[i];
//                            if (trap > 0) {
//                                trapSum += trap;
//                            }
//                        }
//                        L = R;
//                        R = L + 1;
//                    } else {
//                        if (R < n - 1) {
//                            R++;
//                        } else {
//                            L++;
//                        }
//                    }
//                } else {
//                    if (height[L] == 0) {
//                        L++;
//                    }
//                    if (height[R] == 0) {
//                        R++;
//                    }
//                }
//            }
//        }
//
//        return trapSum;


}
