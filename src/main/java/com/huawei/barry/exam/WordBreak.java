/*
 * Copyright Huawei Reserved. *
 **/

package com.huawei.barry.exam;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        String s = "abcabcd";
        String[] wordDict = new String[] {"a", "abc", "b", "cd"};

        System.out.println(wordBreak3(s, Arrays.asList(wordDict)));

    }

    // catsandog
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean isfind = false;
        if (wordDict.contains(s)) {
            return true;
        }
        for (String item : wordDict) {
            if (s.startsWith(item)) {
                // 采用java的startwith来处理，效率较低。
                String trimString = s.substring(s.indexOf(item) + item.length(), s.length());
                // String trimString = s.replaceAll("^(" + item + ")+", "");
                System.out.println(trimString);
                isfind = wordBreak(trimString, wordDict);
                if (isfind) {
                    return isfind;
                }
            }
        }
        return isfind;
    }

    // catsandog
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String head = s.substring(0, i);
            String trail = s.substring(i, s.length());
            // System.out.println("head-trail:"+head+"+"+trail);
            if (wordDict.contains(head) & wordBreak2(trail, wordDict)) {
                return true;
            }
        }
        return false;
    }

    // 用数组来实现
    public static boolean wordBreak3(String s, List<String> wordDict) {

        // 构造一个布尔型数组，长度和s一样长，第0个位置直接赋值为1
        boolean[] position = new boolean[s.length() + 1];
        position[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j, i);
                if (position[j] && wordDict.contains(tmp)) {
                    position[i] = true;
                }
            }
        }
        return position[s.length()];
    }

}
