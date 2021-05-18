package org.pure.algorithm.maxNestingDepthOfTheParentheses;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-05-18 20:50
 * @description 括号的最大嵌套深度
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = maxDepth(str);
        System.out.println(result);
    }

    private static int maxDepth(String s) {
        // 定义括号最大嵌套深度
        int depth = 0;

        // 定义栈，用来保存括号，因为括号是成对出现的，栈先入后出，最适合保存括号
        Stack<Character> stack = new Stack<>();

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                // 如果字符是左括号，入栈
                stack.push('(');
                // 每次入栈后更新一次括号最大嵌套深度，括号嵌套深度等于栈的长度，但是有可能会变小，所以判断一下栈的长度是否大于当前的括号最大嵌套深度，如果大于，括号最大嵌套深度更新为栈的长度，如果小于等于，括号最大嵌套深度保持不变
                depth = Math.max(stack.size(), depth);
            } else if (s.charAt(i) == ')') {
                // 如果字符是右括号，出栈
                stack.pop();
            }
        }

        return depth;
    }

}
