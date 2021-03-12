package org.pure.algorithm.countConsistentStrings;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-12 23:14
 * @description 统计一致字符串的数目
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String allowed = scanner.nextLine();
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] words = new String[size];
        for (int i = 0; i < size; ++i) {
            words[i] = strings[i].split("\"")[1];
        }

        // 获取输出结果
        int result = countConsistentStrings(allowed, words);
        System.out.println(result);
    }

    private static int countConsistentStrings(String allowed, String[] words) {
        // 定义一致字符串数目
        int count = 0;

        // 遍历words字符串数组
        for (String word : words) {
            // 是否符合一致字符串条件
            boolean isConform = true;

            // 遍历word字符串的字符
            for (int j = 0; j < word.length(); ++j) {
                if (allowed.indexOf(word.charAt(j)) < 0) {
                    // 若有一个字符不在字符串allowed中，那么这个字符串就不是一致字符串
                    isConform = false;
                    break;
                }
            }

            if (isConform) {
                // 若符合一致字符串条件，一致字符串数目加1
                ++count;
            }
        }

        return count;
    }

}
