package org.pure.algorithm.teemoAttacking;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-25 22:44
 * @description 提莫攻击
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
        int result = findPoisonedDuration(nums, n);
        System.out.println(result);
    }

    private static int findPoisonedDuration(int[] timeSeries, int duration) {
        // 初始中毒总时长
        int sum = 0;

        // 遍历攻击时间点序列，从第2个元素开始
        for (int i = 1; i < timeSeries.length; ++i) {
            // 如果当前时间点减去前一个时间点大于等于中毒持续时间duration，那么中毒结束后才会被再次攻击，所以中毒总时长累加中毒持续时间duration，注意：这里计算中毒持续时间时，时间点本身的那一秒也是算进去的
            // 如果当前时间点减去前一个时间点小于中毒持续时间duration，那么中毒还没有结束就被再次攻击，所以中毒总时长累加两个时间点之间的差
            sum += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }

        // 最后中毒总时长累加一个duration，因为前面遍历没有累加到最后一次提莫攻击之后的中毒持续时间，在这里补充累加上
        return sum + duration;
    }

}
