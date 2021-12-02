package org.pure.algorithm.relativeRanks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/2/21 9:52 PM
 * @description 相对名次
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
        String[] result = findRelativeRanks(nums);
        System.out.println(Arrays.toString(result));
    }

    private static String[] findRelativeRanks(int[] score) {
        // 排序法

        // 定义原数组，先保存一份score数组
        int[] original = new int[score.length];

        // 复制score数组给original数组，避免后面对score数组排序后无法再使用数组原样
        System.arraycopy(score, 0, original, 0, score.length);

        // 对score数组升序排序
        Arrays.sort(score);

        // 定义集合，因为所有得分都互不相同，所以用集合保存数组中每个数字的下标
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历score数组，保存数组中数字的下标，注意score数组经过了升序，但是题目要的是降序，所以下标刚好是最大下标减去当前下标
        for (int i = 0; i < score.length; ++i) {
            map.put(score[i], score.length - 1 - i);
        }

        // 定义结果数组
        String[] result = new String[score.length];

        // 遍历原数组original
        for (int i = 0; i < original.length; ++i) {
            // 通过集合获取当前数字的下标
            int e = map.get(original[i]);

            // 下标为0，1，2的对应金牌、银牌、铜牌，其他的对应e+1的名次
            if (0 == e) {
                result[i] = "Gold Medal";
            } else if (1 == e) {
                result[i] = "Silver Medal";
            } else if (2 == e) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = (e + 1) + "";
            }
        }

        // 返回结果数组
        return result;
    }

}
