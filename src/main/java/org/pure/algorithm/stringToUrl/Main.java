package org.pure.algorithm.stringToUrl;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-26 23:03
 * @description URL化
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = Integer.parseInt(scanner.nextLine());
        scanner.close();

        // 获取输出结果
        String result = replaceSpaces(s, length);
        System.out.println(result);
    }

    private static String replaceSpaces(String S, int length) {
        // 注意处理空格多出的情况，先按照给出的长度切割出真实的字符串，再把空格替换成%20
        return S.substring(0, length).replace(" ", "%20");
    }

}
