package org.pure.algorithm.maximumProductSubarray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-12 21:18
 * @description 乘积最大子数组
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
        int result = maxProduct(nums);
        System.out.println(result);
    }

    private static int maxProduct(int[] nums) {
        // 暴力枚举法

        // 定义最大子数组的乘积，初始为最小整数，-2^31=-2147483648
        int maxProduct = -2147483648;

        // 遍历数组，从开头到结尾
        for (int i = 0; i < nums.length; ++i) {
            // 定义每次子数组的乘积，初始为当前元素自身
            int product = nums[i];

            // 先和最大子数组的乘积作比较，取其中的最大值，更新到最大子数组的乘积，因为单独一个元素也算子数组
            maxProduct = Math.max(maxProduct, product);

            // 第二层遍历数组，从第一层数组元素的下一个开始到数组结尾
            for (int j = i + 1; j < nums.length; ++j) {
                // 和数组后面紧挨的元素累乘，得到子数组的乘积
                product *= nums[j];

                // 再次和最大子数组的乘积作比较，取其中的最大值，更新到最大子数组的乘积
                maxProduct = Math.max(maxProduct, product);
            }
        }

        // 返回最大子数组的乘积
        return maxProduct;
    }

}
