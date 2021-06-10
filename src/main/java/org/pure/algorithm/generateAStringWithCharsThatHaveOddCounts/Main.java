package org.pure.algorithm.generateAStringWithCharsThatHaveOddCounts;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-10 21:40
 * @description 生成每种字符都是奇数个的字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = generateTheString(n);
        System.out.println(result);
    }

    private static String generateTheString(int n) {
        // 定义字符数组，长度为n
        char[] cs = new char[n];

        if (n % 2 == 0) {
            // 若n是偶数，即偶数个字符，生成两种奇数个的字符，由1个a字符和n-1个字符b组成
            cs[0] = 'a';
            for (int i = 1; i < n; ++i) {
                cs[i] = 'b';
            }
        } else {
            // 若n是奇数，即奇数个字符，只生成一种奇数个的字符，全部由字符a组成
            for (int i = 0; i < n; ++i) {
                cs[i] = 'a';
            }
        }

        // 字符数组转为字符串
        return String.valueOf(cs);
    }

}
