package org.pure.algorithm.allKindsOfSearch;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:18
 * @description 顺序查找
 */
public class OrderSearch {

    // 顺序查找的序列不需要是有序序列

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = orderSearch(arr, target);
        System.out.println(result);
    }

    // 顺序查找，无序查找，时间复杂度O(n)
    private static int orderSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; ++i) {
            if (target == arr[i]) {
                return i;
            }
        }

        return -1;
    }

}
