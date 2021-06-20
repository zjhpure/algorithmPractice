package org.pure.algorithm.intReverse;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-18 02:11
 * @description 整数反转
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int num = reverse(x);
        System.out.println(num);
    }

    private static int reverse(int x) {
        int n = x;

        if (x < 0) {
            // 若是负数，乘以-1
            x = x * -1;
        }

        // 保存反转的整数
        int sum = 0;

        // 循环判断除以10是否为0，不断取x的最后位的数字
        while (x > 0) {
            // 通过取余，获得x最后位的数字
            int m = x % 10;

            // 反转整数暂时保存起来
            int temp = sum;

            // 乘以10加上余数，每次乘以10，每次都会扩大10倍，最后得到结果减去最末位，但是这里最后又加上了最末位m，因为x不断除以10得到的是反过来的数字，所以这里刚好就得到反转后的整数
            sum = sum * 10 + m;

            if (sum / 10 != temp) {
                // 通过和之前一个对比，可以判断是否溢出
                return 0;
            }

            // x除以10减去最右边的位
            x = x / 10;
        }

        if (n < 0) {
            // 若是负数，再乘回-1
            sum = sum * -1;
        }

        return sum;
    }

}
