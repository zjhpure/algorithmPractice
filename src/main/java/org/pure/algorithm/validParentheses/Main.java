package org.pure.algorithm.validParentheses;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-01-28 01:09
 * @description 有效的括号
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        // 获取输出结果
        boolean rs = isValid(s);
        System.out.println(rs);
    }

    private static boolean isValid(String s) {
        // 定义栈保存括号
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if ('(' == c || '{' == c || '[' == c) {
                // 若是左括号，压入栈
                stack.push(c);
            }

            if (')' == c || '}' == c || ']' == c) {
                // 若是右括号，先判断栈是否为空，若为空，证明没有对应的左括号，可以马上判定为无效括号
                if (stack.size() <= 0) {
                    return false;
                }

                // 取栈的顶元素
                char top = stack.peek();

                // 和栈的顶元素对比是否可以组成括号
                switch (top) {
                    case '(':
                        if (c == ')') {
                            // 若可以组成括号，把栈的顶元素推出
                            stack.pop();
                        } else {
                            // 若不可以组成括号，可以马上判定为无效括号
                            return false;
                        }
                        break;
                    case '{':
                        if (c == '}') {
                            // 若可以组成括号，把栈的顶元素推出
                            stack.pop();
                        } else {
                            // 若不可以组成括号，可以马上判定为无效括号
                            return false;
                        }
                        break;
                    case '[':
                        if (c == ']') {
                            // 若可以组成括号，把栈的顶元素推出
                            stack.pop();
                        } else {
                            // 若不可以组成括号，可以马上判定为无效括号
                            return false;
                        }
                        break;
                }
            }
        }

        // 若栈的全部左括号都被推出，证明刚好组成有效括号
        // 若栈的的左括号有剩余，证明有多出的左括号，那么不是有效括号
        return stack.size() == 0;
    }

}
