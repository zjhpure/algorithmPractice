## 源码路径

/src/main/java/org/pure/algorithm/stringRepeatPermutation/Main.java

## 题目地址(判定是否互为字符重排)

https://leetcode-cn.com/problems/check-permutation-lcci

## 题目描述

```
给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

示例1:

输入: s1 = "abc", s2 = "bca"
输出: true 

示例2:

输入: s1 = "abc", s2 = "bad"
输出: false

说明:

0 <= len(s1) <= 100
0 <= len(s2) <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        // 若两个字符串长度不相等，首先排除
        if (s1.length() != s2.length()) {
            return false;
        }

        // 遍历s1字符串的字符
        for (int i = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);

            // 获取字符在s2中的索引
            int index = s2.indexOf(c);

            if (index >= 0) {
                // 若s2中能找到s1中的字符，那么s2去掉找到字符，防止下次判断遇到字符存在但是数量不同的情况
                s2 = s2.substring(0, index) + s2.substring(index + 1);
            } else {
                // 若s2中不能找到s1中的字符，那么字符不能重排
                return false;
            }
        }

        return true;
    }

}
```