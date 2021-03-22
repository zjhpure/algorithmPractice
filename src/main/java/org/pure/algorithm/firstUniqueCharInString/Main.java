package org.pure.algorithm.firstUniqueCharInString;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-22 20:41
 * @description 字符串中的第一个唯一字符
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int size = firstUniqChar(str);
        System.out.println(size);
    }

    private static int firstUniqChar(String s) {
        // 定义集合map，记录每种字符的数量，必须定义为LinkedHashMap，否则后面遍历map集合时顺序可能和添加时不同
        Map<Character, Integer> map = new LinkedHashMap<>();

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            // 获取字符
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                // 若字符在集合map中有出现，更新集合map中字符的数量
                map.put(c, map.get(c) + 1);
            } else {
                // 若字符在集合map中没出现，往集合map中推进字符，数量为1
                map.put(c, 1);
            }
        }

        // 遍历map集合
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 若字符的数量为1，这就是第一个唯一字符，返回此字符在字符串s中第一个位置的索引
                return s.indexOf(entry.getKey());
            }
        }

        // 若没有字符的数量为1，就是没有唯一字符，返回-1
        return -1;
    }

}
