package org.pure.algorithm.fizzBuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-13 20:39
 * @description Fizz Buzz
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        List<String> result = fizzBuzz(n);
        System.out.println(result);
    }

    private static List<String> fizzBuzz(int n) {
        // 直接模拟

        // 定义列表，保存结果
        List<String> list = new ArrayList<>();

        // 直接遍历构造构造列表即可
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                // 同时是3和5的倍数
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // 3的倍数
                list.add("Fizz");
            } else if (i % 5 == 0) {
                // 5的倍数
                list.add("Buzz");
            } else {
                // 3和5的倍数都不是
                list.add(i + "");
            }
        }

        // 返回列表结果
        return list;
    }

}
