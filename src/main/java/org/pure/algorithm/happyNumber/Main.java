package org.pure.algorithm.happyNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-31 23:12
 * @description 快乐数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isHappy(n);
        System.out.println(result);
    }

    private static boolean isHappy(int n) {
        // 定义列表list保存平方和
        List<Integer> list = new ArrayList<>();

        // 若整数n不等于1或者列表list中没有找到整数n，继续循环计算下去
        // 分为2种情况
        // 第1，最终变回1
        // 第2，最终进入无限循环，即回到非1数字后不断循环再回到这个数字，但不会回到数字1
        // 注意：不会出现值越变越大最后无穷大的情况，因为999的平方和是243，9999的平方和是324，如果整数n为3位数，无论如何循环计算平方和，都不会超过3位数，而如果整数n一开始就大于3位数，那么在循环中计算平方和会越变越小，最后会变到3位数
        while (n != 1 && !list.contains(n)) {
            // 列表list添加n
            list.add(n);
            // 计算平方和更新整数n为下一个数字
            n = getSquareSum(n);
        }

        // 若最后整数n变回了1，那么就是快乐数
        return n == 1;
    }

    // 计算平方和
    private static int getSquareSum(int n) {
        // 定义和
        int total = 0;

        // 循环判断整数n是否大于0，若大于0，继续循环获取位置上的数字计算平方和
        while (n > 0) {
            // 取除以10得到的余数，即整数n的最后一位数字
            int rem = n % 10;
            // 计算平方和
            total += rem * rem;
            // 除以10让整数n去掉最后一位
            n = n / 10;
        }

        return total;
    }

}
