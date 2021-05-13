package org.pure.algorithm.goalParserInterpretation;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-13 20:06
 * @description 设计Goal解析器
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = interpret(str);
        System.out.println(result);
    }

    private static String interpret(String command) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 遍历字符串command
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == 'G') {
                // 若是G，直接解释为G
                sb.append("G");
            } else if (command.charAt(i) == '(') {
                // 若是(开头，判断属于后两种的哪一种
                if (i < command.length() - 1) {
                    // 若字符不在字符串command的最后
                    if (command.charAt(i + 1) == ')') {
                        // 若是()，解释为o
                        sb.append("o");
                    } else if (command.charAt(i + 1) == 'a') {
                        // 若是a，排除第二种可能
                        if (i < command.length() - 3) {
                            // 若字符a后面还有两个字符
                            if (command.charAt(i + 2) == 'l' && command.charAt(i + 3) == ')') {
                                // 若是(al)，解释为al
                                sb.append("al");
                            }
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

}
