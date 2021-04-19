package org.pure.algorithm.reformatDate;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-19 08:06
 * @description 转变日期格式
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = reformatDate(str);
        System.out.println(result);
    }

    private static String reformatDate(String date) {
        // 切割字符串date，通过空格分割，分割成日、月、年
        String[] strs = date.split(" ");

        // 获取日字符串，去掉最后两个字符，剩下就是日的字符串，再转为整数
        int day = Integer.parseInt(strs[0].substring(0, strs[0].length() - 2));

        // 定义月
        int month = 0;

        // 定义月字符串数组
        String[] monthList = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        // 遍历月字符串数组，找出月是哪一个月
        for (int i = 0; i < monthList.length; ++i) {
            if (strs[1].equals(monthList[i])) {
                month = i + 1;
            }
        }

        // 获取年
        String year = strs[2];

        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 字符串集合添加年
        sb.append(year);

        sb.append("-");

        // 字符串集合添加月
        if (month < 10) {
            // 小于10的补零
            sb.append("0");
        }
        sb.append(month);

        sb.append("-");

        // 字符串集合添加日
        if (day < 10) {
            // 小于10的补零
            sb.append("0");
        }
        sb.append(day);

        return sb.toString();
    }

}
