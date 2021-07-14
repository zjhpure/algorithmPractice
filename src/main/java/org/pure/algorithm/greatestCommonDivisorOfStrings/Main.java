package org.pure.algorithm.greatestCommonDivisorOfStrings;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-14 19:58
 * @description 字符串的最大公因子
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = gcdOfStrings(s, t);
        System.out.println(result);
    }

    private static String gcdOfStrings(String str1, String str2) {
        // 思路：答案肯定是某个字符串的前缀，如果要满足最大公因子的条件，前缀的长度必须同时是两个字符串str1和str2的长度的约数

        // 获取字符串str1的长度
        int length1 = str1.length();
        // 获取字符串str2的长度
        int length2 = str2.length();

        // 求出字符串str1和字符串str2的较小长度，从1遍历到较小长度
        for (int i = Math.min(length1, length2); i >= 1; --i) {
            // 判断前缀的长度是否同时是两个字符串str1和str2的长度的约数
            if (length1 % i == 0 && length2 % i == 0) {
                // 获取前缀，用其中的一个字符串切割即可，因为最大范围已经限定在了较小长度里
                String str = str1.substring(0, i);

                if (judgeCommon(str, str1) && judgeCommon(str, str2)) {
                    // 若前缀和字符串str1、前缀和字符串str2都满足因子关系，那么字符串str1和字符串str2拥有公因子str，因为前缀的长度是从大到小遍历的，所以这里一旦找到符合条件的前缀，即可以返回结果str
                    return str;
                }
            }
        }

        // 若不能找到符合条件的前缀，返回空字符串
        return "";
    }

    // 定义判断是否满足字符串因子的函数
    private static boolean judgeCommon(String t, String s) {
        // 因为字符串s等于多个字符串t相加，所以用字符串s的长度除以字符串t的长度，获取倍数length
        int length = s.length() / t.length();

        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 遍历倍数length次，每次字符串集合sb添加字符串t
        for (int i = 0; i < length; ++i) {
            sb.append(t);
        }

        // 最后若字符串集合sb刚好就等于字符串s，那么满足字符串t能除尽字符串s，即满足字符串t是字符串s的字符串因子的条件
        return s.equals(sb.toString());
    }

}
