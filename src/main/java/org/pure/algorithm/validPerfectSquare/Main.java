package org.pure.algorithm.validPerfectSquare;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-04 23:03
 * @description 有效的完全平方数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isPerfectSquare(num);
        System.out.println(result);
    }

    private static boolean isPerfectSquare(int num) {
        // 二分查找，注意溢出，测试判断平方时强转为long类型，避免溢出

        if (num == 1) {
            // 若是1，1是1的完全平方数，直接返回true
            return true;
        }

        // 定义左指针
        int left = 1;
        // 定义右指针，开方数一定小于等于一半，所以判断一半即可
        int right = num / 2;

        // 二分查找，从两侧往里查找
        while (left <= right) {
            // 定义中间指针，通过左指针加左右指针除以2的方式计算中间指针，而不是左指针加右指针再除以2，防止超过整数范围
            int mid = left + (right - left) / 2;

            // 计算中间指针的平方，判断是否等于整数num，注意强转为long，因为可能会超出整数范围，例如最大整数的一半的平方，肯定是超过整数范围的
            long square = (long) mid * mid;

            if (square == num) {
                // 若中间指针的平方等于整数num，那么是完全平方数，返回true
                return true;
            } else if (square < num) {
                // 若中间指针的平方小于整数num，那么往右侧区域继续寻找
                left = mid + 1;
            } else {
                // 若中间指针的平方大于整数num，那么往左侧区域继续寻找
                right = mid - 1;
            }
        }

        // 若二分查找结束后还没有匹配到完全平方数，即整数num不是完全平方数，返回false
        return false;
    }

}
