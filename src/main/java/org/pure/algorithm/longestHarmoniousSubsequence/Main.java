package org.pure.algorithm.longestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-20 17:57
 * @description 最长和谐子序列
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
        int result = findLHS(nums);
        System.out.println(result);
    }

    private static int findLHS(int[] nums) {
        // 哈希表法

        // 定义集合map，保存数组中每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，统计数组中每个数字出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 定义最长的和谐子序列的长度
        int maxLength = 0;

        // 遍历集合map中的key
        for (int key : map.keySet()) {
            // 寻找是否存在比当前key大1的key，因为和谐子序列是最大值和最小值的差正好是1
            if (map.containsKey(key + 1)) {
                // 当前和谐子序列的长度是key的次数和key+1的次数之和，因为子序列不一定连续，所以任意两个最大值和最小值都可以去构造出和谐子序列
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1));
            }
        }

        // 返回最长的和谐子序列的长度
        return maxLength;
    }

}
