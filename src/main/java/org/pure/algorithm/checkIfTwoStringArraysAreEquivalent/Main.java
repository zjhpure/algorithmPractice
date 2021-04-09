package org.pure.algorithm.checkIfTwoStringArraysAreEquivalent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-09 23:05
 * @description 检查两个字符串数组是否相等
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings1 = str1.split("\\[")[1].split("]")[0].split(",");
        int size1 = strings1.length;
        String[] strs1 = new String[size1];
        for (int i = 0; i < size1; ++i) {
            strs1[i] = strings1[i].split("\"")[1];
        }

        // 处理输入结果
        String[] strings2 = str2.split("\\[")[1].split("]")[0].split(",");
        int size2 = strings2.length;
        String[] strs2 = new String[size2];
        for (int i = 0; i < size2; ++i) {
            strs2[i] = strings2[i].split("\"")[1];
        }

        // 获取输出结果
        boolean result = arrayStringsAreEqual(strs1, strs2);
        System.out.println(result);
    }

    private static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // 定义集合list，保存字符串
        List<Character> list = new ArrayList<>();

        // 遍历第一个字符串数组word1
        for (String s : word1) {
            // 遍历每一个字符串的字符
            for (int j = 0; j < s.length(); ++j) {
                // 添加字符到集合list中
                list.add(s.charAt(j));
            }
        }

        // 定义索引k
        int k = 0;

        // 遍历第二个字符串数组word2
        for (String s : word2) {
            // 遍历每一个字符串的字符
            for (int j = 0; j < s.length(); ++j) {
                if (k < list.size()) {
                    // 当索引k小于集合list的长度时，才开始进行判断，避免数组越界
                    if (list.get(k) != s.charAt(j)) {
                        // 若发现有一个字符不相等，那么两个数组的字符串就不相等了
                        return false;
                    }
                } else {
                    // 若索引k已大于集合list的长度，那么字符串数组word2的长度已经大于字符串数组word1的长度，两个数组的字符串肯定不会再相等
                    return false;
                }

                // 每一次索引k加1
                ++k;
            }
        }

        // 若是索引k和集合list的长度相等，那么两个数组的字符串相等
        return k == list.size();
    }

}
