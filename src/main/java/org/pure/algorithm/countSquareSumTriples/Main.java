package org.pure.algorithm.countSquareSumTriples;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-29 11:10
 * @description 统计平方和三元组的数目
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = countTriples(n);
        System.out.println(result);
    }

    private static int countTriples(int n) {
        // 枚举法

        // 定义数目
        int count = 0;

        // 从1开始遍历到n，枚举a
        for (int a = 1; a <= n; ++a) {
            // 从1开始遍历到n，枚举b
            for (int b = 1; b <= n; ++b) {
                // 通过以下的判断，减少第三层for循环的判断，不需要再通过第三层的for循环来枚举c
                // 满足条件的肯定a不等于b，因为如果a等于b，a^2+b^2的开方肯定不是一个整数
                if (a != b) {
                    // 计算a^2+b^2的开方，对结果取整，假设是结果是c
                    int c = (int) (Math.sqrt(a * a + b * b));
                    // 判断结果c是否落在小于等于n的范围内，并且是否符合a^2+b^2=c^2
                    if (c <= n && a * a + b * b == c * c) {
                        count++;
                    }
                }
            }
        }

        // 返回数目
        return count;
    }

}
