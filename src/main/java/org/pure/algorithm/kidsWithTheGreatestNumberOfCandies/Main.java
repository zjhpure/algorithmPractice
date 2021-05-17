package org.pure.algorithm.kidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-17 08:09
 * @description 拥有最多糖果的孩子
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        List<Boolean> result = kidsWithCandies(nums, n);
        System.out.println(result);
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 定义列表list，保存每个孩子是否有最多糖果
        List<Boolean> list = new ArrayList<>();

        // 定义数组candies的最大值
        int max = 0;

        // 遍历数组candies，找出最大值
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }

        // 遍历数组candies，比较每个元素加上额外值后，是否大于等于最大值
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }

}
