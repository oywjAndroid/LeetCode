package com.allen.knowledge;

import com.allen.knowledge.tree.BFS.MinDepth;
import com.allen.knowledge.tree.BFS.OpenLock;
import com.allen.knowledge.tree.TreeNode;

import org.junit.Test;

/**
 * @Description TODO
 * @Author Allen
 * @Date 07-13-2023 周四 18:34
 */
public class BFSUnitTest {

    @Test
    public void runMinDepth() {
        TreeNode<Integer> root = new TreeNode<>(3);
        root.setLeftChild(new TreeNode<>(9));
        TreeNode<Integer> right = new TreeNode<>(20);
        right.setLeftChild(new TreeNode<>(15));
        right.setRightChild(new TreeNode<>(7));
        root.setRightChild(right);

        MinDepth depth = new MinDepth();
        int minDepth = depth.minDepth(root);
        System.out.println("min depth:" + minDepth);
    }

    @Test
    public void runOpenLock(){
//        OpenLock openLock = new OpenLock();
//        openLock.openLock("1928");
        byte a = (byte) 0xE6;
        System.out.println("a="+(a&0xFF));

    }
}
