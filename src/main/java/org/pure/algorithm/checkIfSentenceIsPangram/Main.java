package org.pure.algorithm.checkIfSentenceIsPangram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-21 08:02
 * @description 判断句子是否为全字母句
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean result = checkIfPangram(str);
        System.out.println(result);
    }

    private static boolean checkIfPangram(String sentence) {
        // 定义列表list，保存找到的不重复小写字母
        List<Character> list = new ArrayList<>();

        // 遍历字符串sentence的字符
        for (int i = 0; i < sentence.length(); ++i) {
            if (!list.contains(sentence.charAt(i))) {
                // 若列表list中没有找到字符，则添加字符到列表list中
                list.add(sentence.charAt(i));

                if (list.size() >= 26) {
                    // 若列表list的长度大于等于26，则表示已经找全26个字母
                    return true;
                }
            }
        }

        return false;
    }

}
