package com.allen.knowledge;

import com.allen.knowledge.tree.dp.CoinChangeBottomUp;
import com.allen.knowledge.tree.dp.CoinChangeTopDown;

import org.junit.Test;

/**
 * @Description TODO
 * @Author Allen
 * @Date 07-10-2023 周一 16:33
 */
public class DpUnitTest {

    @Test
    public void testCoinChange() {
        CoinChangeTopDown coinChange = new CoinChangeTopDown();
        int minCount = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("minCount = " + minCount);

        CoinChangeBottomUp coinChange2 = new CoinChangeBottomUp();
        int minCount2 = coinChange2.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("minCount2 = " + minCount2);
    }

}
