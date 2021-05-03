package org.pure.algorithm.occurrencesAfterBigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-03 10:21
 * @description Bigram分词
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String[] results = findOcurrences(text, first, second);
        System.out.println(Arrays.toString(results));
    }

    private static String[] findOcurrences(String text, String first, String second) {
        // 定义列表list，保存第三个词
        List<String> list = new ArrayList<>();

        // 切割字符串text，得到字符串数组strs
        String[] strs = text.split(" ");

        // 遍历字符串数组strs，从第一个元素遍历到倒数第三个元素
        for (int i = 0; i < strs.length - 2; ++i) {
            if (first.equals(strs[i]) && second.equals(strs[i + 1])) {
                // 如果出现当前元素等于first，下一个元素等于second，那么符合条件，下两个元素就是第三个词，把它添加到列表list中
                list.add(strs[i + 2]);
            }
        }

        // 列表list转为数组
        return list.toArray(new String[0]);
    }

}
