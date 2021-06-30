package org.pure.algorithm.excelSheetColumnNumber;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-30 21:30
 * @description Excel表列序号
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = titleToNumber(str);
        System.out.println(result);
    }

    private static int titleToNumber(String columnTitle) {
        // 26进制转10进制

        // 定义结果，初始为0
        int sum = 0;
        // 定义26的指数结果，初始为26^0=1
        int e = 1;

        // 遍历字符串columnTitle的字符，从尾到头
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            // 当前字符减去字符A加1，等于这个位上的数值，再乘上26的指数结果，等于这个位转换出的数值
            // 例如：AB = 2 ^ 26 ^ 0 + 1 ^ 26 ^ 1 = 28
            sum += (columnTitle.charAt(i) - 'A' + 1) * e;
            // 26的指数结果增加一次幂
            e *= 26;
        }

        // 最后返回结果
        return sum;
    }

}
