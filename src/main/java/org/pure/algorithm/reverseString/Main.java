package org.pure.algorithm.reverseString;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-20 21:18
 * @description 反转字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] strs = new String[size];
        char[] s = new char[size];
        for (int i = 0; i < size; ++i) {
            strs[i] = strings[i].split("\"")[1];
            s[i] = strs[i].charAt(0);
        }

        // 获取输出结果
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    private static void reverseString(char[] s) {
        // 用双指针法，从左侧和右侧一起遍历，当左侧的索引大于等于右侧的索引时，停止遍历
        for (int left = 0, right = s.length - 1; left < right; ++left, --right) {
            // 交换两者的值
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
        }
    }

}
