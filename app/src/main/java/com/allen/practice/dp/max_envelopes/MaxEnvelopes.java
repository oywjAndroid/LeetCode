package com.allen.practice.dp.max_envelopes;

import com.allen.practice.dp.length_lis.LengthOfLIS02;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 动态规划练习题02：信封嵌套问题
 *
 * <p>
 * 给出一些信封，每个信封用宽度和高度的整数对形式(w,h)表示。
 * 当一个信封A的宽度和高度都比另一个信封B大的时候，则B就可以放进A里面。
 * <p>
 * 示例：输入envelopes = [[5,4],[6,4],[6,7],[2,3]] ，算法返回3，因为最多有3个信封能够套起来，
 * 它们是：[2,3] => [5,4] => [6,7]
 * <p>
 * <p>
 * 思路分析：
 * 1、首先想到的是比较每个信封的面积，但是发现 [5,4] < [6,4] 但是不能嵌套。
 * 2、如果把信封某一边进行排序
 */
public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        System.out.println("envelopes=" + Arrays.deepToString(envelopes));
        Arrays.sort(envelopes, (o1, o2) -> {
            int compare = o1[0] - o2[0];
            if (compare == 0) {
                compare = o2[1] - o1[1];
            }
            return compare;
        });
        System.out.println("envelopes=" + Arrays.deepToString(envelopes));
        int[] numbs = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            numbs[i] = envelopes[i][1];
        }
        return lis(numbs);
    }

    private int lis(int[] numbs) {
        int[] dp = new int[numbs.length];
        // base case
        dp[0] = 1;
        for (int i = 1; i < numbs.length; i++) {
            // state change equation
            dp[i] = dp[i - 1] + (numbs[i] > numbs[i - 1] ? 1 : 0);
        }
        int maxDp = 0;
        for (int subDp : dp) {
            maxDp = Math.max(subDp, maxDp);
        }
        return maxDp;
    }


}
