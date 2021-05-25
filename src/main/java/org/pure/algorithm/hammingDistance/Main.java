package org.pure.algorithm.hammingDistance;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-21 08:18
 * @description 汉明距离
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int size = hammingDistance(x, y);
        System.out.println(size);
    }

    private static int hammingDistance(int x, int y) {
        // 先对x和y进行异或操作，异或后如果同一个位的值不同，就会等于1，所以会获得表示汉明距离的二进制数，此数中所有1的位的数目就是汉明距离
        int xor = x ^ y;

        // 定义1的位的数目
        int num = 0;

        // 循环统计num的值，循环一次统计出一次1的位，但是这里循环次数是固定的，因为整数的位数固定
        while (xor != 0) {
            // 每次循环num的值加1
            ++num;

            // xor-1后，第一个最右边的1会变为0，从这个位置之后的右边的都会变为0，而位与&运算是只有两个位都为1时，才会得到1，所以结果就是原来的xor去掉最右边的1，每次去掉一个最右边的1，直到去掉完，最后变成0
            xor = xor & (xor - 1);
        }

        return num;
    }

//    private static int hammingDistance(int x, int y) {
//        // 先对x和y进行异或操作，异或后如果同一个位的值不同，就会等于1，所以会获得表示汉明距离的二进制数，此数中所有1的位的数目就是汉明距离，然后用bitCount方法统计这个数二进制位为1的数目
//        return Integer.bitCount(x ^ y);
//    }

}
