package org.pure.algorithm.arrayPartition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-07 19:19
 * @description 数组拆分I
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
        int result = arrayPairSum(nums);
        System.out.println(result);
    }

    private static int arrayPairSum(int[] nums) {
        // 排序数组nums
        Arrays.sort(nums);

        // 定义总和
        int sum = 0;

        // 遍历排序后的数组nums，隔一个遍历，0-2-4...，最优分对是数组从小到大排序，按顺序每两个作为一对
        for (int i = 0; i < nums.length; i += 2) {
            // 每次取两个中的第一个元素，也就是每次取每对的最小值
            sum += nums[i];
        }

        // 返回总和
        return sum;
    }

}
