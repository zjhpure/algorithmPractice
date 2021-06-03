package org.pure.algorithm.majorityElement;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-03 22:47
 * @description 多数元素
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
        int result = majorityElement(nums);
        System.out.println(result);
    }

    private static int majorityElement(int[] nums) {
        if (nums.length <= 1) {
            // 若数组nums长度不大于1，那么多数元素就是数目nums的第一个元素
            return nums[0];
        }

        // 定义元素统计数量
        int count = 0;

        // 第一轮遍历数组nums，从第一个元素到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 每次把元素统计数量重新设置为1
            count = 1;

            // 第二轮遍历数组nums，从上一轮元素的下一个元素到倒数第一个元素
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == nums[i]) {
                    // 若两个元素相等，元素统计数量加1
                    ++count;

                    if (count > nums.length / 2) {
                        // 如果此元素在数组中出现次数大于n/2，那么找到多数元素
                        return nums[i];
                    }
                }
            }
        }

        return count;
    }

}
