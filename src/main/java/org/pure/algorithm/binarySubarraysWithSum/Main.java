package org.pure.algorithm.binarySubarraysWithSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-08 20:15
 * @description 和相同的二元子数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int goal = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = numSubarraysWithSum(nums, goal);
        System.out.println(result);
    }

    private static int numSubarraysWithSum(int[] nums, int goal) {
        // 定义集合map，保存前缀和的数量
        Map<Integer, Integer> map = new HashMap<>();

        // 定义二元子数组数量
        int count = 0;
        // 定义前缀和
        int sum = 0;

        // 遍历数组nums，统计到每一个元素的前缀和的数量，保存到集合map中，再统计二元子数组数量
        for (int num : nums) {
            // 若集合map中已存在前缀和，前缀和数量加1，否则前缀和数量设置为1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // 累加计算前n个元素的总和，得到前缀和
            sum += num;
            // 因为sum[j] - sum[i] = goal，也就是第j个元素的前缀和减去第i个元素的前缀和等于总和为goal的子数组总和，那么sum[j] - goal = sum[i]，sum[i]在集合map中的数量就是子数组总和为goal的数量，如果没有找到，二元子数组数量count就累加0。这里为何是先把没有累加元素之前的前缀和sum添加到集合map中，是因为前缀和从0算起的，当遍历到了最后一个元素时，倒数第二个元素的前缀和sum保存到集合map中，这时前缀和sum累加最后一个元素得到最后一个元素的前缀和，这时sum[j] - sum[i] = goal，goal是元素仅为最后一个元素的子数组总和，如果前缀和sum先累加了元素再添加到集合map中，那么遍历到最后一个元素时，把最后一个元素的前缀和也保存到集合map中了，根据前面的分析，集合map中多出了一份不正确的数据，会导致结果的出错
            count += map.getOrDefault(sum - goal, 0);
        }

        // 返回二元子数组数量
        return count;
    }

}
