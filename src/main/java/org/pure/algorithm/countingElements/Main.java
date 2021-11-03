package org.pure.algorithm.countingElements;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhangjianhua
 * @date 2021-11-03 19:12
 * @description 数元素
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
        int result = countElements(nums);
        System.out.println(result);
    }

    private static int countElements(int[] arr) {
        // 哈希集合法

        // 定义数量
        int count = 0;

        // 定义哈希集合，保存不重复的数
        Set<Integer> set = new HashSet<>();

        // 第一次遍历数组，统计出不重复的数，保存到哈希集合中
        for (int e : arr) {
            set.add(e);
        }

        // 第二次遍历数组，判断每个数加1是否在哈希集合中，如果在，那么记为1个数，数量加1
        for (int e : arr) {
            if (set.contains(e + 1)) {
                ++count;
            }
        }

        // 返回数量
        return count;
    }

}
