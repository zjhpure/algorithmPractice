package org.pure.algorithm.nRepeatedElementIn2nArray;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-28 13:10
 * @description 重复N次的元素
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
        int result = repeatedNTimes(nums);
        System.out.println(result);
    }

    private static int repeatedNTimes(int[] A) {
        // 定义集合map保存每个元素出现的次数
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // 遍历数组A
        for (int value : A) {
            if (map.containsKey(value)) {
                // 若集合map中已保存有元素，那么元素数量加1
                map.put(value, map.get(value) + 1);
            } else {
                // 若集合map中不保存有元素，那么元素数量为0
                map.put(value, 1);
            }
        }

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                // 若集合map中有元素的数量大于1，那么这个元素就是重复了N次的元素
                return entry.getKey();
            }
        }

        return 0;
    }

}
