package org.pure.algorithm.jewelsAndStones;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-10 20:52
 * @description 宝石与石头
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String jewels = scanner.nextLine();
        String stones = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = numJewelsInStones(jewels, stones);
        System.out.println(result);
    }

    private static int numJewelsInStones(String jewels, String stones) {
        // 定义宝石数量
        int count = 0;

        // 遍历石头中的字符
        for (int i = 0; i < stones.length(); ++i) {
            if (jewels.indexOf(stones.charAt(i)) > -1) {
                // 若宝石字符串中找到石头字符，那么石头字符是宝石，宝石数量加1
                ++count;
            }
        }

        return count;
    }

}
