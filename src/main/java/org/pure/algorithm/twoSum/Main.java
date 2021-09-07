package org.pure.algorithm.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-17 02:38
 * @description 两数之和
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int[] results = twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }

//    // 方法1，暴力法，时间复杂度O(n^2)，空间复杂度O(1)
//    private static int[] twoSum(int[] nums, int target) {
//        // 第一层轮询
//        for (int i = 0; i < nums.length; ++i) {
//            // 第二层轮询
//            for (int j = i + 1; j < nums.length; ++j) {
//                // 判断两数相加是否等于target
//                if (nums[i] + nums[j] == target) {
//                    // 返回数组中两个元素的下标
//                    return new int[]{i, j};
//                }
//            }
//        }
//
//        return new int[0];
//    }

    // 方法2，哈希表法，时间复杂度O(n)，空间复杂度O(n)
    private static int[] twoSum(int[] nums, int target) {
        // 定义集合，保存数组中每种整数的最新下标
        Map<Integer, Integer> map = new HashMap<>();

        // 一层轮询即可
        for (int i = 0; i < nums.length; ++i) {
            // 因为两数相加等于目标值，所以反过来目标值减去其中一个数就等于另一个数，利用集合的containsKey方法判断是否存在key值，containsKey方法是O(1)常数级别的时间复杂度的，如果发现存在，那么找到了答案
            if (map.containsKey(target - nums[i])) {
                // 从集合中找出key值对应的value值，就是对应值的数组下标，再加上当前数组下标，两个数组下标就是答案
                return new int[]{map.get(target - nums[i]), i};
            }

            // 把数组中当前下标的整数、当前下标保存到集合中
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
