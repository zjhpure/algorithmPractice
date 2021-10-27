package org.pure.algorithm.hexspeak;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-10-27 21:17
 * @description 十六进制魔术数字
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = toHexspeak(str);
        System.out.println(result);
    }

    // 此方法错误，当num值大于整数范围时就会溢出，导致计算错误
    private static String toHexspeak(String num) {
        // 思路：字符串转为十进制数字，十进制数字转为十六进制魔术数字字符，结果是倒叙的，再把倒叙的十六进制魔术数字字符转为顺序的字符串

        // 定义十进制数字，初始为0
        int decimal = 0;
        // 定义十进制的位，初始为10^0=1
        int e = 1;

        // 字符串转为十进制
        for (int i = num.length() - 1; i >= 0; --i) {
            // 每次等于当前数字乘以十进制的位
            decimal += (num.charAt(i) - 48) * e;
            // 每次十进制的位扩大十倍
            e *= 10;
        }

        // 定义栈，保存十六进制魔术数字字符
        Stack<Character> stack = new Stack<>();

        // 定义十六进制中10-16的大写字母表示
        char[] capitalLetters = {'A', 'B', 'C', 'D', 'E', 'F'};

        // 使用取余法，十进制数字转为十六进制魔术数字字符，保存字符到栈中，结果是倒叙的
        while (decimal > 0) {
            // 每次取余
            int rem = decimal % 16;
            if (rem >= 10) {
                // 若余数在10-16之间，转为大写字母表示
                stack.push(capitalLetters[rem - 10]);
            } else if (rem == 0) {
                // 若余数是0，转为魔术数字O
                stack.push('O');
            } else if (rem == 1) {
                // 若余数是1，转为魔术数字I
                stack.push('I');
            } else {
                // 若出现其他余数，那么就不符合题目中只包含魔术数字的要求了，马上返回ERROR
                return "ERROR";
            }
            // 每次除以16缩小，直到变成0
            decimal /= 16;
        }

        // 定义字符串集合，保存十六进制魔术数字字符
        StringBuilder sb = new StringBuilder();

        // 把栈中的倒叙字符转移到字符串集合中
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 字符串集合转为字符串
        return sb.toString();
    }

}
