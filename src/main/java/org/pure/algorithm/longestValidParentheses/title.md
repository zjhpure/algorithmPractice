## 源码路径

/src/main/java/org/pure/algorithm/longestValidParentheses/Main.java

## 题目地址(最长有效括号)

https://leetcode-cn.com/problems/longest-valid-parentheses

## 题目描述

```
给你一个只包含'('和')'的字符串，找出最长有效(格式正确且连续)括号子串的长度。

示例1:

输入：s = "(()"
输出：2
解释：最长有效括号子串是"()"

示例2:

输入：s = ")()())"
输出：4
解释：最长有效括号子串是"()()"

示例3:

输入：s = ""
输出：0

提示：

0 <= s.length <= 3 * 10^4
s[i]为'('或')'
```

## 代码

- 语言：Java

```
class Solution {

    public int longestValidParentheses(String s) {
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
```