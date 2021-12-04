package org.pure.algorithm.poorPigs;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 11/25/21 12:51 PM
 * @description 可怜的小猪
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String buckets = scanner.nextLine();
        String minutesToDie = scanner.nextLine();
        String minutesToTest = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = poorPigs(Integer.parseInt(buckets), Integer.parseInt(minutesToDie), Integer.parseInt(minutesToTest));
        System.out.println(result);
    }

//    // 方法1
//    private static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
//        // 动态规划法，待理解原理
//
//        if (buckets == 1) {
//            // 若桶数是1，不需要猪，返回0
//            return 0;
//        }
//
//        // 定义二维数组，(桶数+1)**(桶数+1)
//        int[][] combinations = new int[buckets + 1][buckets + 1];
//
//        // 第一个为1
//        combinations[0][0] = 1;
//
//        // 定义迭代次数，等于冷却时间除以死亡时间
//        int iterations = minutesToTest / minutesToDie;
//
//        // 再定义二维数组，桶数*(迭代次数+1)
//        int[][] f = new int[buckets][iterations + 1];
//
//        // 从0遍历到桶数减1
//        for (int i = 0; i < buckets; ++i) {
//            f[i][0] = 1;
//        }
//
//        // 从0遍历到迭代次数
//        for (int j = 0; j <= iterations; ++j) {
//            f[0][j] = 1;
//        }
//
//        // 从1遍历到桶数减1，进行动态规划构造
//        for (int i = 1; i < buckets; ++i) {
//            combinations[i][0] = 1;
//            combinations[i][i] = 1;
//
//            for (int j = 1; j < i; ++j) {
//                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
//            }
//
//            for (int j = 1; j <= iterations; j++) {
//                for (int k = 0; k <= i; ++k) {
//                    f[i][j] += f[k][j - 1] * combinations[i][i - k];
//                }
//            }
//
//            // 若迭代次数大于等于桶数，那么返回当前下标
//            if (f[i][iterations] >= buckets) {
//                return i;
//            }
//        }
//
//        // 若没有找到符合条件的，返回0
//        return 0;
//    }

    // 方法2
    private static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 数学法，待理解原理

        int states = minutesToTest / minutesToDie + 1;

        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }

}
