package org.pure.algorithm.latestTimeByReplacingHiddenDigits;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-25 22:01
 * @description 替换隐藏数字得到的最晚时间
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = maximumTime(str);
        System.out.println(result);
    }

    private static String maximumTime(String time) {
        // 枚举法，时间字符串time固定是5位，中间是冒号，前2位是小时，后2位是分钟，逐个判断前2位和后2位的字符，构造最晚有效时间

        // 把时间字符串time转为字符数组
        char[] cs = time.toCharArray();

        // 若第1位字符是问号，小时的第1个字符
        if (cs[0] == '?') {
            // 构造第1位字符，若第2位字符是4-9，因为小时的范围是[0-24)，所以这里最大是1；若第2位字符不是4-9，那么就是1-3或者?，如果是1-3，这里最大只能是2，因为小时最大是23，如果是?，那么第1位和第2位字符都是问号，小时取23，这里最大也是2
            cs[0] = (cs[1] >= '4' && cs[1] <= '9') ? '1' : '2';
        }

        // 若第2位字符是问号，小时的第2个字符
        if (cs[1] == '?') {
            // 若第1位字符是2，那么最大小时是23，所以这里最大是3；若第1位字符不是2，那么就是1，那么最大小时是19，所以这里最大是9
            cs[1] = cs[0] == '2' ? '3' : '9';
        }

        // 若第4位字符是问号，分钟的第1个字符
        if (cs[3] == '?') {
            // 因为最大分钟是59，所以这里最大是5
            cs[3] = '5';
        }

        // 若第5位字符是问号，分钟的第2个字符
        if (cs[4] == '?') {
            // 因为最大分钟是59，所以这里最大是9
            cs[4] = '9';
        }

        // 字符数组转为字符串
        return new String(cs);
    }

}
