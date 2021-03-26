## 源码路径

/src/main/java/org/pure/algorithm/numOfSegmentsInString/Main.java

## 题目地址(字符串中的单词数)

https://leetcode-cn.com/problems/number-of-segments-in-a-string

## 题目描述

```
统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

请注意，你可以假定字符串里不包括任何不可打印的字符。

示例:

输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
```

## 代码

- 语言：Java

```
class Solution {

    public int countSegments(String s) {
        // 定义单词数
        int count = 0;

        // 定义单词标志
        boolean isWord = false;

        // 遍历字符串s的每个字符
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ') {
                // 若不是空格字符，就是单词字符
                if (!isWord) {
                    // 若前面没有判断出是单词字符，那么单词数加1
                    ++count;
                    // 单词标志设置为是
                    isWord = true;
                }
            } else {
                // 若是空格字符，单词标志设置为否
                isWord = false;
            }
        }

        return count;
    }

}
```