package org.pure.algorithm.maximumProductOfWordLengths;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-17 18:53
 * @description 最大单词长度乘积
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
        int result = maxProduct(strs);
        System.out.println(result);
    }

    private static int maxProduct(String[] words) {
        // 模拟法

        // 定义最大值
        int maxCount = 0;

        // 遍历字符串数组
        for (int i = 0; i < words.length; ++i) {
            // 获取字符串
            String word = words[i];

            // 再次遍历字符串数组，获取下一个字符串
            for (int j = i + 1; j < words.length; ++j) {
                // 获取下一个字符串
                String str = words[j];

                // 定义是否合法标识，判断两个单词是否不含有公共字母
                boolean isValid = true;

                // 遍历下一个字符串中的所有字符
                for (int k = 0; k < str.length(); ++k) {
                    if (word.indexOf(str.charAt(k)) > -1) {
                        // 若下一个字符串中的所有字符有一个在字符串中能找到，那么这两个单词含有公共字母
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    // 若两个单词不含有公共字母，计算两个单词的长度乘积，和最大值比较，取最大值
                    maxCount = Math.max(maxCount, word.length() * words[j].length());
                }
            }
        }

        // 返回最大值
        return maxCount;
    }

}
