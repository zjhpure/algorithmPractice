package org.pure.algorithm.longerContiguousSegmentsOfOnesThanZeros;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-29 20:36
 * @description 哪种连续子字符串更长
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = checkZeroOnes(str);
        System.out.println(result);
    }

    private static boolean checkZeroOnes(String s) {
        // 定义最长1的长度
        int maxOneLength = 0;
        // 定义最长0的长度
        int maxZeroLength = 0;

        // 定义当前1的长度
        int currentOneLength = 0;
        // 定义当前0的长度
        int currentZeroLength = 0;

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                // 若字符为1，先把当前0的长度设为0
                currentZeroLength = 0;

                if (i > 0 && s.charAt(i - 1) == '1') {
                    // 若不是第一个字符并且这个字符的前一个字符是1，那么连续子字符串1还在继续，所以当前1的长度加1
                    ++currentOneLength;
                } else {
                    // 若是第一个字符或者不是第一个字符但前一个字符不是1，那么连续子字符串1重新开始，所以当前1的长度设为1
                    currentOneLength = 1;
                }

                // 比较最长1的长度和当前1的长度，更新最长1的长度
                if (maxOneLength < currentOneLength) {
                    maxOneLength = currentOneLength;
                }
            } else {
                // 若字符为0，先把当前1的长度设为0
                currentOneLength = 0;

                if (i > 0 && s.charAt(i - 1) == '0') {
                    // 若不是第一个字符并且这个字符的前一个字符是0，那么连续子字符串0还在继续，所以当前1的长度加1
                    ++currentZeroLength;
                } else {
                    // 若是第一个字符或者不是第一个字符但前一个字符不是0，那么连续子字符串0重新开始，所以当前0的长度设为1
                    currentZeroLength = 1;
                }

                // 比较最长0的长度和当前0的长度，更新最长0的长度
                if (maxZeroLength < currentZeroLength) {
                    maxZeroLength = currentZeroLength;
                }
            }
        }

        // 若最长1的长度大于最长0的长度，返回true，否则返回false
        return maxOneLength > maxZeroLength;
    }
}
