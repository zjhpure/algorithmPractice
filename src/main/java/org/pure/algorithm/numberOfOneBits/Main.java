package org.pure.algorithm.numberOfOneBits;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-22 15:49
 * @description 位1的个数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int result = hammingWeight(n);
        System.out.println(result);
    }

    private static int hammingWeight(int n) {
        // 定义1的位的数目
        int sum = 0;

        // 循环统计sum的值，循环一次统计出一次1的位，但是这里循环次数是固定的，因为整数的位数固定
        while (n != 0) {
            // 每次循环sum的值加1
            ++sum;

            // n-1后，第一个最右边的1会变为0，从这个位置之后的右边的都会变为0，而位与&运算是只有两个位都为1时，才会得到1，所以结果就是原来的n去掉最右边的1，每次去掉一个最右边的1，直到去掉完，最后变成0
            n = n & (n - 1);
        }

        return sum;
    }

}
