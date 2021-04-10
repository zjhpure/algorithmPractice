package org.pure.algorithm.selfDividingNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-10 18:05
 * @description 自除数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        List<Integer> results = selfDividingNumbers(left, right);
        System.out.println(results);
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        // 定义列表list，保存自除数列表
        List<Integer> list = new ArrayList<>();

        // 从left遍历到right
        for (int i = left; i <= right; ++i) {
            if (isSelfDividingNumber(i)) {
                // 若判断这个数是自除数，添加这个数到列表list
                list.add(i);
            }
        }

        // 返回列表list
        return list;
    }

    // 判断某个数是否是自除数
    private static boolean isSelfDividingNumber(int num) {
        int divideNum = num;

        while (num > 0) {
            // 通过对10取余，获取位数的数
            int res = num % 10;

            if (res == 0) {
                // 若位数的数有0，直接判断不是自除数
                return false;
            } else {
                // 若位数的数没有0，判断是否能除尽
                if (divideNum % res != 0) {
                    // 若不能除尽，直接判断不是自除数
                    return false;
                }
            }

            // 通过除10去掉数字最后一位
            num = num / 10;
        }

        return true;
    }

}
