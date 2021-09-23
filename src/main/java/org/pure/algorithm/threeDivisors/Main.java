package org.pure.algorithm.threeDivisors;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-23 18:18
 * @description 三除数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isThree(n);
        System.out.println(result);
    }

    private static boolean isThree(int n) {
        // 定义除数个数
        int count = 0;

        // 从1遍历到n的开方
        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                // 若能除尽，那么符合除数条件
                if (n / i == i) {
                    // 若结果和除数相等，那么刚好是n的开方，除数只有一个，除数个数加1，比如49=7*7
                    ++count;
                } else {
                    // 若结果和除数不相等，那么结果落到大于n的开方那一侧，刚好是两个除数的组合，除数个数加2，比如10=2*5，当i=2时，对应5
                    count += 2;
                }
                if (count > 3) {
                    // 若除数大于了3个，个数超过，不符合条件，马上返回false
                    return false;
                }
            }
        }

        // 遍历结束后，判断除数个数是否恰好3个
        return count == 3;
    }

}
