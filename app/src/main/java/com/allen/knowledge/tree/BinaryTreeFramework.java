package com.allen.knowledge.tree;

/**
 * 二叉树题目解题思路
 * 1、第一类是通过遍历一边二叉树得到答案，对应回溯算法核心框架
 * 2、第二类是通过分解问题计算出答案，对应动态规划核心框架
 */
public class BinaryTreeFramework {

    public static class MaxDepth {
        // 记录最大深度
        int maxDepth = 0;
        // 记录遍历到的节点深度
        int depth = 0;

        public <T> int getMaxDepth(TreeNode<T> root) {
            traverse(root);
            return maxDepth;
        }

        private <T> void traverse(TreeNode<T> root) {
            if (root == null) {
                return;
            }

            depth++;
            if (root.getLeftChild() != null) {
                traverse(root.getLeftChild());
            }

            if (root.getLeftChild() == null && root.getRightChild() == null) {
                maxDepth = Math.max(maxDepth, depth);
            }

            if (root.getRightChild() != null) {
                traverse(root.getRightChild());
            }
            depth--;
        }
    }


}
