package com.allen.knowledge.tree.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法经典例题：N皇后问题
 * 给你一个NxN的棋盘，让你放置N个皇后，使得它们不能互相攻击。
 * PS：皇后可以攻击同一行，同一列，左上左下右上右下四个方向的任意单位。
 * '.'表示空，'Q'表示皇后
 *
 * <p>
 * // 回溯算法核心框架
 * //        if (结束条件){
 * //            return;
 * //        }
 * //
 * //        for (选择:选择列表){
 * //            // 做选择
 * //            ...
 * //            backtrack(path,board,++row);
 * //            ...
 * //            // 撤销选择
 * //        }
 * <p>
 * 回溯算法第一步需要明确选择列表，其次再去考虑如何做选择，撤销选择，以及结束条件是什么
 */
public class SolveNQueens {

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        String[][] board = new String[n][n];
        for (String[] strings : board) {
            Arrays.fill(strings, ".");
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(String[][] board, int row) {
        // 已经遍历过所有行
        if (row == board.length) {
            List<String> path = new LinkedList<>();
            for (String[] boardRow : board) {
                path.add(Arrays.toString(boardRow));
            }
            res.add(path);
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            //做选择
            board[row][col] = "Q";
            backtrack(board, row + 1);
            //撤销选择
            board[row][col] = ".";
        }
    }

    /**
     * 检查在某行某列放置皇后是否合法
     */
    private boolean isValid(String[][] board, int row, int col) {
        int n = board.length;

        // 1.检查同一列上是不是有放置皇后
        for (String[] boardRow : board) {
            if (boardRow[col].equals("Q")) {
                return false;
            }
        }

        // 2.检查左上方是不是有放置皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        // 3.检查右上方是不是有放置皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }


}
