package org.pure.algorithm.bulbSwitcher;

//import java.util.Arrays;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-15 22:35
 * @description 灯泡开关
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = bulbSwitch(n);
        System.out.println(result);

        // 这道题属于脑筋急转弯，运行方法1时发现超时，那么肯定是要使用数学法，首先要想到找规律，比如列出前100项的值，从中找规律
        // 由于此题一一列出前几项的值需要耗费很多时间，所以可以通过程序代码运行方法1打印出前100项的值，通过打印结果可以一目了然地发现规律
//        for (int i = 0; i <= 100; ++i) {
//            System.out.println(i + ":" + bulbSwitch(i));
//        }
    }

//    // 方法1，模拟法，直接暴力，超时，不推荐
//    private static int bulbSwitch(int n) {
//        // 模拟法，直接暴力，超时，不推荐
//
//        // 定义亮着的灯泡数量
//        int lightNum = 0;
//
//        // 定义灯泡数组，用布尔数组表示，true表示打开，false表示关闭
//        boolean[] bulbs = new boolean[n];
//
//        // 遍历轮数，从1到n
//        for (int i = 1; i <= n; ++i) {
//            if (i == 1) {
//                // 若是第一轮，全部灯泡变为打开
//                Arrays.fill(bulbs, true);
//                // 亮着的灯泡数量就是布尔数组的长度
//                lightNum = bulbs.length;
//            } else if (i == 2) {
//                // 若是第二轮，每两个灯泡关闭一个，即每两个元素等于false
//                for (int j = i - 1; j < bulbs.length; j += i) {
//                    bulbs[j] = false;
//                    --lightNum;
//                }
//            } else {
//                // 若是第i轮，每i个灯泡切换一个，即每i个元素等于这个元素的否定
//                for (int j = i - 1; j < bulbs.length; j += i) {
//                    bulbs[j] = !bulbs[j];
//                    if (bulbs[j]) {
//                        ++lightNum;
//                    } else {
//                        --lightNum;
//                    }
//                }
//            }
//        }
//
//        // 返回亮着的灯泡数量
//        return lightNum;
//    }

    // 方法2，数学法，找规律，推荐
    private static int bulbSwitch(int n) {
        // 数学法，找规律

        // 通过找规律发现，刚好等于n的开方向下取整
        return (int) Math.sqrt(n);
    }

}
