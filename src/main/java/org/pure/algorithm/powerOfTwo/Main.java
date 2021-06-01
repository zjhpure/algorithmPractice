package org.pure.algorithm.powerOfTwo;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-30 10:35
 * @description 2的幂
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isPowerOfTwo(n);
        System.out.println(result);

//        showAllTwoPower();
    }

    // 方法1：位运算计算出结果
    private static boolean isPowerOfTwo(int n) {
        // 2的幂肯定大于等于1，然后通过类似计算汉明距离的方法用&运算把n的最右边的1的位变成0，因为除了1其他2的幂都是只有1位是1，所以如果这个1变成了0，结果就会变成0，也就是&运算后等于0就是2的幂
        return n >= 1 && (n & (n - 1)) == 0;
    }

    // 方法2：循环得出结果
    private static boolean isPowerOfTwo2(int n) {
        if (n < 1) {
            // 2的幂必定大于等于1，若小于1，直接判定为不是
            return false;
        }

        // 若一个数是2的幂，必定是2的倍数，而且除以2后还是2的倍数，再除以2，直到最后为1，如果最后不是1，那么证明这个数虽然是2的倍数，但是不是所有因子都是2，所以不是2的幂
        while (n % 2 == 0) {
            n /= 2;
        }

        // 最后一步判断是否为1，若是1，则证明n是2的幂，若不是1，则证明n不是2的幂
        return n == 1;
    }

    // 方法3：暴力破解
    private static boolean isPowerOfTwo3(int n) {
        // 暴力破解所有
        switch (n) {
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256:
            case 512:
            case 1024:
            case 2048:
            case 4096:
            case 8192:
            case 16384:
            case 32768:
            case 65536:
            case 131072:
            case 262144:
            case 524288:
            case 1048576:
            case 2097152:
            case 4194304:
            case 8388608:
            case 16777216:
            case 33554432:
            case 67108864:
            case 134217728:
            case 268435456:
            case 536870912:
            case 1073741824:
                return true;
        }

        return false;
    }

    // 列举出所有整数的2的幂
    private static void showAllTwoPower() {
        int num = 1;

        for (int i = 0; i <= 30; ++i) {
            System.out.println("2的" + i + "次幂：" + num);
            num *= 2;
        }
    }

}
