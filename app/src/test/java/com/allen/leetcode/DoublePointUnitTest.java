package com.allen.leetcode;

import com.allen.leetcode.doublepoint.MoveZeroes;

import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/05/14
 *     desc   :
 *     version: 1.0
 * </pre>
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
}
