package org.pure.algorithm.keyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-31 19:30
 * @description 键盘行
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
        String[] result = findWords(strs);
        System.out.println(Arrays.toString(result));
    }

    private static String[] findWords(String[] words) {
        // 模拟法

        // 定义列表，保存符合条件的字符串
        List<String> list = new ArrayList<>();

        // 遍历字符串数组
        for (String word : words) {
            // 把字符串转为小写
            String lowerWord = word.toLowerCase();

            // 定义字符串所在的行数，获取字符串第一个字符所在的行数
            int currentRow = getRow(lowerWord.charAt(0));

            // 循环，遍历字符串中的字符，从第二个到最后一个
            for (int i = 1; i < lowerWord.length(); ++i) {
                // 获取字符串中字符所在的行数
                if (currentRow != getRow(lowerWord.charAt(i))) {
                    // 若字符串中字符所在的行数和字符串第一个字符所在的行数不同，那么字符串中的字符不在同一行，字符串所在的行数标记为-1，结束循环
                    currentRow = -1;
                    break;
                }
            }

            if (currentRow != -1) {
                // 若字符串所在的行数不被标记为-1，那么字符串中的字符在同一行，符合条件，把此字符串推进列表中
                list.add(word);
            }
        }

        // 把列表转为字符串数组
        return list.toArray(new String[0]);
    }

    // 获取字符所在的行数
    private static int getRow(char c) {
        if ("qwertyuiop".indexOf(c) >= 0) {
            // 第一行
            return 0;
        }

        if ("asdfghjkl".indexOf(c) >= 0) {
            // 第二行
            return 1;
        }

        if ("zxcvbnm".indexOf(c) >= 0) {
            // 第三行
            return 2;
        }

        return -1;
    }

}
