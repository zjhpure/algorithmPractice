package org.pure.algorithm.mostCommonWord;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-12 10:56
 * @description 最常见的单词
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String paragraph = scanner.nextLine();
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] strs = new String[size];
        for (int i = 0; i < size; ++i) {
            strs[i] = strings[i].split("\"")[1];
        }

        // 获取输出结果
        String result = mostCommonWord(paragraph, strs);
        System.out.println(result);
    }

    private static String mostCommonWord(String paragraph, String[] banned) {
        // 定义字符串集合sb，保存处理过特殊字符后的字符串paragraph，注意这里的字符串paragraph有可能逗号后面没有接空格，例如："a, a, a, a, b,b,b,c, c"，也能出现多个特殊字符连续的情况
        StringBuilder sb = new StringBuilder();

        // 遍历字符串paragraph的字符，构造一个分隔字符为空格的新paragraph字符串
        for (int i = 0; i < paragraph.length(); ++i) {
            char c = paragraph.charAt(i);

            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
                // 若字符是小写字母或大写字母，保存到字符串集合sb中
                sb.append(c);
            } else {
                // 若字符串不是小写字母和大写字母，根据情况判断是否保存空格到字符串集合sb中
                if (sb.length() > 0) {
                    // 获取当前字符串集合sb的最后一个字符
                    char ch = sb.charAt(sb.length() - 1);

                    if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
                        // 若当前字符串集合sb的最后一个字符是小写字母或大写字母，那么保存空格到字符串集合sb中，因为要构造一个分隔字符为空格的新paragraph字符串，不能保存连续多个空格，空格只能保存一个
                        sb.append(' ');
                    }
                }
            }
        }

        // 定义集合map，保存单词的个数
        Map<String, Integer> map = new HashMap<>();

        // 切割字符串集合sb，获得单词数组
        String[] strs = sb.toString().split(" ");

        // 遍历单词数组
        for (String str : strs) {
            boolean isFind = false;

            // 遍历禁用单词列表
            for (String b : banned) {
                // 因为单词不区分大小写，而禁用单词列表都是小写字母，所以都转化为小写字母再判断是否相等
                if (str.toLowerCase().equals(b)) {
                    // 若单词相等，那么在禁用单词列表中找到，结束循环
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {
                // 若单词在禁用单词列表中没有找到，保存单词和单词的个数到集合map中
                map.put(str.toLowerCase(), map.getOrDefault(str.toLowerCase(), 0) + 1);
            }
        }

        // 定义单词最大个数
        int maxNum = 0;
        // 定义最大个数单词
        String maxNumString = null;

        // 遍历集合map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxNum) {
                // 更新单词最大个数
                maxNum = entry.getValue();
                // 更新最大个数单词
                maxNumString = entry.getKey();
            }
        }

        // 最后返回最大个数单词
        return maxNumString;
    }

}
