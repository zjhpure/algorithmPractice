## 源码路径

/src/main/java/org/pure/algorithm/decryptStringFromAlphabetToIntegerMapping/Main.java

## 题目地址(解码字母到整数映射)

https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping

## 题目描述

```
给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：

字符（'a' - 'i'）分别用（'1' - '9'）表示。
字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
返回映射之后形成的新字符串。

题目数据保证映射始终唯一。

示例1:

输入：s = "10#11#12"
输出："jkab"
解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

示例2:

输入：s = "1326#"
输出："acz"

示例3:

输入：s = "25#"
输出："y"

示例4:

输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
输出："abcdefghijklmnopqrstuvwxyz"

提示:

1 <= s.length <= 1000
s[i] 只包含数字（'0'-'9'）和 '#' 字符。
s 是映射始终存在的有效字符串。
```

## 代码

- 语言：Java

```
class Solution {

    public String freqAlphabets(String s) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 2) {
                // 若在倒数第2个字符之前
                if (s.charAt(i + 2) == '#') {
                    // 若字符的后两位有#，那么按照10-26处理
                    if (s.charAt(i) == '1') {
                        // 若以字符1开头，可以分拆成10+x，10刚好是j，x等于下一位字符的ASCII码减去0的ASCII码，ASCII码可以相减得到整数，再强转为字符char，得到对应的字符
                        sb.append((char)('j' + s.charAt(i + 1) - '0'));
                    } else if (s.charAt(i) == '2') {
                        // 若以字符2开头，可以分拆成20+x，20刚好是t，x等于下一位字符的ASCII码减去0的ASCII码，ASCII码可以相减得到整数，再强转为字符char，得到对应的字符
                        sb.append((char)('t' + s.charAt(i + 1) - '0'));
                    }
                    // 因为带#的一共3位，所以跳跃2位下标
                    i += 2;
                } else {
                    // 若字符的后两位没有#，那么按照1-9处理
                    sb.append((char)(s.charAt(i) + '0'));
                }
            } else {
                // 若在倒数第2个字符，全部按照1-9处理
                sb.append((char)(s.charAt(i) + '0'));
            }
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
```