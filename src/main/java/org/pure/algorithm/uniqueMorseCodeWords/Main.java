package org.pure.algorithm.uniqueMorseCodeWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-09 20:14
 * @description 唯一摩尔斯密码词
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] strs = new String[size];
        for (int i = 0; i < size; ++i) {
            strs[i] = strings[i].split("\"")[1];
        }

        // 获取输出结果
        int result = uniqueMorseRepresentations(strs);
        System.out.println(result);
    }

    private static int uniqueMorseRepresentations(String[] words) {
        // 定义摩尔斯密码表数组
        String[] morses = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        // 定义翻译出来的字符串列表
        List<String> list = new ArrayList<>();

        // 遍历字符串数组words
        for (String word : words) {
            // 定义字符串集合，保存翻译出来的字符串
            StringBuilder sb = new StringBuilder();

            // 遍历字符串中的字符
            for (int j = 0; j < word.length(); ++j) {
                // 根据摩尔斯密码表数组翻译字符成摩尔斯字符串
                sb.append(morses[word.charAt(j) - 97]);
            }

            if (!list.contains(sb.toString())) {
                // 若翻译出来的字符串列表中没有此字符串，才保存进列表
                list.add(sb.toString());
            }

        }

        // 翻译出来的字符串列表就是所有词不同单词翻译的数量
        return list.size();
    }

}
