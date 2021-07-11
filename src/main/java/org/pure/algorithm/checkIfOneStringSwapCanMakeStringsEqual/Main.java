package org.pure.algorithm.checkIfOneStringSwapCanMakeStringsEqual;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-11 18:54
 * @description 仅执行一次字符串交换能否使两个字符串相等
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean result = areAlmostEqual(s1, s2);
        System.out.println(result);
    }

    private static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            // 若两个字符串相等，不用字符交换，直接返回true
            return true;
        }

        // 定义统计两个字符串同一下标字符不同的数量
        int count = 0;
        // 定义统计到的第一个字符的下标
        int m = -1;
        // 定义统计到的第二个字符的下标
        int n = -1;

        // 遍历字符串s1和s2的字符，题目已说明字符串s1和字符串s2的长度相等
        for (int i = 0; i < s1.length(); ++i) {
            // 比较两个字符串同一下标的字符是否相等
            if (s1.charAt(i) != s2.charAt(i)) {
                // 若两个字符串同一下标的字符相等，统计数量加1
                ++count;
                if (count == 1) {
                    // 若统计数量达到了1，第一个字符的下标为当前下标
                    m = i;
                } else if (count == 2) {
                    // 若统计数量达到了2，第二个字符的下标为当前下标
                    n = i;
                }
            }

            if (count > 2) {
                // 若统计数量大于2，肯定无法做到最多一次字符串交换就可以使两个字符串相等
                return false;
            }
        }

        // 最后先判断m和n是否都不等于-1了，如果还有等于-1的，那么统计数量小于2，返回false，如果m和n都不等于-1，那么刚好找到两个字符不同的下标m和n，在两个字符串中交叉下标对应的值是否相等，如果都相等，返回true，否则，返回false
        return m != -1 && n != -1 && s1.charAt(m) == s2.charAt(n) && s1.charAt(n) == s2.charAt(m);
    }

}
