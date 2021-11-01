package org.pure.algorithm.distributeCandies;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhangjianhua
 * @date 2021-11-01 23:47
 * @description 分糖果
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
        int result = distributeCandies(nums);
        System.out.println(result);
    }

    private static int distributeCandies(int[] candyType) {
        // 贪心法

        // 定义哈希集合，保存糖果的种类
        Set<Integer> set = new HashSet<>();

        // 遍历数组，构造糖果的种类
        for (int candy : candyType) {
            // 哈希集合不会重复，每种糖果只有一个被保存到哈希集合
            set.add(candy);
        }

        // 因为数组是偶数，所以妹妹可以获得的最大糖果的种类数是数组长度除以2，假设哈希集合长度小于数组长度除以2，那么每种糖果只给一个妹妹，剩下的糖果无论怎么分配，妹妹获得的糖果种类数都是一样的，都是哈希集合的长度；假设哈希集合长度大于等于数组长度除以2，那么每种糖果先只给一个妹妹，直到妹妹被分到一半糖果，这时妹妹获得的糖果是每个都不同种类的，剩下的糖果虽然还有同种类的，但是无法再分给妹妹了，因为是平均分，妹妹最多获得数组长度除以2的糖果数量

        // 综上所述，当哈希集合长度小于数组长度除以2时，妹妹可以获得的最大糖果的种类数是哈希集合的长度；当哈希集合长度大于等于数组长度除以2时，妹妹可以获得的最大糖果的种类数是数组长度除以2；所以，结果就是哈希集合长度和数组长度除以2中的最小值
        return Math.min(set.size(), candyType.length / 2);
    }

}
