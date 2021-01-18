package org.pure.algorithm.repeatNum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-19 00:07
 * @description 数组中重复的数字
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
        int result = findRepeatNumber(nums);
        System.out.println(result);
    }

    private static int findRepeatNumber(int[] nums) {
        // 构造数组，因为说明了长度为n的数组nums里的所有数字都在0~n-1范围，所以此数组不会越界
        int[] arrs = new int[nums.length];

        // 遍历数组nums
        for (int num : nums) {
            // 把nums数组的元素作为arrs的下标
            ++arrs[num];

            // 若arrs数组中此下标的值大于1，那么证明已经有重复的数了
            if (arrs[num] > 1) {
                return num;
            }
        }

        return 0;
    }

}
