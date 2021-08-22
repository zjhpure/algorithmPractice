package org.pure.algorithm.reverseVowelsOfAString;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-23 01:01
 * @description 反转字符串中的元音字母
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = reverseVowels(str);
        System.out.println(result);
    }

    private static String reverseVowels(String s) {
        // 使用双指针法，从字符串两侧往里遍历字符，如果两边对应出现元音字母，那么反转赋值到字符数组中，否则直接赋值到字符数组中

        if (s.length() == 1) {
            // 当字符串长度为1时，直接返回字符串
            return s;
        }

        // 定义反转后的字符数组，长度为字符串s的长度
        char[] cs = new char[s.length()];

        // 定义左侧是否找到元音字母的标识
        boolean isLeft = false;
        // 定义右侧是否找到元音字母的标识
        boolean isRight = false;

        // 定义左指针，初始为0
        int left = 0;
        // 定义右指针，初始为字符串s的最后下标
        int right = s.length() - 1;

        // 循环，当左指针大于等于右指针时，结束循环
        while (left < right) {
            if (isVowels(s.charAt(left))) {
                // 若左指针下标的字符是元音字母，标识标为true
                isLeft = true;
                if (isRight || left >= right) {
                    // 若右指针的标识也是true或者左指针等于右指针，那么右指针下标的字符赋值到字符数组的左指针下标的位置，左指针下标的字符赋值到字符数组的右指针下标的位置
                    cs[left] = s.charAt(right);
                    cs[right] = s.charAt(left);
                }
            } else {
                // 若左指针下标的字符不是元音字母，标识标为false，字符直接赋值给字符数组，左指针加1
                isLeft = false;
                cs[left] = s.charAt(left);
                ++left;
            }

            if (isVowels(s.charAt(right))) {
                // 若右指针下标的字符是元音字母，标识标为true
                isRight = true;
                if (isLeft || left >= right) {
                    // 若左指针的标识也是true或者左指针等于右指针，左指针下标的字符赋值到字符数组的右指针下标的位置，那么右指针下标的字符赋值到字符数组的左指针下标的位置
                    cs[right] = s.charAt(left);
                    cs[left] = s.charAt(right);
                }
            } else {
                // 若右指针下标的字符不是元音字母，标识标为false，字符直接赋值给字符数组，右指针减1
                isRight = false;
                cs[right] = s.charAt(right);
                --right;
            }

            // 重复判断一次左指针下标的字符是否是元音字母，因为可能是右指针下标的字符为元音字母，如果右指针下标的字符是元音字母，但是左指针下标的字符是否是元音字母的判断在前面，程序无法往回运行，所以这里再判断一次左指针下标的字符是否是元音字母
            if (isVowels(s.charAt(left))) {
                // 若左指针下标的字符是元音字母，标识标为true
                isLeft = true;
                if (isRight || left >= right) {
                    // 若右指针的标识也是true或者左指针等于右指针，那么右指针下标的字符赋值到字符数组的左指针下标的位置，左指针下标的字符赋值到字符数组的右指针下标的位置
                    cs[left] = s.charAt(right);
                    cs[right] = s.charAt(left);
                }
            }

            if (isLeft && isRight) {
                // 若左指针和右指针的标识都为true，那么左指针和右指针的标识重置为false，同时左指针加1，右指针减1
                isLeft = false;
                isRight = false;
                ++left;
                --right;
            }

            if (left == right) {
                // 若左指针等于右指针，那么当前字符数组的下标进行一次直接赋值，因为如果当前下标的字母是元音字母而且只剩下一个时，如果不进行一次直接赋值，循环就结束了，这个下标的字符就会变成空值
                cs[left] = s.charAt(left);
            }
        }

        // 最后把字符数组转为字符串，返回结果
        return new String(cs);
    }

    // 判断当前字符是否为元音字母
    private static boolean isVowels(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c;
    }

}
