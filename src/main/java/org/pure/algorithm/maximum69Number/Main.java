package org.pure.algorithm.maximum69Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-12 07:55
 * @description 6和9组成的最大数字
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = maximum69Number(num);
        System.out.println(result);
    }

    private static int maximum69Number(int num) {
        // 定义列表list，保存所有可能的数字
        List<Integer> list = new ArrayList<>();

        // 列表list先添加整数num
        list.add(num);

        // 真实的尾部部分
        int trueTail = 0;

        // 翻转后的尾部部分
        int tail;

        // 幂
        int power = 1;

        // 循环获取位数的值
        while (num > 0) {
            // 整数num对10取余获取位数的值
            int res = num % 10;
            // 定义翻转后的值
            int replaceRes;
            // 获取翻转后的值，6变成9，9变成6
            if (res == 6) {
                replaceRes = 9;
            } else {
                replaceRes = 6;
            }
            // 先获取翻转后的尾部部分
            tail = trueTail + replaceRes * power;
            // 再获取真实的尾部部分
            trueTail += res * power;
            // 幂累乘
            power *= 10;
            // 整数num除以10减少一位
            num = num / 10;
            // 通过当前整数num*幂+翻转后的尾部部分得到翻转后的整数
            list.add((num * power) + tail);
        }

        // 初始化最大值
        int max = list.get(0);

        // 循环列表list，寻找出最大值
        for (int e : list) {
            if (e > max) {
                max = e;
            }
        }

        return max;
    }

}
