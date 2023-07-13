package com.allen.knowledge;

import com.allen.knowledge.tree.backtrack.SolveNQueens;

import org.junit.Test;

import java.util.List;

/**
 * @Description TODO
 * @Author Allen
 * @Date 07-13-2023 周四 14:01
 */
public class SolveNQueensUnitTest {

    @Test
    public void runSolveNQueens() {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> result = solveNQueens.solveNQueens(5);
        System.out.println("result:" + result);
    }

}
