package org.pure.algorithm.maximum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-10 21:41
 * @description 最大数值
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = maximum(Integer.parseInt(a), Integer.parseInt(b));
        System.out.println(result);
    }

    private static int maximum(int a, int b) {
        // 利用简单的数学知识即可，a和b的最大值 = (a + b + abs(a - b)) / 2
        // 当a > b时，(a + b + abs(a - b)) / 2 = (a + b + a - b) / 2 = 2a / 2 = a
        // 当b > a时，(a + b + abs(a - b)) / 2 = (a + b + b - a) / 2 = 2b / 2 = b
        long abs = Math.abs((long) a - (long) b);
        long sum = (long) a + (long) b + abs;
        return (int) (sum / 2);
    }

}
