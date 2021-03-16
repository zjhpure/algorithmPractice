package org.pure.algorithm.sumOfUniquElements;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-15 23:02
 * @description 唯一元素的和
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
        int result = sumOfUnique(nums);
        System.out.println(result);
    }

    private static int sumOfUnique(int[] nums) {
        // 定义map集合
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组nums
        for (int num : nums) {
            if (map.containsKey(num)) {
                // 若map集合中已有数组元素，数目加1
                int count = map.get(num);
                map.put(num, ++count);
            } else {
                // 若map集合中没有数组元素，推进map集合
                map.put(num, 1);
            }
        }

        // 唯一元素总和
        int total = 0;

        // 遍历map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 若数组元素的数目为1，则为唯一元素，累加到总和里
                total += entry.getKey();
            }
        }

        return total;
    }

}
