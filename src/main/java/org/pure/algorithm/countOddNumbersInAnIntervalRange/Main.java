package org.pure.algorithm.countOddNumbersInAnIntervalRange;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-28 23:24
 * @description 在区间范围内统计奇数数目
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String low = scanner.nextLine();
        String high = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = countOdds(Integer.parseInt(low), Integer.parseInt(high));
        System.out.println(result);
    }

    private static int countOdds(int low, int high) {
        // 直接数学计算可以算出答案，举例四个，开区间和闭区间分别是奇数和偶数
        // 奇数和奇数：3 7 -- 3,5,7 -- (7-3)/2+1=3，需要加1
        // 偶数和奇数：2 7 -- 3,5,7 -- (7-2)/2+1=3，需要加1
        // 奇数和偶数：3 8 -- 3,5,7 -- (8-3)/2+1=3，需要加1
        // 偶数和偶数：2 8 -- 3,5,7 -- (8-2)/2=3，不需要加1

        // 统计区间内的奇数数目
        int count = (high - low) / 2;

        if (low % 2 == 1 || high % 2 == 1) {
            // 若开区间和闭区间有一个是奇数，那么奇数数目加1
            ++count;
        }

        // 若开区间和闭区间两个都是偶数，那么奇数数目是原来的数量

        // 返回奇数数目
        return count;
    }

}
