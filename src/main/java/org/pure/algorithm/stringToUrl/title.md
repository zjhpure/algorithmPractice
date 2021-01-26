## 源码路径

/src/main/java/org/pure/algorithm/stringToUrl/Main.java

## 题目地址(URL化)

https://leetcode-cn.com/problems/string-to-url-lcci

## 题目描述

```
URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

示例1:

输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"

示例2:

输入："               ", 5
输出："%20%20%20%20%20"

提示:

字符串长度在 [0, 500000] 范围内。
```

## 代码

- 语言：Java

```
class Solution {

    public String replaceSpaces(String S, int length) {
        // 注意处理空格多出的情况，先按照给出的长度切割出真实的字符串，再把空格替换成%20
        return S.substring(0, length).replace(" ", "%20");
    }

}
```