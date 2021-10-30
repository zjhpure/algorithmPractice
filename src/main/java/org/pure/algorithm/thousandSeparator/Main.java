package org.pure.algorithm.thousandSeparator;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-10-30 23:13
 * @description 千位分隔数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = thousandSeparator(n);
        System.out.println(result);
    }

    private static String thousandSeparator(int n) {
        // 模拟法

        // 若整数是0，直接返回0
        if (n == 0) {
            return "0";
        }

        // 定义栈，保存字符串结果，因为是通过不断对1000取余和除以1000得到结果的，所以结果是倒叙的，用栈保存
        Stack<String> stack = new Stack<>();

        // 循环，不断对1000取余和除以1000
        while (n > 0) {
            // 先对1000取余获取余数
            int rem = n % 1000;
            // 再除以1000缩小，直到变为0，结束循环
            n /= 1000;
            if (n > 0) {
                // 若还没有变为0，那么还不是最后一次，这里除了把处理后的余数推进栈，还要再把点分隔符推进栈
                if (rem >= 100) {
                    // 若余数是三位数，直接原样把余数推进栈
                    stack.push(rem + "");
                } else if (rem >= 10) {
                    // 若余数是两位数，那么余数前面补一个零再推进栈
                    stack.push("0" + rem + "");
                } else {
                    // 若余数是一位数，那么余数前面补两个零再推进栈
                    stack.push("00" + rem + "");
                }
                // 把点分隔符推进栈
                stack.push(".");
            } else {
                // 若变为了0，那么已经到了最后一次，这里就没有了点分隔符，直接把余数推进栈即可
                stack.push(rem + "");
            }
        }

        // 定义字符串集合，保存最后的结果
        StringBuilder sb = new StringBuilder();

        // 循环出栈，把栈里的数据转移到字符串集合中，刚好把原来倒叙的结果变成顺序的结果
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
