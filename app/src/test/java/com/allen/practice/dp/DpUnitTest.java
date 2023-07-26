package com.allen.practice.dp;

import com.allen.practice.dp.length_lis.LengthOfLIS01;
import com.allen.practice.dp.length_lis.LengthOfLIS02;
import com.allen.practice.dp.max_envelopes.MaxEnvelopes;
import com.allen.practice.dp.max_longest_comm_subseq.MaxLongestCommSubsequence;
import com.allen.practice.dp.max_sub_array.MaxSubArray;
import com.allen.practice.dp.min_distance.MinDistance;

import org.junit.Test;

/**
 * @Description TODO
 * @Author Allen
 * @Date 07-21-2023 周五 10:46
 */
public class DpUnitTest {

    @Test
    public void runLengthOfLIS01() {
        //int[] numbs = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        //int[] numbs = new int[]{0,1,0,3,2,3};
        int[] numbs = new int[]{7, 7, 7, 7, 7, 7, 7};
        LengthOfLIS01 lengthOfLIS = new LengthOfLIS01();
        int length = lengthOfLIS.lengthOfLIS(numbs);
        System.out.println("length = " + length);
    }

    @Test
    public void runLengthOfLISO2() {
        //int[] numbs = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        //int[] numbs = new int[]{0,1,0,3,2,3};
        int[] numbs = new int[]{7, 7, 7, 7, 7, 7, 7};
        LengthOfLIS02 lengthOfLIS = new LengthOfLIS02();
        int length = lengthOfLIS.lengthOfLIS(numbs);
        System.out.println("length = " + length);
    }

    @Test
    public void runMaxEnvelopes() {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}, {7, 9}};
        int maxEnvelopes = new MaxEnvelopes().maxEnvelopes(envelopes);
        System.out.println("maxEnvelopes=" + maxEnvelopes);
    }

    @Test
    public void runMaxSubArray() {
        //int[] numbs = {-3, 1, 3, -1, 2, -4, 2};
        int[] numbs = {-3, -1, -3, -1, -9, -4, -2};
        //int[] numbs = {-2,1};
        int maxSum = new MaxSubArray().maxSubArray(numbs);
        System.out.println("maxSum=" + maxSum);
    }

    @Test
    public void runMaxLongestCommSubsequence() {
//        String str1 = "abcde";
//        String str2 = "aceb";

//        String str1 = "babcde";
//        String str2 = "abce";

        // ?
        //String str2 = "dbdksdkfnalkdfa";
        //String str1 = "sdkls";

        String str1 = "bsbininm";
        String str2 = "jmjkbkjkv";

//        int longestCommSubsequence = new MaxLongestCommSubsequence().longestCommSubsequence_error(str1, str2);
//        System.out.println("longestCommSubsequence=" + longestCommSubsequence);

        int longestCommSubsequence = new MaxLongestCommSubsequence().longestCommSubsequence(str1, str2);
        System.out.println("longestCommSubsequence=" + longestCommSubsequence);
    }

    @Test
    public void runMinDistance() {
//        String word1 = "horse";
//        String word2 = "ros";
       String word1 = "intention";
       String word2 = "execution";

        int minDistance = new MinDistance().minDistance(word1, word2);
        System.out.println("minDistance=" + minDistance);
    }


}
