## 源码路径

/src/main/java/org/pure/algorithm/replaceAllDigitsWithCharacters/Main.java

## 题目地址(将所有数字用字符替换)

https://leetcode-cn.com/problems/replace-all-digits-with-characters

## 题目描述

```
给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。

定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。

比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。

请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。

示例1:

输入：s = "a1c1e1"
输出："abcdef"
解释：数字被替换结果如下：
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('c',1) = 'd'
- s[5] -> shift('e',1) = 'f'

示例2:

输入：s = "a1b2c3d4e"
输出："abbdcfdhe"
解释：数字被替换结果如下：
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('b',2) = 'd'
- s[5] -> shift('c',3) = 'f'
- s[7] -> shift('d',4) = 'h'

提示：

1 <= s.length <= 100
s 只包含小写英文字母和数字。
对所有 奇数 下标处的 i ，满足 shift(s[i-1], s[i]) <= 'z' 。
```

## 代码

- 语言：Java

```
class Solution {

    public String replaceDigits(String s) {
        // 定义字符数组，保存替换后的字符
        char[] values = new char[s.length()];

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 1) {
                // 奇数下标是数字，通过shift函数把前一个下标的字符转成其后面的第n个字符，再添加到字符数组
                // 字符会转为ASCII码，根据ASCII码表，减去48刚好等于数字
                values[i] = shift(s.charAt(i - 1), s.charAt(i) - 48);
            } else {
                // 偶数下标是小写英文字母，直接添加到字符数组
                values[i] = s.charAt(i);
            }
        }

        // 定义字符集合
        StringBuilder sb = new StringBuilder();

        // 遍历字符数组
        for (char value : values) {
            // 把字符添加字符集合
            sb.append(value);
        }

        // 字符转为字符串
        return sb.toString();
    }

    // 把字符转成其后面的第n个字符
    private char shift(char c, int n) {
        // 字符会转为ASCII码，数字相加刚好等于后面的第n个字符，再强转回字符
        return (char) (c + n);
    }

}
```