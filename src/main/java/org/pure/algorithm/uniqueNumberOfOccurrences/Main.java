package org.pure.algorithm.uniqueNumberOfOccurrences;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-03-16 23:30
 * @description 独一无二的出现次数
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
        boolean result = uniqueOccurrences(nums);
        System.out.println(result);
    }

    private static boolean uniqueOccurrences(int[] arr) {
        // 定义map集合
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组arr
        for (int e : arr) {
            if (map.containsKey(e)) {
                // 若map集合中已有数组元素，元素出现次数加1
                int count = map.get(e);
                map.put(e, ++count);
            } else {
                // 若map集合中没有数组元素，推进map集合，元素出现次数为1
                map.put(e, 1);
            }
        }

        // 定义list列表，保存元素出现次数
        List<Integer> list = new ArrayList<>();

        // 遍历map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 获取元素出现次数
            int value = entry.getValue();

            if (list.contains(value)) {
                // 若有一个元素出现次数相同，那么次数就不是独一无二了
                return false;
            } else {
                // 若元素出现次数没有和其他元素出现次数相同，推进list列表
                list.add(value);
            }
        }

        // 若能遍历完map集合，则证明没有一个元素出现次数相同，次数是独一无二的
        return true;
    }

}
