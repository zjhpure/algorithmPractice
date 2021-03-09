package org.pure.algorithm.numOfGoodPairs;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-09 22:33
 * @description 好数对的数目
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
        int result = numIdenticalPairs(nums);
        System.out.println(result);
    }

    private static int numIdenticalPairs(int[] nums) {
        // 定义好数对数目
        int count = 0;

        // 遍历数组nums到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 遍历第一轮遍历的结果之后的元素
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) {
                    // 如果两数相同，那么就是好数对
                    ++count;
                }
            }
        }

        return count;
    }

}
