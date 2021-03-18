package org.pure.algorithm.smallerNumCountThanCurrentNum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-18 22:21
 * @description 有多少小于当前数字的数字
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
        int[] results = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(results));
    }

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        // 定义结果数组results
        int[] results = new int[nums.length];

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            // 定义满足条件的数目
            int count = 0;

            // 二次遍历数组nums
            for (int j = 0; j < nums.length; ++j) {
                // 如果位置不同而且比当前元素小，那么满足条件
                if (j != i && nums[j] < nums[i]) {
                    ++count;
                }
            }

            // 把数目写进数组
            results[i] = count;
        }

        return results;
    }

}
