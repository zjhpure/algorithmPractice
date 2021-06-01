package org.pure.algorithm.powerOfThree;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-01 21:09
 * @description 3的幂
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isPowerOfThree(n);
        System.out.println(result);
    }

    private static boolean isPowerOfThree(int n) {
        if (n < 1) {
            // 3的幂必定大于等于1，若小于1，直接判定为不是
            return false;
        }

        // 若一个数是3的幂，必定是3的倍数，而且除以3后还是3的倍数，再除以3，直到最后为1，如果最后不是1，那么证明这个数虽然是3的倍数，但是不是所有因子都是3，所以不是3的幂
        while (n % 3 == 0) {
            n /= 3;
        }

        // 最后一步判断是否为1，若是1，则证明n是3的幂，若不是1，则证明n不是3的幂
        return n == 1;
    }

}
