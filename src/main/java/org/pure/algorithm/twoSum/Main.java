package org.pure.algorithm.twoSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-17 02:38
 * @description 两数之和
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int target = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int[] results = twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }

    private static int[] twoSum(int[] nums, int target) {
        // 第一遍轮询
        for (int i = 0; i < nums.length; ++i) {
            // 第二遍轮询
            for (int j = 0; j < nums.length; ++j) {
                // 判断两数相加是否等于target
                if (i != j && nums[i] + nums[j] == target) {
                    // 返回两个数组的下标
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
