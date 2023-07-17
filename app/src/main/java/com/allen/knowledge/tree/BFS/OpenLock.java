package com.allen.knowledge.tree.BFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS算法经典例题：开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */
public class OpenLock {

    /**
     * 向上拨动转盘锁
     *
     * @param password 现在的密码
     * @param index    转盘角标
     * @return 波动后的密码
     */
    private String plusOne(String password, int index) {
        char[] passwords = password.toCharArray();
        if (passwords[index] == '9') {
            passwords[index] = '0';
        } else {
            passwords[index] += 1;
        }
        return new String(passwords);
    }

    /**
     * 向下拨动转盘锁
     *
     * @param password 同上
     * @param index    同上
     * @return 同上
     */
    private String minusOne(String password, int index) {
        char[] passwords = password.toCharArray();
        if (passwords[index] == '0') {
            passwords[index] = '9';
        } else {
            passwords[index] -= 1;
        }
        return new String(passwords);
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int depth = 0;
        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                System.out.println(cur);

                if (cur.equals(target)) {
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    q.offer(up);
                    q.offer(down);
                }
            }
        }


        return depth;
    }


}
