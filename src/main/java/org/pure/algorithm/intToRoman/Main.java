package org.pure.algorithm.intToRoman;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-01-22 01:53
 * @description 整数转罗马数字
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        String result = intToRoman(num);
        System.out.println(result);
    }

    private static String intToRoman(int num) {
        // 结果
        StringBuilder sb = new StringBuilder();

        // 用map保存数字对应的字符串
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        // 定义列表保存每一位数字
        List<Integer> list = new ArrayList<>();

        // 10的n次方迭代值
        int m = 1;

        // 不断取余除10
        while (num > 0) {
            // 获取除10的余数
            int rem = num % 10;

            // 特殊罗马数字组合情况
            if (rem == 4 || rem == 9) {
                // 添加4或9到列表
                list.add(rem * m);
            } else {
                if (rem >= 5) {
                    // 获取除5的余数
                    rem = rem % 5;

                    // 添加rem-1个1到列表
                    for (int j = 0; j < rem; ++j) {
                        // 添加1到列表
                        list.add(m);
                    }

                    // 添加5到列表
                    list.add(5 * m);
                } else {
                    // 添加rem-1个1到列表
                    for (int j = 0; j < rem; ++j) {
                        // 添加1到列表
                        list.add(m);
                    }
                }
            }

            // 迭代值变化
            m = m * 10;

            // 除10
            num = num / 10;
        }

        // 索引最大值
        int index = list.size() - 1;

        // 从尾到头遍历列表
        for (int i = index; i >= 0; --i) {
            int n = list.get(i);

            // 从map中取值获取罗马数字对应的字符串，再叠加字符串
            sb.append(map.get(n));
        }

        return sb.toString();
    }

}
