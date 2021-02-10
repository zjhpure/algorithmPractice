package org.pure.algorithm.containsDuplicate;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhangjianhua
 * @date 2021-02-10 21:53
 * @description 存在重复元素
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
        boolean rs = containsDuplicate(nums);
        System.out.println(rs);
    }

    private static boolean containsDuplicate(int[] nums) {
        // 定义集合保存不重复的元素
        // 这里有点奇怪，如果定义为List，提交到LeetCode会超时，可能List的contains方法比Set的contains方法要更耗时
        Set<Integer> set = new HashSet<>();

        // 遍历数组nums的元素
        for (int num : nums) {
            if (set.contains(num)) {
                // 若集合中能找到元素，则返回true
                return true;
            } else {
                // 若集合中不能找到元素，则添加到集合中
                set.add(num);
            }
        }

        // 若能遍历结果结束，则没有找到重复元素
        return false;
    }

}
