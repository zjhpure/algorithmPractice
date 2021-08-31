package org.pure.algorithm.longestValidParentheses;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-09-01 00:27
 * @description 最长有效括号
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = longestValidParentheses(str);
        System.out.println(result);
    }

    private static int longestValidParentheses(String s) {
        // 利用栈辅助解决，栈保存的是字符的下标，通过下标计算最长有效括号子串的长度

        // 当字符是左括号，字符的下标入栈
        // 当字符是右括号，出栈；若栈为空了，字符的下标入栈，否则通过下标计算最长有效括号子串的长度

        // 定义最长有效括号子串的长度
        int maxLength = 0;

        // 定义栈，保存的是字符的下标
        Stack<Integer> stack = new Stack<>();

        // 先把-1入栈，因为如果一开始就有有效括号子串，那么计算长度时，开头就少了可以相减的数，其实这个下标可以看作是-1，因为数组的最小下标是0，而0下标的前一个字符的下标可以看作是-1
        stack.push(-1);

        // 遍历字符串s，计算最长有效括号子串的长度
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                // 若是左括号，当前字符的下标入栈
                stack.push(i);
            } else {
                // 若是右括号，出栈
                stack.pop();

                if (stack.isEmpty()) {
                    // 若栈为空，那么不计算最长有效括号子串的长度，而是当前的字符下标入栈
                    stack.push(i);
                } else {
                    // 若有出栈并且栈不为空，那么栈顶元素刚好就是当前有效括号子串的前一个元素的下标，当前下标减这个下标，就刚好等于当前有效括号子串的长度，再用Math的max函数比较出最大值
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        // 返回最长有效括号子串的长度
        return maxLength;
    }

}
