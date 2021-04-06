package org.pure.algorithm.kthMissingPositiveNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-06 21:50
 * @description 第k个缺失的正整数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = findKthPositive(arr, k);
        System.out.println(result);
    }

    private static int findKthPositive(int[] arr, int k) {
        // 定义列表list
        List<Integer> list = new ArrayList<>();

        // 遍历数组arr，把数组的元素放进列表list中
        for (int e : arr) {
            list.add(e);
        }

        // 定义起始正整数
        int i = 0;
        // 定义起始缺失的正整数的数目
        int n = 0;

        // 从0开始循环下去，统计缺失的正整数的数目
        while (n < k) {
            // 每次加1
            ++i;

            // 判断正整数i是否在列表list中
            if (!list.contains(i)) {
                // 若正整数i不在列表list中，那么就是缺失的正整数，那么数目加1
                ++n;
            }
        }

        // 最后统计出第k个缺失的正整数
        return i;
    }

}
