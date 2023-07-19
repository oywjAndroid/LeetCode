package com.allen.knowledge;

import com.allen.array.Array;
import com.allen.array.DiffArray;
import com.allen.array.MatrixArray;
import com.allen.array.NumberArray;
import com.allen.array.SlidingWindow;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testFindAnagrams() {
        //String s = "cbaebabacd";
        //String p = "abc";
        String s = "abab";
        String p = "ab";
        System.out.println("s = " + s + ",p = " + p);
        SlidingWindow slidingWindow = new SlidingWindow();
        List<Integer> anagrams = slidingWindow.findAnagrams(s, p);
        System.out.println("anagrams = " + Arrays.toString(anagrams.toArray()));
    }


    @Test
    public void testLengthOfLongestSubstring() {
        //String s = "abcabcbb";
        //String s = "bbbbb";
        String s = "pwwkew";
        System.out.println("s = " + s);
        SlidingWindow window = new SlidingWindow();
        int length = window.lengthOfLongestSubstring(s);
        System.out.println("length = " + length);
    }

    @Test
    public void testClockwiseRotation() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("---------");
        MatrixArray matrixArray = new MatrixArray();
        matrixArray.clockwiseRotation(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void testAnticlockwiseRotation(){
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("---------");
        MatrixArray matrixArray = new MatrixArray();
        matrixArray.anticlockwiseRotation(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
