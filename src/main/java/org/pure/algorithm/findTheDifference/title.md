## 源码路径

/src/main/java/org/pure/algorithm/findTheDifference/Main.java

## 题目地址(找不同)

https://leetcode-cn.com/problems/longest-common-prefix

## 题目描述

```
给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

示例1:

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。

示例2:

输入：s = "", t = "y"
输出："y"

示例3:

输入：s = "a", t = "aa"
输出："a"

示例4:

输入：s = "ae", t = "aea"
输出："a"

提示：

0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母
```

## 代码

- 语言：Java

```
class Solution {

    public char findTheDifference(String s, String t) {
        // 用位运算方法找出字符串t中比字符串s中多出的字符
        int res = 0;

        // 先遍历字符串s的的字符，每次都进行异或运算
        for (int i = 0; i < s.length(); ++i) {
            res ^= s.charAt(i);
        }

        // 再遍历字符串t的字符，每次都进行异或运算
        for (int i = 0; i < t.length(); ++i) {
            res ^= t.charAt(i);
        }

        // 相同两数异或运算，得到0
        // 0和某数异或运算，得到某数本身
        // 这里把字符串s和字符串t的所有字符进行了异或运算，刚好字符串t中包含所有字符串s中的字符，并且字符串t中多出一个额外字符，那么最终的结果就是额外字符本身
        
        return (char) res;
    }

}
```