## 源码路径

/src/main/java/org/pure/algorithm/toLowerCase/Main.java

## 题目地址(转换成小写字母)

https://leetcode-cn.com/problems/to-lower-case

## 题目描述

```
实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

示例1:

输入: "Hello"
输出: "hello"

示例2:

输入: "here"
输出: "here"

示例3:

输入: "LOVELY"
输出: "lovely"
```

## 代码

- 语言：Java

```
class Solution {

    public String toLowerCase(String str) {
        // 定义字符数组，长度和字符串str一致
        char[] chars = new char[str.length()];

        // 遍历字符串str
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                // 若是大写字母，转成小写字母
                chars[i] = (char)(str.charAt(i) + 32);
            } else {
                // 若是小写字母，直接用
                chars[i] = str.charAt(i);
            }
        }
        
        return String.valueOf(chars);
    }

}
```