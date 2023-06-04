package com.allen.knowledge;

import com.allen.knowledge.array.Array;
import com.allen.knowledge.array.DiffArray;
import com.allen.knowledge.array.NumberArray;
import com.allen.knowledge.array.SlidingWindow;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Allen
 * @Date 06-01-2023 周四 14:38
 */
public class ArrayUnitTest {

    @Test
    public void testTwoSum() {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        System.out.println("array:" + Arrays.toString(array) + ",target:" + target);
        int[] result = Array.twoSum(array, target);
        System.out.println("result:" + Arrays.toString(result));
    }

    @Test
    public void testReverseString() {
        String str = "abcdefghiklmn";
        System.out.println("str:" + str);
        String reverseStr = Array.reverseString(str);
        System.out.println("reverse str:" + reverseStr);
    }

    @Test
    public void testPalindrome() {
        String str = "abbcdcdcdba";
        boolean isPalindrome = Array.isPalindrome(str);
        System.out.println("isPalindrome = " + isPalindrome);
    }

    @Test
    public void testNumberArray() {
        int[] originArray = {3, 5, 2, -2, 4, 1};
        System.out.println("origin array:" + Arrays.toString(originArray));
        NumberArray numberArray = new NumberArray(originArray);
        System.out.println("[0,2] sum = " + numberArray.sumRange(0, 2));
        System.out.println("[0,3] sum = " + numberArray.sumRange(0, 3));
        System.out.println("[1,4] sum = " + numberArray.sumRange(1, 4));
        System.out.println("[2,5] sum = " + numberArray.sumRange(2, 5));
    }

    @Test
    public void testDiffArray() {
        int[] originArray = {3, 5, 2, -2, 4, 1};
        System.out.println("origin array:" + Arrays.toString(originArray));
        DiffArray diffArray = new DiffArray(originArray);
        int[] numbers = diffArray.getNumbers();
        System.out.println("numbers:" + Arrays.toString(numbers));

        diffArray.increment(0, 4, 5);
        System.out.println("[0,4] + 5 = " + Arrays.toString(diffArray.getNumbers()));
    }

    @Test
    public void testSlidingWindow() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        //String s = "a";
        //String t = "a";
        System.out.println("Input: s = " + s + ",t = " + t);
        SlidingWindow slidingWindow = new SlidingWindow();
        String minString = slidingWindow.minWindow(s, t);
        System.out.println("minString = " + minString);
    }

    @Test
    public void testCheckInclusion() {
        //String s1 = "ab";
        //String s2 = "eidbaooo";
        String s1 = "ab";
        String s2 = "eidboaoo";

        //String s1 = "abcdxabcde";
        //String s2 = "abcdeabcdx";
        System.out.println("Input: s1 = " + s1 + ",s2 = " + s2);
        SlidingWindow slidingWindow = new SlidingWindow();
        boolean isInclusion = slidingWindow.checkInclusion(s1, s2);
        System.out.println("isInclusion = " + isInclusion);
    }

}
