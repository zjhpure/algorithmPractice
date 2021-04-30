package org.pure.algorithm.largestSubstringBetweenTwoEqualCharacters;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-30 08:13
 * @description 两个相同字符之间的最长子字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = maxLengthBetweenEqualCharacters(str);
        System.out.println(result);
    }

    private static int maxLengthBetweenEqualCharacters(String s) {
        // 定义最长子字符串长度
        int maxLength = -1;

        // 遍历字符串s的字符，从0到倒数第二个
        for (int i = 0; i < s.length() - 1; ++i) {
            // 遍历字符串s的字符，从i+1到最后一个
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果两次遍历找到的字符相等，那么就是找到了子字符串
                    if (j - i - 1 > maxLength) {
                        // 更新子字符串的最大长度
                        maxLength = j - i - 1;
                    }
                }
            }
        }

        return maxLength;
    }

}
