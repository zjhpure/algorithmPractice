package org.pure.algorithm.powerOfFour;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-31 21:17
 * @description 4的幂
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        boolean result = isPowerOfFour(n);
        System.out.println(result);
    }

    private static boolean isPowerOfFour(int n) {
        // 2的幂肯定大于等于1，然后通过类似计算汉明距离的方法用&运算把n的最右边的1的位变成0，因为除了1其他2的幂都是只有1位是1，所以如果这个1变成了0，结果就会变成0，也就是&运算后等于0就是2的幂
        // 4的幂肯定是2的幂，先通过判断2的幂的方法判断出是2的幂，如果从右开始第1位为第0位，那么4的幂的1都在偶数位，所以只要判断n的偶数位是否为1即可，构造32位二进制数1010  1010  1010  1010  1010  1010  1010  1010，用n和它进行&运算，如果是4的幂，结果会为0，例如4的二进制为0100，那么n和它进行&运算，结果就是0，所以是4的幂，假如是2，那么它的二进制就是0010，那么n和它进行&运算，结果就是0010，不是0，2也不是4的幂，所以此方法可以用来判断4的幂。那么1010  1010  1010  1010  1010  1010  1010  1010，可以用16进制0xaaaaaaaa表示
        return n >= 1 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
