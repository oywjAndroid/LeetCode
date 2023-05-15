package com.allen.leetcode;

import com.allen.leetcode.doublepoint.MoveZeroes;
import com.allen.leetcode.doublepoint.MaxArea;
import com.allen.leetcode.doublepoint.ThreeSum;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/05/14
 *     desc   :
 *     version: 1.0
 * </pre>
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author Allen
 * @Date 05-15-2023 周一 13:53
 */
public class DoublePointUnitTest {

    @Test
    public void moveZeroes2Tail() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println("nums:" + Arrays.toString(nums));
        MoveZeroes.moveZeroes2Tail(nums);
        System.out.println("nums:" + Arrays.toString(nums));
    }

    @Test
    public void moveZeroes2Header() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println("nums:" + Arrays.toString(nums));
        MoveZeroes.moveZeroes2Header(nums);
        System.out.println("nums:" + Arrays.toString(nums));
    }

    @Test
    public void maxArea() {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7, 9};
        System.out.println("heights:" + Arrays.toString(heights));
        int maxArea = MaxArea.maxArea(heights);
        System.out.println("maxArea:" + maxArea);
    }

    @Test
    public void threeNum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("nums:" + Arrays.toString(nums));
        List<List<Integer>> threeSum = ThreeSum.threeSum(nums);
        String resultString = threeSum.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(resultString);
    }
}
