package org.pure.algorithm.detectCapital;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-21 21:12
 * @description 检测大写字母
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean rs = detectCapitalUse(str);
        System.out.println(rs);
    }

    private static boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            // 若字母只有一个，单词写法都是对的
            return true;
        } else {
            // 若字母大于一个，进行单词写法是否正确的判断

            // 是否判断小写字母
            boolean isJudgeLowercase = true;

            char c1 = word.charAt(0);
            char c2 = word.charAt(1);

            if (c1 >= 97 && c1 <= 122) {
                // 若第一个字母是小写字母
                if (c2 >= 97 && c2 <= 122) {
                    // 若第二个字母是小写字母，属于都是小写字母的情况，那么要判断后面的字母是否都是小写字母
                    isJudgeLowercase = true;
                } else {
                    // 若第二个字母是大写字母，属于不正确的情况
                    return false;
                }
            } else {
                // 若第一个字母是大写字母
                if (c2 >= 97 && c2 <= 122) {
                    // 若第二个字母是小写字母，属于首字母大写的情况，那么要判断后面的字母是否都是小写字母
                    isJudgeLowercase = true;
                } else {
                    // 若第二个字母是大写字母，属于都是大写字母的情况，判断后面的字母是否都是大写字母
                    isJudgeLowercase = false;
                }
            }

            // 遍历字符串word，从第二个字母开始遍历
            for (int i = 1; i < word.length(); ++i) {
                if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                    // 若是小写字母
                    if (!isJudgeLowercase) {
                        // 若不是判断小写字母，直接返回不正确
                        return false;
                    }
                } else {
                    // 若是大写字母
                    if (isJudgeLowercase) {
                        // 若是判断小写字母，直接返回不正确
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
