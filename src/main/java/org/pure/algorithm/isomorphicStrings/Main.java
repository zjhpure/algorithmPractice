package org.pure.algorithm.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-05 12:43
 * @description 同构字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean result = isIsomorphic(s, t);
        System.out.println(result);
    }

    private static boolean isIsomorphic(String s, String t) {
        // 定义集合map，保存字符的映射关系
        Map<Character, Character> map = new HashMap<>();

        // 遍历字符串s和字符串t的字符
        for (int i = 0; i < s.length(); ++i) {
            // 获取字符串s的字符
            char a = s.charAt(i);
            // 获取字符串t的字符
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                // 若集合map中存在key值，那么因为一个字符只有一种映射关系，所以判断对于的字符串t中的字符是否和前面映射的字符相等
                if (b != map.get(a)) {
                    // 若字符串t中的字符和前面映射的字符不相等，那么同一个字符映射关系就有多个了，两个字符串不是同构字符串，返回false
                    return false;
                }
            } else {
                // 若集合map中不存在key值，判断是否可以保存进集合map中
                if (!map.containsValue(b)) {
                    // 若集合map中不存在value值，那么映射关系是唯一的，保存进集合map中
                    map.put(a, b);
                } else {
                    // 若集合map中存在value值，因为不同字符不能映射到同一个字符上，所以两个字符串不是同构字符串，返回false
                    return false;
                }
            }
        }

        // 若能顺利遍历完，那么两个字符串是同构字符串
        return true;
    }

}
