package org.pure.algorithm.findNumsWithEvenNumOfDigits;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-17 21:57
 * @description 统计位数为偶数的数字
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
        int result = findNumbers(nums);
        System.out.println(result);
    }

    private static int findNumbers(int[] nums) {
        // 定义位数为偶数的数字个数
        int time = 0;

        // 遍历数组nums
        for (int num : nums) {
            // 定义位数
            int count = 0;

            // 计算数组元素的位数，通过循环除10直到0算出位数
            while (num > 0) {
                num = num / 10;
                ++count;
            }

            // 除2等于0的是偶数
            if (count % 2 == 0) {
                ++time;
            }
        }

        return time;
    }

}
