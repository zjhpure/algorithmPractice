package org.pure.algorithm.signOfProductOfArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-20 07:39
 * @description 数组元素积的符号
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
        int result = arraySign(nums);
        System.out.println(result);
    }

    private static int arraySign(int[] nums) {
        // 定义乘积，只需判断正数或负数或0即可，无需算出乘积
        int product = 1;

        // 遍历数组nums
        for (int num : nums) {
            if (num == 0) {
                // 若有一个元素为0，那么乘积肯定是0，所以直接返回0
                return 0;
            } else if (num > 0) {
                // 若元素为正数，视为1，累乘
                product *= 1;
            } else {
                // 若元素为负数，视为-1，累乘
                product *= -1;
            }
        }

        return product;
    }

}
