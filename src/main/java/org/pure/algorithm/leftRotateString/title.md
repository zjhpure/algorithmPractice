## 源码路径

/src/main/java/org/pure/algorithm/leftRotateString/Main.java

## 题目地址(左旋转字符串)

https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof

## 题目描述

```
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例1:

输入: s = "abcdefg", k = 2
输出: "cdefgab"

示例2:

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

限制:

1 <= k < s.length <= 10000
```

## 代码

- 语言：Java

```
class Solution {

    public String reverseLeftWords(String s, int n) {
        // 切割字符串，先获取左旋字符串的右侧，再获取左旋字符串，两者相拼接得到结果
        return s.substring(n) + s.substring(0, n);
    }

}
```