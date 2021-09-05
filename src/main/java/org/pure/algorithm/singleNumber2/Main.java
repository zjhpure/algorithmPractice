package org.pure.algorithm.singleNumber2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-05 22:33
 * @description 只出现一次的数字II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = singleNumber(nums);
        System.out.println(result);
    }

    private static int singleNumber(int[] nums) {
        // 定义集合map，保存每个整数出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历整数数组nums
        for (int num : nums) {
            // 整数作为集合map的key，次数作为集合map的value，初始value是0，每次找到相同key时value加1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 若找到集合中value为1的整数，返回整数
                return entry.getKey();
            }
        }

        return 0;
    }

}
