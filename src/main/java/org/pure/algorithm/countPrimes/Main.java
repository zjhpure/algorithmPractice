package org.pure.algorithm.countPrimes;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-07 23:25
 * @description 计数质数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = countPrimes(n);
        System.out.println(result);
    }

//    // 方法1，运行超时，不要使用，直接枚举判断是否是质数
//    private static int countPrimes(int n) {
//        if (n < 3) {
//            // 若n小于3，结果为0
//            return 0;
//        } else {
//            // 质数数量
//            int num = 1;
//
//            // 从3开始循环判断，每次自增2，因为偶数不是质数，不用判断
//            for (int i = 3; i < n; i += 2) {
//                // 是否为质数
//                boolean isPrime = true;
//
//                // 从3循环到这个数的平方根
//                for (int j = 3; j * j <= i; j += 2) {
//                    if (i % j == 0) {
//                        // 若能被除尽，则不是质数
//                        isPrime = false;
//                        break;
//                    }
//                }
//
//                if (isPrime) {
//                    // 质数数量加1
//                    ++num;
//                }
//            }
//
//            return num;
//        }
//    }

    // 方法2，埃氏筛算法，不超时，不判断质数，直接判断合数
    private static int countPrimes(int n) {
        // 使用埃氏筛算法

        // 定义质数数量
        int count = 0;

        // 定义布尔数组，保存n之前每个数是否为质数，false表示质数，true表示合数
        boolean[] flag = new boolean[n];

        // 从2开始遍历到n-1
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                // 若i为0，找到质数，质数数量加1
                ++count;

                // 质数从2倍开始遍历到n倍，直到小于n，如果x是质数，那么2x，3x…一定不是质数，所以遍历到的都是合数，全部标记为true
                for (int j = i + i; j < n; j += i) {
                    flag[j] = true;
                }
            }
        }

        // 这里省去了对每一个数从2开始逐个判断是否整除来判断质数，直接标记合数，剩下的就是质数
        return count;
    }

}
