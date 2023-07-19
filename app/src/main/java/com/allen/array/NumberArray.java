package com.allen.array;

/**
 * 给定一个整数numbers,求出数组从 i~j (i<=j)范围内元素的总和，包含i,j两点。
 * <p>
 * 比原数组多一个索引
 * number    :[3, 5, 2, -2, 4, 1]
 * prefixSum :[0, 3, 8, 10, 8, 12, 13]
 * <p>
 * prefixSum[1] = prefixSum[0] + number[0]
 * prefixSum[2] = prefixSum[1] + number[1]
 * prefixSum[3] = prefixSum[2] + number[2]
 * ...
 * prefixSum[n] = prefixSum[n-1] + number[n-1]
 * <p>
 * 0~2区间：prefixSum[3]-prefixSum[0] = 10-0=10;
 *
 * @Author Allen
 * @Date 06-02-2023 周五 10:54
 */
public class NumberArray {

    private final int[] prefixSum;

    public NumberArray(int[] numbers) {
        prefixSum = new int[numbers.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

}
