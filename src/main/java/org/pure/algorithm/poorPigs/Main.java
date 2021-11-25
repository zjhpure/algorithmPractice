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

    private static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 数学法

        int states = minutesToTest / minutesToDie + 1;

        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }

}
