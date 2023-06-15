package com.allen.knowledge.tree;

/**
 * 二叉树
 * <p>
 * 1、递归的核心思想，就是利用了函数执行过程中的压栈流程。
 * <p>
 * 2、所谓的前、中、后序遍历，其实指的就是执行递归的前中后位置进行数据的处理。
 * <p>
 * 3、二叉树的前、中、后序遍历实际上是二叉树遍历处理每个节点的三个特殊时间点.
 *
 *
 */
public class BinaryTree {

    /**
     * 前序遍历
     */
    public <T> void preTraverse(TreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        TreeNode<T> leftChild = rootNode.getLeftChild();
        TreeNode<T> rightChild = rootNode.getRightChild();

        // 前序位置
        System.out.print(rootNode.getData() + " ");

        if (leftChild != null) {
            preTraverse(leftChild);
        }

        // 中序位置

        if (rightChild != null) {
            preTraverse(rightChild);
        }

        // 后序位置
    }


    /**
     * 中序遍历
     */
    public <T> void inTraverse(TreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        TreeNode<T> leftChild = rootNode.getLeftChild();
        TreeNode<T> rightChild = rootNode.getRightChild();

        if (leftChild != null) {
            inTraverse(leftChild);
        }

        System.out.print(rootNode.getData() + " ");

        if (rightChild != null) {
            inTraverse(rightChild);
        }
    }

    /**
     * 后序遍历
     */
    public <T> void postTraverse(TreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        TreeNode<T> leftChild = rootNode.getLeftChild();
        TreeNode<T> rightChild = rootNode.getRightChild();

        if (leftChild != null) {
            postTraverse(leftChild);
        }

        if (rightChild != null) {
            postTraverse(rightChild);
        }

        System.out.print(rootNode.getData() + " ");
    }


}
