package org.pure.algorithm.missingNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-19 22:45
 * @description 丢失的数字
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
        // 定义列表list保存数组
        List<Integer> list = new ArrayList<>();

        // 遍历数组nums，把nums的元素保存进列表list
        for (int num : nums) {
            list.add(num);
        }

        // 遍历[0,n]范围的整数
        for (int i = 0; i <= nums.length; ++i) {
            if (!list.contains(i)) {
                // 若列表list中不包含此元素，那么这个就是丢失的数字
                return i;
            }
        }

        return 0;
    }

}
