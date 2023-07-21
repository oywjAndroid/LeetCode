package com.allen.practice.dp;

import com.allen.practice.dp.length_lis.LengthOfLIS01;
import com.allen.practice.dp.length_lis.LengthOfLIS02;

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
        int[] numbs = new int[]{7,7,7,7,7,7,7};
        LengthOfLIS01 lengthOfLIS = new LengthOfLIS01();
        int length = lengthOfLIS.lengthOfLIS(numbs);
        System.out.println("length = " + length);
    }

    @Test
    public void runLengthOfLISO2(){
        //int[] numbs = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        //int[] numbs = new int[]{0,1,0,3,2,3};
        int[] numbs = new int[]{7,7,7,7,7,7,7};
        LengthOfLIS02 lengthOfLIS = new LengthOfLIS02();
        int length = lengthOfLIS.lengthOfLIS(numbs);
        System.out.println("length = " + length);
    }


}
