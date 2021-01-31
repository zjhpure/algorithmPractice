package org.pure.algorithm.implementStrstr;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-31 14:27
 * @description 实现strStr()
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.nextLine();
        String needle = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int rs = strStr(haystack, needle);
        System.out.println(rs);
    }

    private static int strStr(String haystack, String needle) {
        // 获取needle字符串长度
        int needleLength = needle.length();

        if (needleLength == 0) {
            // needle为空字符串时，返回0
            return 0;
        }

        // 定义返回索引
        int index = -1;

        // 定义是否需要判断字符
        boolean isJudge = false;

        // 定义对比字符时的当前索引
        int currentIndex = 0;

        // 是否相等
        boolean isEqual = false;

        // 遍历haystack字符串
        for (int i = 0; i < haystack.length(); ++i) {
            char c = haystack.charAt(i);

            if (isJudge) {
                // 若需要判断字符
                if (c == needle.charAt(currentIndex)) {
                    // 若字符串相等
                    if (currentIndex == needleLength - 1) {
                        // 若当前索引是needle字符串的最后一个索引，是否相等标识设为true，结束遍历
                        isEqual = true;

                        break;
                    } else {
                        // 当前索引加1
                        ++currentIndex;
                    }
                } else {
                    // 若字符串不相等
                    // 遍历索引回到开始判断字符时的索引
                    i = index;

                    // 返回索引设回原来的-1
                    index = -1;

                    // 判断标识设回原来的false
                    isJudge = false;

                    // 对比字符时的当前索引设回原来的0
                    currentIndex = 0;
                }
            } else {
                // 若不需要判断字符
                if (c == needle.charAt(0)) {
                    // 更新要返回的索引
                    index = i;

                    if (currentIndex == needleLength - 1) {
                        // 若当前索引是needle字符串的最后一个索引，是否相等标识设为true，结束遍历
                        isEqual = true;

                        break;
                    } else {
                        // 若字符等于needle的第1个字符，判断标识设为true
                        isJudge = true;

                        // 当前索引加1
                        ++currentIndex;
                    }
                }
            }
        }

        // 根据是否相等标识判断是否找到needle字符串
        if (isEqual) {
            // needle找到
            return index;
        } else {
            // needle没找到
            return -1;
        }
    }

}
