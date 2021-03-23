package org.pure.algorithm.toLowerCase;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-23 23:01
 * @description 转换成小写字母
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = toLowerCase(str);
        System.out.println(result);
    }

    private static String toLowerCase(String str) {
        // 定义字符数组，长度和字符串str一致
        char[] chars = new char[str.length()];

        // 遍历字符串str
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                // 若是大写字母，转成小写字母
                chars[i] = (char) (str.charAt(i) + 32);
            } else {
                // 若是小写字母，直接用
                chars[i] = str.charAt(i);
            }
        }

        return String.valueOf(chars);
    }

}
