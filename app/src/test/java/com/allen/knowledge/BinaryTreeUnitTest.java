package com.allen.knowledge;

import com.allen.knowledge.tree.BinaryTree;
import com.allen.knowledge.tree.BinaryTreeFramework;
import com.allen.knowledge.tree.TreeNode;
import com.allen.practice.InvertTree;

import org.junit.Test;


public class BinaryTreeUnitTest {


    /**
     * 示例二叉树：
     * A
     * /   \
     * B     D
     * \   /
     * F  I
     * /
     * L
     */
    @Test
    public void testTraverse() {
        TreeNode<String> A = new TreeNode<>("A");
        TreeNode<String> B = new TreeNode<>("B");
        TreeNode<String> D = new TreeNode<>("D");
        TreeNode<String> F = new TreeNode<>("F");
        TreeNode<String> L = new TreeNode<>("L");
        TreeNode<String> I = new TreeNode<>("I");
        A.setLeftChild(B);
        A.setRightChild(D);
        B.setRightChild(F);
        F.setLeftChild(L);
        D.setLeftChild(I);

        BinaryTree binaryTree = new BinaryTree();
        System.out.println("---前序遍历---");
        binaryTree.preTraverse(A);

        System.out.println("\n---中序遍历---");
        binaryTree.inTraverse(A);

        System.out.println("\n---后序遍历---");
        binaryTree.postTraverse(A);
    }

    @Test
    public void testMaxDepth() {
        TreeNode<Integer> root = new TreeNode<>(3);
        TreeNode<Integer> rootLeft = new TreeNode<>(9);
        TreeNode<Integer> rootRight = new TreeNode<>(20);
        TreeNode<Integer> leftChild = new TreeNode<>(15);
        TreeNode<Integer> rightChild = new TreeNode<>(7);

        root.setLeftChild(rootLeft);
        root.setRightChild(rootRight);
        rootRight.setLeftChild(leftChild);
        rootRight.setRightChild(rightChild);

        BinaryTreeFramework.MaxDepth maxDepth = new BinaryTreeFramework.MaxDepth();
        int maxDepthVal = maxDepth.getMaxDepth(root);
        System.out.println("maxDepthVal = " + maxDepthVal);
    }

    @Test
    public void testInvertTree() {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> rootLeftChild = new TreeNode<>(2);
        TreeNode<Integer> rootRightChild = new TreeNode<>(7);
        TreeNode<Integer> leftChildLeft = new TreeNode<>(1);
        TreeNode<Integer> leftChildRight = new TreeNode<>(3);
        TreeNode<Integer> rightChildLeft = new TreeNode<>(6);
        TreeNode<Integer> rightChildRight = new TreeNode<>(9);

        root.setLeftChild(rootLeftChild);
        root.setRightChild(rootRightChild);
        rootLeftChild.setLeftChild(leftChildLeft);
        rootLeftChild.setRightChild(leftChildRight);
        rootRightChild.setLeftChild(rightChildLeft);
        rootRightChild.setRightChild(rightChildRight);

        InvertTree invertTree = new InvertTree();
        printBinaryTree(root);
        System.out.println();
        invertTree.invertTree(root);
        printBinaryTree(root);
    }


    public <T> void printBinaryTree(TreeNode<T> treeNode){
        if (treeNode == null){
            return;
        }
        System.out.print(treeNode.getData()+" ");
        printBinaryTree(treeNode.getLeftChild());
        printBinaryTree(treeNode.getRightChild());
    }


}
