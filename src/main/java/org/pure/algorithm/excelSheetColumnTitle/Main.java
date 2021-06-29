package org.pure.algorithm.excelSheetColumnTitle;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-29 22:00
 * @description Excel表列名称
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int columnNumber = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = convertToTitle(columnNumber);
        System.out.println(result);
    }

    private static String convertToTitle(int columnNumber) {
        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 对列号columnNumber循环除以26，直到0
        while (columnNumber > 0) {
            // 先自减1，这一步很关键，因为如果不先自减1，遇到刚好除以26除得尽的数会出错，例如输入52，52对26取余是0，0加上字符A的ASCII还是字符A，但是输入52的结果是AZ，最后一位字符是字符Z，不是字符A
            --columnNumber;
            // 列号columnNumber对26取余，加上字符A的ASCII码，再整体转为字符char，得到倒数第n位的字符
            sb.append((char) (columnNumber % 26 + 'A'));
            // 列号columnNumber除以26
            columnNumber /= 26;
        }

        // 字符串集合sb反转后转为字符串，返回结果
        return sb.reverse().toString();
    }

}
