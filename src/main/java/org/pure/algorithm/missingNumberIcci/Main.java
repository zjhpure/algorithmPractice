package org.pure.algorithm.missingNumberIcci;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-29 08:13
 * @description 消失的数字
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
        int result = missingNumber(nums);
        System.out.println(result);
    }

    private static int missingNumber(int[] nums) {
        // 数组nums的长度即为n
        int n = nums.length;
        // 计算从0到n的总和，总和=(首项+末项)*数量/2
        int sum = n * (n + 1) / 2;

        // 遍历数组nums
        for (int num : nums) {
            // 总和每次减去数组nums的元素
            sum -= num;
        }

        // 最后剩下的就是缺失的数字
        return sum;
    }

}
