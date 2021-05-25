package org.pure.algorithm.countingBits;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-25 08:24
 * @description 比特位计数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int[] result = countBits(num);
        System.out.println(Arrays.toString(result));
    }

    private static int[] countBits(int num) {
        // 定义数组arrays，长度为num加1，因为包括0
        int[] arrays = new int[num + 1];

        // 从0遍历到num
        for (int i = 0; i <= num; ++i) {
            // 定义二进制数为1的统计数目，初始为0
            int count = 0;

            // 先把数字赋给另外一个变量
            int n = i;

            // 通过逐位移动法，即布赖恩·克尼根算法，统计出这个数中比特位为1的数目
            while (n != 0) {
                // 每次循环统计数目加1
                ++count;

                // n-1后，第一个最右边的1会变为0，从这个位置之后的右边的都会变为0，而位与&运算是只有两个位都为1时，才会得到1，所以结果就是原来的n去掉最右边的1，每次去掉一个最右边的1，直到去掉完，最后变成0
                n = n & (n - 1);
            }

            arrays[i] = count;
        }

        return arrays;
    }

}
