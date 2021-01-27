## 源码路径

/src/main/java/org/pure/algorithm/validParentheses/Main.java

## 题目地址(有效的括号)

https://leetcode-cn.com/problems/valid-parentheses

## 题目描述

```
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

示例1:

输入：s = "()"
输出：true

示例2:

输入：s = "()[]{}"
输出：true

示例3:

输入：s = "(]"
输出：false

示例4:

输入：s = "([)]"
输出：false

示例5:

输入：s = "{[]}"
输出：true

提示:

1 <= s.length <= 10^4
s 仅由括号 '()[]{}' 组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isValid(String s) {
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
```