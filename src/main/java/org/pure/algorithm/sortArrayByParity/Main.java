package org.pure.algorithm.sortArrayByParity;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-11 21:10
 * @description 按奇偶排序数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int[] result = sortArrayByParity(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortArrayByParity(int[] A) {
        // 定义数组B保存奇偶排序后的数组
        int[] B = new int[A.length];

        // 数组B偶数当前索引
        int evenIndex = 0;

        // 数组B奇数当前索引
        int oddIndex = A.length - 1;

        // 遍历数组A
        for (int value : A) {
            if (value % 2 == 0) {
                // 若是偶数，保存进数组B前面
                B[evenIndex] = value;
                // 数组B偶数当前索引加1
                ++evenIndex;
            } else {
                // 若是奇数，保存进数组B后面
                B[oddIndex] = value;
                // 数组B奇数当前索引减1
                --oddIndex;
            }
        }

        return B;
    }

}
