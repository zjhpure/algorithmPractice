package org.pure.algorithm.leftRotateString;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-04 16:19
 * @description 左旋转字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = reverseLeftWords(s, n);
        System.out.println(result);
    }

    private static String reverseLeftWords(String s, int n) {
        // 切割字符串，先获取左旋字符串的右侧，再获取左旋字符串，两者相拼接得到结果
        return s.substring(n) + s.substring(0, n);
    }

}
