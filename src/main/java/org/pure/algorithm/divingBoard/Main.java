package org.pure.algorithm.divingBoard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-07 18:42
 * @description 跳水板
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String shorter = scanner.nextLine();
        String longer = scanner.nextLine();
        String k = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int[] result = divingBoard(Integer.parseInt(shorter), Integer.parseInt(longer), Integer.parseInt(k));
        System.out.println(Arrays.toString(result));
    }

    private static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            // 当k为0时，没有木板，没有可能的长度，返回空数组
            return new int[]{};
        }

        if (shorter == longer) {
            // 当shorter和longer相等时，只有一种可能的长度，shorter或longer乘以k就是可能的长度
            return new int[]{shorter * k};
        }

        // 定义长度数组nums，数量是k+1
        int[] nums = new int[k + 1];

        // 注意：这里的长度数组nums，需要从小到大排列

        // 长度数组nums的第一个长度是，全部木块都用shorter长度
        nums[0] = shorter * k;

        // 从1遍历到k-1，长度数组nums中间有k-2个元素，构造其中shorter和longer的分布情况
        for (int i = 1; i <= k - 1; ++i) {
            // 每个长度等于最小值加上n个longer-shorter的差，最小值时全部是shorter，每次把一个元素变为longer，最后把k-1个元素变为longer，刚好就得到除去最小值和最大值的所有长度，而且还是从小到大排列的，这里不用再一次考虑最大值减去n个longer-shorter的差的情况，因为这里得到的长度和最小值加上n个longer-shorter的差是一样的，只是顺序刚好颠倒过来
            nums[i] = nums[0] + (longer - shorter) * i;
        }

        // 长度数组nums的最后一个长度是，全部木块都用longer长度
        nums[k] = longer * k;

        // 最后返回长度数组nums
        return nums;
    }

}
