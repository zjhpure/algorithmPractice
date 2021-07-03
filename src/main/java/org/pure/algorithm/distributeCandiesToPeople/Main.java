package org.pure.algorithm.distributeCandiesToPeople;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-03 21:52
 * @description 分糖果II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String candies = scanner.nextLine();
        String num_people = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int[] result = distributeCandies(Integer.parseInt(candies), Integer.parseInt(num_people));
        System.out.println(Arrays.toString(result));
    }

    private static int[] distributeCandies(int candies, int num_people) {
        // 定义结果数组results
        int[] results = new int[num_people];

        // 定义结果数组索引
        int index = 0;
        // 定义每次要分糖果
        int n = 1;

        // 循环构造结果数组results，直到糖果candies小于等于0，结束循环
        while (candies > 0) {
            // 获取糖果减去每次要分的糖果
            int remaining = candies - n;

            if (remaining > 0) {
                // 若糖果够减，当前索引的结果数组元素累加每次要分的糖果
                results[index] += n;
                // 糖果更新为减去后的结果
                candies = remaining;
            } else {
                // 若糖果不够减，当前索引的结果数组元素累加剩下的糖果
                results[index] += candies;
                // 糖果设置为0
                candies = 0;
            }

            // 每次要分的糖果自增1
            ++n;

            // 结果数组索引往后移动一位，如果到了最后位置，重新回到刚开始位置
            index = index < num_people - 1 ? ++index : 0;
        }

        // 返回结果数组
        return results;
    }

}
