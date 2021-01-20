package org.pure.algorithm.longestCommonPre;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-20 21:19
 * @description 最长公共前缀
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
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    private static String longestCommonPrefix(String[] strs) {
        String result = "";

        if (strs.length > 0) {
            // 字符串数组长度大于0
            if (strs.length > 1) {
                // 字符串数组长度大于1，取出第一个字符串
                String start = strs[0];

                // 构建字符串集合
                StringBuilder sb = new StringBuilder();

                // 判断标识
                boolean isPre = true;

                for (int i = 0; i < start.length(); ++i) {
                    sb.append(start.charAt(i));

                    // 遍历第一个字符串之后的字符串
                    for (int j = 1; j < strs.length; ++j) {
                        // 判断字符串是否以sb开头
                        if (!strs[j].startsWith(sb.toString())) {
                            isPre = false;
                            break;
                        }
                    }

                    // 发现前缀匹配不上时，结束
                    if (!isPre) {
                        break;
                    }
                }

                if (isPre) {
                    // 全部通过，即第一个字符串的全部就是最长公共前缀
                    result = sb.toString();
                } else {
                    // 被中断，最长公共前缀是sb减去最后一个字符
                    result = sb.deleteCharAt(sb.length() - 1).toString();
                }
            } else {
                // 字符串数组长度为1，最长公共前缀就是第一个字符串
                result = strs[0];
            }
        }

        return result;
    }

}
