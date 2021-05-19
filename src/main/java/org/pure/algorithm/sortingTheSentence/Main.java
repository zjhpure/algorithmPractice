package org.pure.algorithm.sortingTheSentence;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-05-19 08:18
 * @description 将句子排序
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = sortSentence(str);
        System.out.println(result);
    }

    private static String sortSentence(String s) {
        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 定义字符串数组strs，通过切割字符串s获取字符串数组strs
        String[] strs = s.split(" ");

        // 定义整数数组arrays，记录字符串数组strs每个元素的索引
        int[] arrays = new int[strs.length];

        // 定义集合map，记录字符串数组strs里每个索引对应的元素
        Map<Integer, String> map = new HashMap<>();

        // 遍历字符串数组strs，构造整数数组arrays和集合map
        for (int i = 0; i < strs.length; ++i) {
            // 取字符串数组strs的元素
            String str = strs[i];

            // 取元素的最后一个字符为索引，保存到整数数组arrays中
            arrays[i] = Integer.parseInt(str.substring(str.length() - 1));

            // 保存索引和元素到集合map中
            map.put(arrays[i], str.substring(0, str.length() - 1));
        }

        // 对整数数组arrays进行排序
        Arrays.sort(arrays);

        // 遍历整数数组arrays，构造字符串集合sb
        for (int i = 0; i < arrays.length; ++i) {
            // 以整数数组arrays的元素作为key值，获取集合map中的元素
            sb.append(map.get(arrays[i]));

            if (i < arrays.length - 1) {
                // 判断若不是最后一个元素，添加空格
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
