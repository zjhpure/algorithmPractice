package org.pure.algorithm.stringRepeatPermutation;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-23 22:53
 * @description 判定是否互为字符重排
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean result = checkPermutation(s1, s2);
        System.out.println(result);
    }

    private static boolean checkPermutation(String s1, String s2) {
        // 若两个字符串长度不相等，首先排除
        if (s1.length() != s2.length()) {
            return false;
        }

        // 遍历s1字符串的字符
        for (int i = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);

            // 获取字符在s2中的索引
            int index = s2.indexOf(c);

            if (index >= 0) {
                // 若s2中能找到s1中的字符，那么s2去掉找到字符，防止下次判断遇到字符存在但是数量不同的情况
                s2 = s2.substring(0, index) + s2.substring(index + 1);
            } else {
                // 若s2中不能找到s1中的字符，那么字符不能重排
                return false;
            }
        }

        return true;
    }

}
