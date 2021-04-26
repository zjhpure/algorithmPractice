package org.pure.algorithm.smallestRangeI;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-26 20:44
 * @description 最小差值I
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = smallestRangeI(nums, k);
        System.out.println(result);
    }

    private static int smallestRangeI(int[] A, int K) {
        // 定义最小值和最大值
        int min = A[0], max = A[0];

        // 遍历数组A，找到最小值和最大值
        for (int e : A) {
            if (e < min) {
                // 更新最小值
                min = e;
            }
            if (e > max) {
                // 更新最大值
                max = e;
            }
        }

        if (max - min <= K * 2) {
            // 若数组A的最大值和最小值的差值小于等于k的2倍，那么数组A的最小值和最大值一加一减小于等于k绝对值的某个数，总能使得数组A的最大值和最小值相等，所以数组B的最小差值为0
            return 0;
        } else {
            // 若数组A的最大值和最小值的差值大于k的2倍，那么数组A的最小值和最大值一加一减k就会得到数组B的最小差值
            return max - min - K * 2;
        }
    }
}
