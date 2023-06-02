package com.allen.leetcode;

import com.allen.leetcode.sub_string.SubArraySum;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Allen
 * @Date 05-31-2023 周三 15:49
 */
public class SubstringUnitTest {

    @Test
    public void subArraySum() {
        int[] nums = {1, 1, 1};
        int k = 2;
        //int[] nums = {1,2,3};
        //int k = 3;
        System.out.println("nums:" + Arrays.toString(nums) + ",k:" + k);
        int subArraySum = SubArraySum.subArraySum(nums, k);
        System.out.println("subArraySum:" + subArraySum);
    }

}
