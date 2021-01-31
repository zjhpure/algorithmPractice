## 源码路径

/src/main/java/org/pure/algorithm/implementStrstr/Main.java

## 题目地址(实现strStr())

https://leetcode-cn.com/problems/implement-strstr

## 题目描述

```
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例1:

输入: haystack = "hello", needle = "ll"
输出: 2

示例2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1

说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
```

## 代码

- 语言：Java

```
class Solution {

    public int strStr(String haystack, String needle) {
        // 获取needle字符串长度
        int needleLength = needle.length();

        if (needleLength == 0) {
            // needle为空字符串时，返回0
            return 0;
        }

        // 定义返回索引
        int index = -1;

        // 定义是否需要判断字符
        boolean isJudge = false;

        // 定义对比字符时的当前索引
        int currentIndex = 0;

        // 是否相等
        boolean isEqual = false;

        // 遍历haystack字符串
        for (int i = 0; i < haystack.length(); ++i) {
            char c = haystack.charAt(i);

            if (isJudge) {
                // 若需要判断字符
                if (c == needle.charAt(currentIndex)) {
                    // 若字符串相等
                    if (currentIndex == needleLength - 1) {
                        // 若当前索引是needle字符串的最后一个索引，是否相等标识设为true，结束遍历
                        isEqual = true;

                        break;
                    } else {
                        // 当前索引加1
                        ++currentIndex;
                    }
                } else {
                    // 若字符串不相等
                    // 遍历索引回到开始判断字符时的索引
                    i = index;

                    // 返回索引设回原来的-1
                    index = -1;

                    // 判断标识设回原来的false
                    isJudge = false;

                    // 对比字符时的当前索引设回原来的0
                    currentIndex = 0;
                }
            } else {
                // 若不需要判断字符
                if (c == needle.charAt(0)) {
                    // 更新要返回的索引
                    index = i;

                    if (currentIndex == needleLength - 1) {
                        // 若当前索引是needle字符串的最后一个索引，是否相等标识设为true，结束遍历
                        isEqual = true;

                        break;
                    } else {
                        // 若字符等于needle的第1个字符，判断标识设为true
                        isJudge = true;

                        // 当前索引加1
                        ++currentIndex;
                    }
                }
            }
        }

        // 根据是否相等标识判断是否找到needle字符串
        if (isEqual) {
            // needle找到
            return index;
        } else {
            // needle没找到
            return -1;
        }
    }

}
```