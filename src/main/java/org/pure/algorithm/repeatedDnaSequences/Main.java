package org.pure.algorithm.repeatedDnaSequences;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-10-08 22:14
 * @description 重复的DNA序列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        List<String> result = findRepeatedDnaSequences(str);
        System.out.println(result);
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        // 定义列表，保存所有目标子串
        List<String> list = new ArrayList<>();

        // 定义集合，保存所有长度为10的子串的个数
        Map<String, Integer> map = new HashMap<>();

        // 遍历字符串s所有长度为10的子串的个数
        for (int i = 0; i <= s.length() - 10; ++i) {
            // 往后取10个字符，组成以i下标开头的长度为10的子串
            String sub = s.substring(i, i + 10);
            // 保存个数到集合中
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            // 若个数达到了2，那么就是目标子串了，保存到列表中(注意：这里不使用大于等于2去判断，因为目标子串只保存一个到列表中)
            if (map.get(sub) == 2) {
                list.add(sub);
            }
        }

        // 返回目标子串
        return list;
    }

}
