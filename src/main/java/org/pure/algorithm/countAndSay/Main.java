package org.pure.algorithm.countAndSay;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-15 21:19
 * @description 外观数列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = countAndSay(n);
        System.out.println(result);
    }

    private static String countAndSay(int n) {
        // 遍历生成，模拟过程生成结果

        // 定义生成的字符串，初始为"1"
        String str = "1";

        // 遍历生成，从2遍历到n
        for (int i = 2; i <= n; ++i) {
            // 构造字符串集合，记录每次遍历的结果
            StringBuilder sb = new StringBuilder();

            // 定义字符连续数量
            int count = 1;

            // 遍历当前字符串的字符，从头到尾
            for (int j = 0; j < str.length(); ++j) {
                if (j < str.length() - 1 && str.charAt(j + 1) == str.charAt(j)) {
                    // 若不是最后一个字符，并且当前字符和下一个字符串相等，那么字符连续数量加1
                    ++count;
                } else {
                    // 若当前字符没有下一个字符或者和下一个字符不相等，那么表示字符连续数量已是最大值，添加字符连续数量和字符到字符串集合中
                    sb.append(count);
                    sb.append(str.charAt(j));
                    // 字符连续数量重置为1
                    count = 1;
                }
            }

            // 得到当前n值对应的字符串，赋值回给生成的字符串
            str = sb.toString();
        }

        // 返回生成的字符串
        return str;
    }

}
