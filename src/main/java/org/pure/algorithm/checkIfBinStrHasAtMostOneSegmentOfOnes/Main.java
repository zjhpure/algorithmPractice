package org.pure.algorithm.checkIfBinStrHasAtMostOneSegmentOfOnes;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-24 22:11
 * @description 检查二进制字符串字段
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = checkOnesSegment(str);
        System.out.println(result);
    }

    private static boolean checkOnesSegment(String s) {
        // 这道题最重要的是要理解题目，不要读错题，最多包含一个由连续的'1'组成的子弹，注意最多、连续的字眼，在这里，一个1也是连续1

        // 从字符串s的第三个元素开始遍历，因为字符串s第一个元素是1，那么第二个元素无论是0还是1，都是符合连续1的，返回true
        for (int i = 2; i < s.length(); ++i) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                // 如果从第三个元素起，一旦出现这个元素为1而且前一个元素为0时，那么因为第一个元素是1，已经有一个连续1了，而这里又出现了一个连续1，那么就不符合最多包含一个连续1了，所以不符合条件，返回false
                return false;
            }
        }

        // 如果能遍历完，那么从第三个元素起，没有出现连续1，而第一个元素已经是一个连续1了，所以符合条件，返回true
        return true;
    }

}
