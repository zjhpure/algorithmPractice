package org.pure.algorithm.lengthOfLastWord;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-05 23:22
 * @description 最后一个单词的长度
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = lengthOfLastWord(s);
        System.out.println(result);
    }

    private static int lengthOfLastWord(String s) {
        // 注意示例，前后有空格的情况也是有的，也可能全是空格
//        return way1(s);
        return way2(s);
    }

    // 方法1，从头到尾遍历，速度慢
    private static int way1(String s) {
        // 最后一个单词长度
        int lastWordLength = 0;

        // 从头到尾遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                if (i < s.length() - 1 && s.charAt(i + 1) != ' ') {
                    // 若下一个索引的字符存在并且不为空格，才把最后一个单词长度归零
                    lastWordLength = 0;
                }
            } else {
                ++lastWordLength;
            }
        }

        return lastWordLength;
    }

    // 方法2，从尾到头遍历，速度快，建议用方法2
    private static int way2(String s) {
        // 最后一个单词长度
        int lastWordLength = 0;

        // 从尾到头遍历字符串s
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (lastWordLength > 0) {
                    // 若最后一个单词长度大于0，则之前已经递增过，那么最后一个单词的长度已经计算出来了，这里直接结束循环即可
                    break;
                }
            } else {
                ++lastWordLength;
            }
        }

        return lastWordLength;
    }

}
