package org.pure.algorithm.xorOperationInAnArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-09 18:40
 * @description 数组异或操作
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int start = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int size = xorOperation(Integer.parseInt(n), start);
        System.out.println(size);
    }

    private static int xorOperation(int n, int start) {
        // 定义异或结果，初始值为数组nums的第一个元素，也就是start
        int result = start;

        // 从1到n-1遍历，计算异或结果
        for (int i = 1; i < n; ++i) {
            // 数组的元素等于start+2*i，拿到结果再进行异或操作
            result ^= start + 2 * i;
        }

        return result;
    }

}
