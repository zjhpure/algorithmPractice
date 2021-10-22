package org.pure.algorithm.majorityElement2;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-10-22 23:53
 * @description 求众数II
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
        List<Integer> result = majorityElement(nums);
        System.out.println(result);
    }

    private static List<Integer> majorityElement(int[] nums) {
        // 计算数组长度除以3
        int count = nums.length / 3;

        // 定义列表，保存数组中出现超过n/3次的元素
        List<Integer> list = new ArrayList<>();

        // 定义集合，保存数组中每种元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int num : nums) {
            // 更新此元素出现的次数
            int time = map.getOrDefault(num, 0) + 1;

            // 把此元素出现的次数更新到集合中
            map.put(num, time);
        }

        // 遍历集合，统计出现次数大于数组长度除以3的元素，添加元素到列表中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                list.add(entry.getKey());
            }
        }

        // 返回集合作为结果
        return list;
    }

}
