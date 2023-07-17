package com.allen.knowledge.tree.BFS;

import com.allen.knowledge.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS算法（广度优先算法）例题：
 * <p>
 * 给定一个二叉树，找出最小深度，最小深度是从根节点到最近的叶子节点的最短路径上的节点数量。
 * 示例：给定二叉树`[3,9,20,null,null,15,7]`,返回它的最小深度2.
 */
public class MinDepth {


    public int minDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            // 取出当前层的所有节点
            for (int i = 0; i < sz; i++) {
                TreeNode<Integer> cur = q.poll();

                if (cur.getLeftChild() == null && cur.getRightChild() == null) {
                    return depth;
                }

                if (cur.getLeftChild() != null) {
                    q.offer(cur.getLeftChild());
                }
                if (cur.getRightChild() != null) {
                    q.offer(cur.getRightChild());
                }
            }

            depth++;
        }

        return depth;
    }

}
