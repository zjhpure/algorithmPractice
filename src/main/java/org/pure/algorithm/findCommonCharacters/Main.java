package org.pure.algorithm.findCommonCharacters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-18 22:17
 * @description 查找常用字符
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
        for (int i = 0; i < size; ++i) {
            strs[i] = strings[i].split("\"")[1];
        }

        // 获取输出结果
        List<String> result = commonChars(strs);
        System.out.println(result);
    }

    private static List<String> commonChars(String[] A) {
        // 定义字符串列表list
        List<String> list = new ArrayList<>();

        // 遍历字符串数组A的第一个字符串的字符
        for (int i = 0; i < A[0].length(); ++i) {
            // 取第一个字符串的字符
            char c = A[0].charAt(i);
            // 定义是否在后面的字符串找到此字符的标志
            boolean isFind = true;

            // 遍历字符串数组A第二个字符串到最后一个字符串
            for (int j = 1; j < A.length; ++j) {
                if (A[j].indexOf(c) <= -1) {
                    // 如果字符串中没有包含字符，那么标志为没有找到，结束循环
                    isFind = false;
                    break;
                } else {
                    // 如果字符串中包含字符，那么就是找到了，找到后把找到的字符替换为空，因为有可能会出现重复字符
                    A[j] = A[j].replaceFirst(String.valueOf(c), "");
                }
            }

            if (isFind) {
                // 如果标志为找到，那么把找到的字符转为字符串保存到字符串列表list中
                list.add(String.valueOf(c));
            }
        }

        return list;
    }

}
