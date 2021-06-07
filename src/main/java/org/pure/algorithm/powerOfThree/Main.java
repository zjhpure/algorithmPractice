package org.pure.algorithm.powerOfThree;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-01 21:09
 * @description 3的幂
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isPowerOfThree(n);
        System.out.println(result);

//        showAllThreePower();
    }

    // 方法1：循环判断出结果
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

    // 方法2：求余法
    private static boolean isPowerOfThree2(int n) {
        // 通过计算得出整数范围内3的幂的最大值为3^19，因为3^20得到的答案是负数，证明已开始溢出，所以19次幂是最大值了
        // 所以整数范围内的3的幂就是：3^0，3^1，3^2..3^19
        // 用最大3的幂对输入的n求余，如果输入的n是3的幂，求余会等于0；如果输入的n不是3的幂，求余不等于0；因为3是质数，3的幂只能分解成多个3或者1相乘，那么对于除数，想要除尽，只能是3的幂，否则肯定有余数
        return n >= 1 && 1162261467 % n == 0;
    }

    // 列举出所有整数的3的幂
    private static void showAllThreePower() {
        int num = 1;

        for (int i = 0; i <= 30; ++i) {
            System.out.println("3的" + i + "次幂：" + num);
            num *= 3;
        }
    }

}
