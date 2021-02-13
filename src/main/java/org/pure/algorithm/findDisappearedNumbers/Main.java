package org.pure.algorithm.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-13 21:17
 * @description 找到所有数组中消失的数字
 */
@SuppressWarnings("unused")
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
        List<Integer> result = findDisappearedNumbers(nums);
//        List<Integer> result = findDisappearedNumbers2(nums);
        System.out.println(result);
    }

    // 方法1，负值标记法，建议使用
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        // 定义消失数字列表
        List<Integer> list = new ArrayList<>();

        // 负值标记法
        // 从0索引遍历到n-1索引，把nums数组中的值作为索引，把索引对应的nums数组值变为负数
        for (int i = 0; i < nums.length; ++i) {
            int index = nums[i];

            if (index > 0) {
                // 若值为正数，直接减1即可
                index = index - 1;
            } else {
                // 若值为负数，先变回正数再减1
                index = -index - 1;
            }

            if (nums[index] > 0) {
                // 把数组值变为负数
                nums[index] = -nums[index];
            }
        }

        // nums数组中不是负数的值，它的索引+1就是消失的数字
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    // 方法2，列表移除法，但超出时间限制，不建议使用
    private static List<Integer> findDisappearedNumbers2(int[] nums) {
        // 定义消失数字列表
        List<Integer> list = new ArrayList<>();

        // 先把1-n的数字保存进列表
        for (int i = 1; i <= nums.length; ++i) {
            list.add(i);
        }

        // 遍历数组nums
        for (int num : nums) {
            if (list.contains(num)) {
                // 若数字在list列表中，去掉
                list.remove(new Integer(num));
            }
        }

        return list;
    }

}
