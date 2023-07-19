package com.allen.knowledge.tree.BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * BFS算法经典例题，求打开转盘锁的最少次数
 *
 * BFS算法适用场景
 * 1、问题能抽象成图/多叉树
 * 2、计算两个节点的最少次数
 *
 */
public class OpenLock2 {

    String plusOne(String password, int index) {
        char[] chars = password.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    String minusOne(String password, int index) {
        char[] chars = password.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }

    public int openLock(String[] deadEnds, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadEnds));
        Set<String> visitedSet = new HashSet<>();
        String initPassword = "0000";
        q.offer(initPassword);
        visitedSet.add(initPassword);

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                // 跳过不符合要求的密码
                if (deadSet.contains(cur)) {
                    continue;
                }

                // 找到目标
                if (cur.equals(target)) {
                    return depth;
                }

                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(cur, j);
                    if (!visitedSet.contains(plusOne)) {
                        q.offer(plusOne);
                        visitedSet.add(plusOne);
                    }

                    String minusOne = minusOne(cur, j);
                    if (!visitedSet.contains(minusOne)) {
                        q.offer(minusOne);
                        visitedSet.add(minusOne);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

}
