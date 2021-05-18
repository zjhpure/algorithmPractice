## 源码路径

/src/main/java/org/pure/algorithm/maxNestingDepthOfTheParentheses/Main.java

## 题目地址(括号的最大嵌套深度)

https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses

## 题目描述

```
如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：

字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：

depth("") = 0
depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。

给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。

示例1:

输入：s = "(1+(2*3)+((8)/4))+1"
输出：3
解释：数字 8 在嵌套的 3 层括号中。

示例2:

输入：s = "(1)+((2))+(((3)))"
输出：3

示例3:

输入：s = "1+(2*3)/(2-1)"
输出：1

示例4:

输入：s = "1"
输出：0

提示：

1 <= s.length <= 100
s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
题目数据保证括号表达式 s 是 有效的括号表达式
```

## 代码

- 语言：Java

```
class Solution {

    public int maxDepth(String s) {
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
```