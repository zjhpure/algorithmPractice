package org.pure.algorithm.decryptStringFromAlphabetToIntegerMapping;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-11 21:52
 * @description 解码字母到整数映射
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = freqAlphabets(str);
        System.out.println(result);
    }

    private static String freqAlphabets(String s) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 2) {
                // 若在倒数第2个字符之前
                if (s.charAt(i + 2) == '#') {
                    // 若字符的后两位有#，那么按照10-26处理
                    if (s.charAt(i) == '1') {
                        // 若以字符1开头，可以分拆成10+x，10刚好是j，x等于下一位字符的ASCII码减去0的ASCII码，ASCII码可以相减得到整数，再强转为字符char，得到对应的字符
                        sb.append((char) ('j' + s.charAt(i + 1) - '0'));
                    } else if (s.charAt(i) == '2') {
                        // 若以字符2开头，可以分拆成20+x，20刚好是t，x等于下一位字符的ASCII码减去0的ASCII码，ASCII码可以相减得到整数，再强转为字符char，得到对应的字符
                        sb.append((char) ('t' + s.charAt(i + 1) - '0'));
                    }
                    // 因为带#的一共3位，所以跳跃2位下标
                    i += 2;
                } else {
                    // 若字符的后两位没有#，那么按照1-9处理
                    sb.append((char) (s.charAt(i) + '0'));
                }
            } else {
                // 若在倒数第2个字符，全部按照1-9处理
                sb.append((char) (s.charAt(i) + '0'));
            }
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
