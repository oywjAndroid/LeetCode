package com.allen.knowledge;

import com.allen.knowledge.tree.backtrack.PermuteSample;

import org.junit.Test;

import java.util.List;

public class PermuteUnitTest {

    @Test
    public void runPermute() {
        PermuteSample permute = new PermuteSample();
        List<List<Integer>> res = permute.permute(new int[]{1, 2, 3});
        System.out.println("res:" + res);
    }

}
