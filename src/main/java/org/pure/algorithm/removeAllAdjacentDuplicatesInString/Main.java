package org.pure.algorithm.removeAllAdjacentDuplicatesInString;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhangjianhua
 * @date 2021-06-13 20:19
 * @description 删除字符串中的所有相邻重复项
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        String result = removeDuplicates(str);
        System.out.println(result);
    }

    // 方法1，不建议使用，因为耗时且占多空间，先定义了栈stack，把不相邻重复的字符保存到栈stack中，再从栈stack中遍历把数据保存到StringBuilder中
    private static String removeDuplicates(String s) {
        // 定义栈，保存不相邻重复的字符
        Stack<Character> stack = new Stack<>();

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if (stack.size() > 0) {
                // 若栈不为空，判断栈的顶部元素是否和当前字符相等
                if (stack.peek() == s.charAt(i)) {
                    // 若栈的顶部元素和当前字符相等，出栈，删掉了两个相邻重复的元素
                    stack.pop();
                } else {
                    // 若栈的顶部元素和当前字符不相等，字符入栈
                    stack.push(s.charAt(i));
                }
            } else {
                // 若栈为空，直接字符入栈
                stack.push(s.charAt(i));
            }
        }

        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 遍历栈的元素，从头到尾遍历
        for (Character character : stack) {
            // 把栈的元素保存到字符串集合
            sb.append(character);
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

    // 方法2，建议使用，不定义栈stack，直接只定义一个StringBuilder，因为在StringBuilder本身就可以模拟出栈的功能
    private static String removeDuplicates2(String s) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 定义字符串集合最外元素的下标
        int top = -1;

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if (top >= 0 && sb.charAt(top) == s.charAt(i)) {
                // 若字符串集合的最外元素和当前字符相等，删除最外元素，并且字符不保存进字符串集合
                sb.deleteCharAt(top);
                // 字符串集合最外元素的下标减1
                --top;
            } else {
                // 若字符串集合的最外元素和当前字符不相等，字符保存进字符串集合
                sb.append(s.charAt(i));
                // 字符串集合最外元素的下标加1
                ++top;
            }
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
