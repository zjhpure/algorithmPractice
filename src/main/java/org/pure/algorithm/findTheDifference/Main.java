package org.pure.algorithm.findTheDifference;

//import java.util.HashMap;
//import java.util.Map;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-29 23:17
 * @description 找不同
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        char result = findTheDifference(str1, str2);
        System.out.println(result);
    }

    private static char findTheDifference(String s, String t) {
        // 用位运算方法找出字符串t中比字符串s中多出的字符
        int res = 0;

        // 先遍历字符串s的的字符，每次都进行异或运算
        for (int i = 0; i < s.length(); ++i) {
            res ^= s.charAt(i);
        }

        // 再遍历字符串t的字符，每次都进行异或运算
        for (int i = 0; i < t.length(); ++i) {
            res ^= t.charAt(i);
        }

        // 相同两数异或运算，得到0
        // 0和某数异或运算，得到某数本身
        // 这里把字符串s和字符串t的所有字符进行了异或运算，刚好字符串t中包含所有字符串s中的字符，并且字符串t中多出一个额外字符，那么最终的结果就是额外字符本身

        return (char) res;
    }

//    // 不知道为什么，这种方法不行，LeetCode上的两个长字符输入，这里的结果会出错，目前原因不明
//    private static char findTheDifference(String s, String t) {
//        if (t.length() > 1) {
//            // 若字符串t的航都大于1
//            // 定义集合map
//            Map<Character, Integer> map = new HashMap<>();
//
//            // 遍历字符串t的字符
//            for (int i = 0; i < t.length(); ++i) {
//                char c = t.charAt(i);
//
//                if (s.indexOf(c) >= 0) {
//                    // 若字符在字符串s中，添加到集合map中统计数量
//                    if (map.containsKey(c)) {
//                        // 若集合map中已存在此字符，字符数量加1
//                        map.put(c, map.get(c) + 1);
//                    } else {
//                        // 若集合map中没有此字符，添加到集合map中，字符数量为1
//                        map.put(c, 1);
//                    }
//                } else {
//                    // 若字符不在字符串s中，那么这个字符肯定就是t中被添加的字符
//                    return c;
//                }
//            }
//
//            // 若上面没有找到不在字符串s中的字符，那么问题就变成寻找集合map中数量大于1的字符
//
//            // 遍历集合map
//            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                if (entry.getValue() > 1) {
//                    // 若有字符的数量大于1，那么这个字符就是t中被添加的字符
//                    return entry.getKey();
//                }
//            }
//
//            return t.charAt(0);
//        } else {
//            // 若字符串t的长度只有1，那么t中被添加的字符肯定就是第一个字符
//            return t.charAt(0);
//        }
//    }

}
