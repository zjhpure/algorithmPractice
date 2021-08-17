package org.pure.algorithm.degreeOfAnArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-15 16:51
 * @description 数组的度
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
        int result = findShortestSubArray(nums);
        System.out.println(result);
    }

    private static int findShortestSubArray(int[] nums) {
        // 定义集合map，保存数组nums每种元素的数量、头下标、尾下标，通过一个长度为3的数组保存元素的数量、头下标、尾下标
        Map<Integer, int[]> map = new HashMap<>();

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];

            if (map.containsKey(num)) {
                // 若集合map存在元素，更新元素的数量、尾下标
                int[] info = map.get(num);
                // 元素的数量加1
                info[0] += 1;
                // 元素的尾下标更新为当前下标
                info[2] = i;
                // 更新元素的信息到集合map中
                map.put(num, info);
            } else {
                // 若集合map不存在元素，保存元素的信息到集合map中，元素的数量为1，头下标为当前下标，尾下标也为当前下标
                map.put(num, new int[]{1, i, i});
            }
        }

        // 定义元素的最大数量，初始为0
        int maxCount = 0;
        // 定义元素的最短连续子数组的长度，初始为0
        int minLength = 0;

        // 遍历集合map
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            // 获取元素的信息
            int[] info = entry.getValue();

            // 获取当前元素的连续子数组的长度
            int length = info[2] - info[1] + 1;

            if (info[0] > maxCount) {
                // 若当前元素的数量大于元素的最大数量，那么更新元素的最大数量
                maxCount = info[0];
                // 更新最短连续子数组的长度
                minLength = length;
            } else if (info[0] == maxCount) {
                // 若当前元素的数量等于元素的最大数量，判断更新最短连续子数组的长度
                if (length < minLength) {
                    // 若当前元素的连续子数组的长度小于最短连续子数组的长度，那么更新最短连续子数组的长度
                    minLength = length;
                }
            }
        }

        // 返回元素的最短连续子数组的长度
        return minLength;
    }

}
