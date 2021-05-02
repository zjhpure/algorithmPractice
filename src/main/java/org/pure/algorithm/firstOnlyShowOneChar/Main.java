package org.pure.algorithm.firstOnlyShowOneChar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-02 21:31
 * @description 第一个只出现一次的字符
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        char result = firstUniqChar(str);
        System.out.println(result);
    }

    private static char firstUniqChar(String s) {
        // 定义有序集合map，保存每种字符出现的次数
        Map<Character, Integer> map = new LinkedHashMap<>();

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                // 如果字符在集合map中已存在，数量加1
                map.put(c, map.get(c) + 1);
            } else {
                // 如果字符在集合map中不存在，添加到集合map中，数量为1
                map.put(c, 1);
            }
        }

        // 遍历有序集合map
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 如果找到有字符出现的次数为1，那么此字符就是第一个只出现一次的字符
                return entry.getKey();
            }
        }

        // 如果没有找到有字符出现的次数为1，那么就是没有只出现一次的字符，返回单空格
        return ' ';
    }

}
