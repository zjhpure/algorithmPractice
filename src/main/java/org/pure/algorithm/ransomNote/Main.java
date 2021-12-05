package org.pure.algorithm.ransomNote;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/5/21 9:33 PM
 * @description 赎金信
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String ransomNote = scanner.nextLine();
        String magazine = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean result = canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        // 计数统计

        // 若赎金信字符串的长度和杂志字符串的长度不等，直接不符合条件，返回false
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 定义数组，长度为26，保存字符串中每一个字符的数量
        int[] cnt = new int[26];

        // 遍历杂志字符串的字符，统计每一个字符的数量，使用计数统计的方法
        for (char c : magazine.toCharArray()) {
            ++cnt[c - 'a'];
        }

        // 遍历赎金信字符串的字符，同样使用计数统计的方法，但是数量递减
        for (char c : ransomNote.toCharArray()) {
            --cnt[c - 'a'];

            if (cnt[c - 'a'] < 0) {
                // 若数量出现了小于0的，证明赎金信字符串的这个字符数量大于杂志社字符串的这个字符数量，不符合条件，返回false
                return false;
            }
        }

        // 若程序能走到最后，证明赎金信字符串的每个字符数量都小于等于杂志社字符串的每个字符数量，符合条件，返回true
        return true;
    }

}
