package org.pure.algorithm.permutationInString;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-14 23:29
 * @description 字符串的排列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean rs = checkInclusion(s1, s2);
        System.out.println(rs);
    }

    // 不知为何，此方法超出时间限制
    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() <= 0 && s2.length() <= 0) {
            // s1字符串和s2字符串都为空，返回false
            return false;
        }

        if (s1.length() <= 0) {
            // s1字符串为空，返回true
            return true;
        }

        if (s2.length() <= 0) {
            // s2字符串为空，返回false
            return false;
        }

        // 定义找到的s1字符串中字符的索引列表长度
        int indexSize = 0;

        // 先把s1字符串赋给s字符串
        String s = s1;

        // 开始判断的索引
        int startIndex = 0;

        // 遍历s2字符串的字符
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);

            // 获取字符在s字符串中的索引
            int index = s.indexOf(c);

            if (index > -1) {
                if (indexSize <= 0) {
                    // 若是第一次找到s字符串中的字符，赋值给开始判断的索引
                    startIndex = i;
                }

                // 若字符在s1字符串中找到，索引列表长度加1
                ++indexSize;

                // s字符串去掉这个索引的字符
                s = s.substring(0, index) + s.substring(index + 1);

                if (indexSize == s1.length()) {
                    // 若找到的索引列表长度和s1字符串长度一致，那么表明已在s2字符串中找到s1字符串的排列
                    return true;
                }
            } else {
                if (indexSize > 0 && i > startIndex + 1) {
                    // 若当前索引在开始判断的索引加1之后，循环重新回到上一次开始找到的索引处
                    i = startIndex;
                }

                // 若字符在s1字符串中不存在，重置索引列表长度
                indexSize = 0;

                // 重新把s1字符串赋给s字符串
                s = s1;
            }
        }

        return false;
    }

}
