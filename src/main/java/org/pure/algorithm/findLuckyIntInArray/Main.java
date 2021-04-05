package org.pure.algorithm.findLuckyIntInArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-05 13:25
 * @description 找出数组中的幸运数
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
        int result = findLucky(nums);
        System.out.println(result);
    }

    private static int findLucky(int[] arr) {
        // 定义集合map，保存每种数字的个数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组arr
        for (int e : arr) {
            if (map.containsKey(e)) {
                // 若集合map中已保存有这种数字，这种数字的个数加1
                map.put(e, map.get(e) + 1);
            } else {
                // 若集合map中无保存有这种数字，这种数字的个数设为1
                map.put(e, 1);
            }
        }

        // 定义最大幸运数
        int maxLucky = -1;

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 获取集合map中每个元素的key值
            int key = entry.getKey();

            // 若每个元素的key值和每个元素的value值相等，那么就是找到了幸运数
            if (key == entry.getValue()) {
                if (key > maxLucky) {
                    // 更新最大幸运数
                    maxLucky = key;
                }
            }
        }

        return maxLucky;
    }

}
