package org.pure.algorithm.strobogrammaticNumber;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-02 23:17
 * @description 中心对称数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = isStrobogrammatic(str);
        System.out.println(result);
    }

    private static boolean isStrobogrammatic(String num) {
        // 双指针法

        // 这道题要注意理解题意，这里不是回文数，回文数是倒序和顺序一致，而这里是旋转180度，旋转180度后数字被移动到对称的下标处，只有0、1和8旋转180度后还是自身，6旋转180度是9，9旋转180度后是6，其他数字旋转180度后不是正确的数字，可直接判断为false

        // 遍历，双指针向中间靠拢，直到左指针大于右指针
        for (int i = 0, j = num.length() - 1; i <= j; ++i, --j) {
            // 获取左指针字符
            char c1 = num.charAt(i);
            // 获取右指针字符
            char c2 = num.charAt(j);

            if (isSymmetryChar(c1) && isSymmetryChar(c2)) {
                // 若两个字符都是对称数字，继续下一步的判断
                if (isEqualChar(c1) && isEqualChar(c2)) {
                    // 若两个字符都是对称相等的数字，那么字符就限定在了0、1、8
                    if (c1 != c2) {
                        // 若两个字符不相等，旋转180度后就不是中心对称数了，直接返回false
                        return false;
                    }
                } else {
                    // 若两个字符不都是对称相等的数字，那么字符可能都是6、9，或者一个字符是6、9，另一个字符是0、1、8
                    if (!((c1 == '6' && c2 == '9') || (c1 == '9' && c2 == '6'))) {
                        // 只有当一个字符是6，另一个字符是9时，才是符合条件的，否则肯定不是中心对称数，直接返回false
                        return false;
                    }
                }
            } else {
                // 若两个字符不都是对称数字，那么肯定不是中心对称数，直接返回false
                return false;
            }
        }

        // 若能遍历完，证明是中心对称数，返回true
        return true;
    }

    // 判断是否为对称数字，即可以旋转180度的数字，只有0、1、8、6、9旋转180度后还是正确的数字
    private static boolean isSymmetryChar(char c) {
        return c == '0' || c == '1' || c == '8' || c == '6' || c == '9';
    }

    // 判断是否为对称相等数字，即在旋转180度后相等的数字，只有0、1、8旋转180度后还相等
    private static boolean isEqualChar(char c) {
        return c == '0' || c == '1' || c == '8';
    }

}
