package org.pure.algorithm.splitAStringInBalancedStrings;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-02 21:52
 * @description 分割平衡字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = balancedStringSplit(str);
        System.out.println(result);
    }

    private static int balancedStringSplit(String s) {
        // 定义最大数量
        int maxSum = 0;

        // 定义L字符数量
        int totalLeft = 0;
        // 定义R字符数量
        int totalRight = 0;

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if ('L' == s.charAt(i)) {
                // 若是L字符，L字符数量加1
                ++totalLeft;
            } else {
                // 若是R字符，R字符数量加1
                ++totalRight;
            }

            if (totalRight > 0 && totalLeft == totalRight) {
                // 若L字符数量和R字符数量都大于0，并且两者相等，那么找到了切割后的平衡字符串，最大数量加1
                ++maxSum;
                // 找到一个平衡字符串后，把L字符数量和R字符数量都重置为0，重新开始判断后面的平衡字符串
                totalLeft = 0;
                totalRight = 0;
            }
        }

        return maxSum;
    }

}
