package org.pure.algorithm.checkIfWordEqualsSummationOfTwoWords;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-04 08:22
 * @description 检查某单词是否等于两单词之和
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean result = isSumEqual(str1, str2, str3);
        System.out.println(result);
    }

    private static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        // 定义10的n次幂，初始化为10的0次幂
        int e = 1;

        // 定义第一个字符串转换的整数
        int firstNum = 0;
        // 定义第二个字符串转换的整数
        int secondNum = 0;
        // 定义目标字符串转换的整数
        int targetNum = 0;

        // 遍历第一个字符串的字符，从尾到头遍历，每次都把得出的整数乘以10的n次幂，每进一位幂增加1
        for (int i = firstWord.length() - 1; i >= 0; --i) {
            firstNum += e * (firstWord.charAt(i) - 'a');
            e *= 10;
        }

        // 10的n次幂重置为10的0次幂
        e = 1;

        // 遍历第二个字符串的字符，从尾到头遍历，每次都把得出的整数乘以10的n次幂，每进一位幂增加1
        for (int i = secondWord.length() - 1; i >= 0; --i) {
            secondNum += e * (secondWord.charAt(i) - 'a');
            e *= 10;
        }

        // 10的n次幂重置为10的0次幂
        e = 1;

        // 遍历目标字符串的字符，从尾到头遍历，每次都把得出的整数乘以10的n次幂，每进一位幂增加1
        for (int i = targetWord.length() - 1; i >= 0; --i) {
            targetNum += e * (targetWord.charAt(i) - 'a');
            e *= 10;
        }

        // 最后判断第一个字符串转换的整数加第二个字符串转换的整数是否等于目标字符串转换的整数，若等于返回true，否则返回false
        return firstNum + secondNum == targetNum;
    }

}
