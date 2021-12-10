package org.pure.algorithm.shortestCompletingWord;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/10/21 10:15 PM
 * @description 最短补全词
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String licensePlate = scanner.nextLine();
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] words = new String[size];
        for (int i = 0; i < size; ++i) {
            words[i] = strings[i].split("\"")[1];
        }

        // 获取输出结果
        String result = shortestCompletingWord(licensePlate, words);
        System.out.println(result);
    }

    private static String shortestCompletingWord(String licensePlate, String[] words) {
        // 模拟法，计数法

        // 获取补全词的字符统计数组
        int[] count = getCount(licensePlate);

        // 定义最短补全词
        String maxShortestWord = null;

        // 循环，遍历字符串数组
        for (String word : words) {
            // 获取当前单词的字符统计数组
            int[] countTemp = getCount(word);

            // 定义是否符合补全词的标识
            boolean isConform = true;

            // 循环，从0遍历到25，比较补全词字符统计数组和当前单词统计数组
            for (int i = 0; i < 26; ++i) {
                if (count[i] > 0 && countTemp[i] < count[i]) {
                    // 只看补全词中存在的字符，若当前单词的字符数量小于补全词的字符数量，那么不符合补全词的标识，标识为false，结束循环
                    isConform = false;
                    break;
                }
            }

            if (isConform) {
                // 若符合补全词，那么更新当前最短补全词
                if (maxShortestWord == null) {
                    // 若当前最短补全词为空，证明找到的是第一个补全词，先更新最短补全词为第一个补全词
                    maxShortestWord = word;
                } else {
                    // 若当前最短补全词不为空，证明找到的不是第一个补全词，比较当前补全词和最短补全词的长度
                    if (word.length() < maxShortestWord.length()) {
                        // 若当前补全词的长度更短，那么更新最短补全词为当前补全词
                        maxShortestWord = word;
                    }
                }
            }
        }

        // 返回最短补全词
        return maxShortestWord;
    }

    // 统计一个单词中各个字符的个数，返回一个长度为26的统计数组
    private static int[] getCount(String word) {
        // 定义长度为26的统计数组，保存每一个字母的个数，通过计数法统计
        int[] count = new int[26];

        // 遍历单词的字符，统计补全词中每一个字符的个数
        for (int i = 0; i < word.length(); ++i) {
            // 获取单词当前的字符
            char c = word.charAt(i);
            // 判断当前字符是否为字母
            if (Character.isLetter(c)) {
                // 若为字母，字母都转为小写字母，减去字母a的ASCII码，定位到统计数组的下标，数量加1
                ++count[Character.toLowerCase(c) - 'a'];
            }
        }

        // 返回统计数组
        return count;
    }

}
