package org.pure.algorithm.contiguousArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-03 21:25
 * @description 连续数组
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
        int result = findMaxLength(nums);
        System.out.println(result);
    }

    private static int findMaxLength(int[] nums) {
        if (nums.length <= 1) {
            // 若数组nums的长度不大于1，只能是0或1，那么不存在同时含有0和1的子数组，返回0
            return 0;
        }

        // 定义列表list
        List<Integer> list = new ArrayList<>();

        // 定义当前0的数量
        int currentZeroNum;
        // 定义当前1的数量
        int currentOneNum;

        // 第一轮遍历数组nums的元素，从第一个元素到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 对第一个元素进行当前0、1的数量统计
            if (nums[i] == 1) {
                currentOneNum = 1;
                currentZeroNum = 0;
            } else {
                currentZeroNum = 1;
                currentOneNum = 0;
            }

            // 第二轮遍历数组nums的元素，从上一轮的下一个元素到倒数第一个元素
            for (int j = i + 1; j < nums.length; ++j) {
                // 统计当前0、1的数量
                if (nums[j] == 1) {
                    ++currentOneNum;
                } else {
                    ++currentZeroNum;
                }

                if (currentZeroNum == currentOneNum) {
                    // 若当前0的数量等于当前1的数量，则找到了符合条件的连续子数组，保存子数组长度到列表list中
                    list.add(j - i + 1);
                }
            }
        }

        // 定义最长连续子数组的长度
        int maxNum = 0;

        for (int num : list) {
            // 和所有符合条件的连续子数组长度对比，找出最大长度
            if (num > maxNum) {
                maxNum = num;
            }
        }

        return maxNum;
    }

}
