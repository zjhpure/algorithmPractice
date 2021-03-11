package org.pure.algorithm.shuffleTheArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-11 23:03
 * @description 重新排列数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int[] results = shuffle(nums, n);
        System.out.println(Arrays.toString(results));
    }

    private static int[] shuffle(int[] nums, int n) {
        // 定义结果数组
        int[] results = new int[nums.length];

        // 遍历2n个元素的数组
        for (int i = 0; i < nums.length; ++i) {
            if (i < n) {
                // 数组前一半
                // 示例1前一半：0 1 2 对应0 2 4，所以是2倍
                results[i * 2] = nums[i];
            } else {
                // 数组后一半
                // 示例1后一半：3 4 5 对应1 3 5，所以先减去3等于前一半的值，再用前一半的推论乘以2，再加1
                results[(i - n) * 2 + 1] = nums[i];
            }
        }

        return results;
    }

}
