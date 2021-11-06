package org.pure.algorithm.longestArithmeticSubsequenceOfGivenDifference;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-05 12:56
 * @description 最长定差子序列
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int difference = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = longestSubsequence(arr, difference);
        System.out.println(result);
    }

//    // 方法1，暴力法，但是时间超时，不推荐
//    private static int longestSubsequence(int[] arr, int difference) {
//        // 暴力法，双层遍历，时间超时
//
//        // 定义最大等差子序列长度
//        int maxCount = 0;
//
//        // 第一层遍历数组，从0到末尾
//        for (int i = 0; i < arr.length; ++i) {
//            // 定义等差子序列长度
//            int count = 1;
//
//            // 定义上一个数，初始为当前遍历到的元素
//            int last = arr[i];
//
//            // 第二层遍历数组，从下一个元素到末尾，计算等差子序列长度
//            for (int j = i + 1; j < arr.length; ++j) {
//                if (arr[j] - last == difference) {
//                    // 若第二层遍历到的元素和上一个数的差等于difference，那么符合条件，等差子序列长度加1
//                    ++count;
//                    // 上一个数更新为第二层遍历到的元素
//                    last = arr[j];
//                }
//            }
//
//            // 更新当前最大等差子序列长度
//            maxCount = Math.max(count, maxCount);
//        }
//
//        // 返回最大等差子序列长度
//        return maxCount;
//    }

    // 方法2，动态规划+哈希表法，推荐
    private static int longestSubsequence(int[] arr, int difference) {
        // 动态规划+哈希表法

        // 定义最长等差子序列的长度
        int maxCount = 0;

        // 定义集合，保存所有以数组中某个元素结束的等差子序列的长度
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，每次获取以当前元素结束的等差子序列的长度
        for (int e : arr) {
            // 当前元素作为集合的key，以当前元素结束的等差子序列的长度作为集合的value
            // 每次获取以当前元素结束的等差子序列的长度时，都从这个等差子序列的上一个元素时的长度加1得到
            map.put(e, map.getOrDefault(e - difference, 0) + 1);

            // 更新最长等差子序列的长度
            maxCount = Math.max(maxCount, map.get(e));
        }

        // 返回最长等差子序列的长度
        return maxCount;
    }

}
