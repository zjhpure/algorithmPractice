## 源码路径

/src/main/java/org/pure/algorithm/stringCompress/Main.java

## 题目地址(字符串压缩)

https://leetcode-cn.com/problems/compress-string-lcci

## 题目描述

```
字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

示例1:

输入："aabcccccaaa"
输出："a2b1c5a3"

示例2:

输入："abbccd"
输出："abbccd"
解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。

提示:

字符串长度在[0, 50000]范围内。
```

## 代码

- 语言：Java

```
class Solution {

    public String compressString(String S) {
        // 定义压缩后的字符串集合
        StringBuilder sb = new StringBuilder();

        // 字符重复个数
        int num = 1;

        // 字符串长度
        int size = S.length();

        if (size == 1) {
            // 若字符串长度为1，返回原字符串
            return S;
        }

        // 遍历字符串
        for (int i = 0; i < size; ++i) {
            // 获取当前字符
            char c = S.charAt(i);

            // 第一位置的字符
            if (i == 0) {
                // 添加第一个字符
                sb.append(c);

                // 获取下一个字符
                char cNext = S.charAt(i + 1);

                if (c != cNext) {
                    // 若当前字符和下一个字符不同，那么进行字符重复个数结算
                    sb.append(num);

                    // 重置字符重复个数
                    num = 1;
                }

                continue;
            }

            // 最后位置的字符
            if (i == size - 1) {
                // 获取上一个字符
                char cPre = S.charAt(i - 1);

                if (c == cPre) {
                    // 当前字符和前一个字符相同
                    ++num;
                    sb.append(num);
                } else {
                    // 当前字符和前一个字符不同
                    sb.append(c);
                    sb.append(1);
                }

                continue;
            }

            // 中间位置的字符

            // 获取上一个字符
            char cPre = S.charAt(i - 1);

            if (c == cPre) {
                // 当前字符和前一个字符相同
                ++num;
            } else {
                // 当前字符和前一个字符不同
                sb.append(c);
            }

            // 获取下一个字符
            char cNext = S.charAt(i + 1);

            if (c != cNext) {
                // 若当前字符和下一个字符不同，那么进行字符重复个数结算
                sb.append(num);

                // 重置字符重复个数
                num = 1;
            }
        }

        // 获取压缩后的字符串
        String str = sb.toString();

        if (str.length() < S.length()) {
            // 若压缩后的字符串长度变短了，返回压缩后的字符串
            return str;
        } else {
            // 若压缩后的字符串长度没有变短，返回原字符串
            return S;
        }
    }

}
```