package org.pure.algorithm.longestSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-17 02:37
 * @description 无重复字符的最长子串长度
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        int size = lengthOfLongestSubstring(str);
        System.out.println(size);
    }

//    private static int lengthOfLongestSubstring(String s) {
//        // 最长字串长度
//        int size = 0;
//
//        if (s != null && !"".equals(s) && s.length() > 0) {
//            // 最长字串列表
//            List<Character> charList = new ArrayList<>();
//
//            // 遍历i次，获得i次最长字串长度
//            for (int i = 0; i <= s.length() - 1; ++i) {
//                // 构造最长字串列表
//                for (int j = i; j <= s.length() - 1; ++j) {
//                    char c = s.charAt(j);
//
//                    // 判断字符是否在最长字串列表中
//                    if (charList.contains(c)) {
//                        break;
//                    } else {
//                        charList.add(c);
//                    }
//                }
//
//                // 更新最长字串长度
//                if (charList.size() > size) {
//                    size = charList.size();
//                }
//
//                // 字串列表清空元素
//                charList.clear();
//            }
//        }
//
//        return size;
//    }

    private static int lengthOfLongestSubstring(String s) {
        // 最长字串长度
        int size = 0;

        if (s != null && !"".equals(s) && s.length() > 0) {
            // 字串集合
            Map<Character, Integer> map = new HashMap<>();

            // 起始索引
            int start = 0;

            // 遍历字符串
            for (int i = 0; i <= s.length() - 1; ++i) {
                char c = s.charAt(i);

                // 判断字符是否在字串集合中
                if (map.containsKey(c)) {
                    int index = map.get(c) + 1;

                    // 更新起始索引
                    if (index > start) {
                        start = index;
                    }
                }

                // 获取当前最长字串长度
                int length = i - start + 1;

                // 更新最长字串长度
                if (length > size) {
                    size = length;
                }

                map.put(c, i);
            }
        }

        return size;
    }

}
