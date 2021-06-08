package org.pure.algorithm.determineIfStringHalvesAreAlike;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-08 21:45
 * @description 判断字符串的两半是否相似
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = halvesAreAlike(str);
        System.out.println(result);
    }

    private static boolean halvesAreAlike(String s) {
        // 定义前一半元音数量
        int preCount = 0;
        // 定义后一半元音数量
        int lastCount = 0;

        // 遍历字符串s的字符，使用双指针，从两边往中间遍历，因为字符串长度都是偶数，所以刚好会切分成两半
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (isContains(s.charAt(i))) {
                // 若包含元音，前一半元音数量加1
                ++preCount;
            }

            if (isContains(s.charAt(j))) {
                // 若包含元音，后一半元音数量加1
                ++lastCount;
            }
        }

        return preCount == lastCount;
    }

    // 判断是否包含元音
    private static boolean isContains(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }

        return false;
    }

}
