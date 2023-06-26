package com.allen.knowledge.tree.practice;

import com.allen.knowledge.tree.TreeNode;

/**
 * 翻转二叉树
 *
 * 翻转前
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 翻转后
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author Allen
 * @Date 06-16-2023 周五 16:26
 */
public class InvertTree {


    public TreeNode<Integer> invertTree(TreeNode<Integer> root){
        traverse(root);
        return root;
    }

    private void traverse(TreeNode<Integer> root){
        if (root == null){
            return;
        }

        traverse(root.getLeftChild());

        TreeNode<Integer> temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);

        traverse(root.getRightChild());


    }

}
