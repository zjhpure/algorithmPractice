## 源码路径

/src/main/java/org/pure/algorithm/mergeStringsAlternately/Main.java

## 题目地址(交替合并字符串)

https://leetcode-cn.com/problems/merge-strings-alternately

## 题目描述

```
给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。

返回合并后的字符串。


示例1:

输入：word1 = "abc", word2 = "pqr"
输出："apbqcr"
解释：字符串合并情况如下所示：
word1：  a   b   c
word2：    p   q   r
合并后：  a p b q c r

示例2:

输入：word1 = "ab", word2 = "pqrs"
输出："apbqrs"
解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
word1：  a   b 
word2：    p   q   r   s
合并后：  a p b q   r   s

示例3:

输入：word1 = "abcd", word2 = "pq"
输出："apbqcd"
解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
word1：  a   b   c   d
word2：    p   q 
合并后：  a p b q c   d

提示：

1 <= word1.length, word2.length <= 100
word1 和 word2 由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public String mergeAlternately(String word1, String word2) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 定义短字符串的长度
        int length = Math.min(word1.length(), word2.length());

        // 遍历字符串的字符，交替取word1和word2的字符，长度为短字符串的长度
        for (int i = 0; i < length; ++i) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        // 取剩下字符串的字符
        if (word1.length() > word2.length()) {
            // 若word1为长字符串，取word1剩下的字符
            for (int i = length; i < word1.length(); ++i) {
                sb.append(word1.charAt(i));
            }
        } else {
            // 若word2为长字符串，取word2剩下的字符
            for (int i = length; i < word2.length(); ++i) {
                sb.append(word2.charAt(i));
            }
        }

        // 字符串集合转为字符串
        return sb.toString();
    }

}
```