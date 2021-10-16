package org.pure.algorithm.makeTheStringGreat;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-16 22:10
 * @description 整理字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = makeGood(str);
        System.out.println(result);
    }

    private static String makeGood(String s) {
        // 模拟过程，把字符串转为字符数组，遍历字符数组，若出现有需要整理的字符，那么把这两个字符设置为'0'，再次遍历字符数组，跳过为'0'的字符，若出现有需要整理的字符，同样把这两个字符设置为'0'，再次遍历字符数组，直到没有出现有需要整理的字符，完成整理；最后遍历字符数组，把不是'0'字符添加到字符串集合中，再把字符串集合转为字符串

        // 把字符串转为字符数组
        char[] cs = s.toCharArray();

        // 定义是否继续标识
        boolean isContinue = true;

        // 不断循环，模拟每次的整理字符串，直到不用继续整理
        while (isContinue) {
            // 是否继续标识先设置为false
            isContinue = false;

            // 遍历字符数组，从第1个到倒数第2个
            for (int i = 0; i < cs.length - 1; ++i) {
                // 当字符不为'0'时，才进行整理字符的操作
                if (cs[i] != '0') {
                    // 定义下一个进行判断的字符下标
                    int next = i + 1;

                    // 寻找后面第一个不是'0'的字符，因为可能上一轮整理字符产生了'0'，从而产生了间隔
                    while (next < cs.length && cs[next] == '0') {
                        ++next;
                    }

                    // 若当前字符和下一个不是'0'的字符刚好相差32，那么这两个字符互为大小写字符，符合整理字符
                    if (next < cs.length && Math.abs(cs[i] - cs[next]) == 32) {
                        // 把当前字符设置为'0'
                        cs[i] = '0';
                        // 把下一个不是'0'的字符设置为'0'
                        cs[next] = '0';
                        // 当前下标设置为下一个不是'0'的字符下标
                        i = next;
                        // 若有出现整理，那么是否继续标识设置为true
                        isContinue = true;
                    }
                }
            }
        }

        // 定义字符串集合，保存整理字符后的结果
        StringBuilder sb = new StringBuilder();

        // 遍历整理好的字符数组，把不是'0'字符添加到字符串集合中
        for (char c : cs) {
            if (c != '0') {
                sb.append(c);
            }
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
