package org.pure.algorithm.strIsUnique;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-19 00:17
 * @description 判定字符是否唯一
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = isUnique(str);
        System.out.println(result);
    }

    private static boolean isUnique(String astr) {
        // 第一次从第一个字符遍历到最后第二个字符
        for (int i = 0; i < astr.length() - 1; ++i) {
            // 第一次从第i+1个字符遍历到最后一个字符
            for (int j = i + 1; j < astr.length(); ++j) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    // 若有一对字符相同，那么所有字符不是全都不同
                    return false;
                }
            }
        }

        // 没有找到相同的，那么所有字符全都不同
        return true;
    }

}
