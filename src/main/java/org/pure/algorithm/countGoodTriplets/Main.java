package org.pure.algorithm.countGoodTriplets;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-20 22:32
 * @description 统计好三元组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = countGoodTriplets(arr, Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c));
        System.out.println(result);
    }

    private static int countGoodTriplets(int[] arr, int a, int b, int c) {
        // 定义好三元组数量
        int count = 0;

        // 枚举法，遍历三层数组arr
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                for (int k = j + 1; k < arr.length; ++k) {
                    // 判断是否满足好三元组的条件
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        // 若满足好三元组的条件，好三元组数量加1
                        ++count;
                    }
                }
            }
        }

        // 返回好三元组数量
        return count;
    }

}
