package org.pure.algorithm.moveZeroes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-27 22:20
 * @description 移动零
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
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        // 定义非0数字索引
        int j = 0;

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                // 对非0数字进行操作
                if (i > j) {
                    // 若非0数字在0数字的后面，此元素才和0数字进行交换
                    nums[j] = nums[i];
                    nums[i] = 0;
                }

                // 非0数字索引加1
                ++j;
            }
        }
    }

}
