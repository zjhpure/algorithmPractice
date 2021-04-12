package org.pure.algorithm.addDigits;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-13 07:42
 * @description 各位相加
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = addDigits(num);
        System.out.println(result);
    }

//    // 这是最好的方法，O(1)时间复杂度，直接通过计算得出结果，过程分析本人尚未搞懂，这里暂时没作说明
//    private static int addDigits(int num) {
//        return (num - 1) % 9 + 1;
//    }

    private static int addDigits(int num) {
        // 通过整数num除以10是否大于0判断整数num是否为一位数
        while (num / 10 > 0) {
            // 若整数num不是一位数，计算各位相加的和
            num = getPositionSum(num);
        }

        // 若是整数num是一位数，则返回整数num作为结果
        return num;
    }

    // 计算各位相加的和
    private static int getPositionSum(int num) {
        // 定义各位相加的和
        int sum = 0;

        while (num > 0) {
            // 通过整数num对10取余获取数位上的值
            int res = num % 10;
            // 累加数位上的值
            sum += res;
            // 整数num除以10减少一位
            num = num / 10;
        }

        return sum;
    }

}
