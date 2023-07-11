package com.allen.knowledge.tree.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法经典例题，全排列问题
 * 1、路径，用于记录可行解
 * 2、选择列表，穷举的选择条件
 * 3、结束条件，
 * <p>
 * 1
 * / \
 * 2  3
 * |  |
 * 3  2
 * <p>
 */
public class PermuteSample {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // 1.满足结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 2.遍历选择列表
        for (int num : nums) {
            // 3.做选择
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            // 4.进入下一个决策树
            backtrack(nums, track);
            // 5.撤销选择
            track.removeLast();
        }
    }

}
