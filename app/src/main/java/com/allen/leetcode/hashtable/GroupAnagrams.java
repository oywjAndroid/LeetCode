package com.allen.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 解题思路，字母异位字符串即字符串中的字母一致，只是排列顺序不一致，也就是如果将这些字符串排序后它们对应的字符串是同一个，
 * 也就是将排序后字符串作为哈希表中的key，就可以将字母异位词对应保存起来。
 * <p>
 * 利用哈希表特性解题。
 *
 * @Author Allen
 * @Date 05-12-2023 周五 11:40
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            // 1.将字符串排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);

            // 2.利用哈希表
            List<String> valueStrs = maps.get(keyStr);
            if (valueStrs == null) {
                valueStrs = new ArrayList<>();
            }
            valueStrs.add(str);
            maps.put(keyStr, valueStrs);
        }
        return new ArrayList<>(maps.values());
    }


}
