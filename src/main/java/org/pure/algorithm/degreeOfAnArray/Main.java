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
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int[] info = map.get(num);
                info[0] += 1;
                info[2] = i;
                map.put(num, info);
            } else {
                map.put(num, new int[]{1, i, i});
            }
        }

        int maxCount = 0;
        int minLength = 0;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] info = entry.getValue();

            if (info[0] > maxCount) {
                maxCount = info[0];
                minLength = info[2] - info[1] + 1;
            } else if (info[0] == maxCount) {
                if (info[2] - info[1] + 1 < minLength) {
                    minLength = info[2] - info[1] + 1;
                }
            }
        }

        return minLength;
    }

}
