## 源码路径

/src/main/java/org/pure/algorithm/removeAllAdjacentDuplicatesInString/Main.java

## 题目地址(删除字符串中的所有相邻重复项)

https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string

## 题目描述

```
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

示例:

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

提示：

1 <= S.length <= 20000
S 仅由小写英文字母组成。
```

## 代码

- 语言：Java

```
class Solution {

    public String removeDuplicates(String s) {
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

}
```