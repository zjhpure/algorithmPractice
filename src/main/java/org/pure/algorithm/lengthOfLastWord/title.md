## 源码路径

/src/main/java/org/pure/algorithm/lengthOfLastWord/Main.java

## 题目地址(最后一个单词的长度)

https://leetcode-cn.com/problems/length-of-last-word

## 题目描述

```
给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

示例1:

输入：s = "Hello World"
输出：5

示例2:

输入：s = " "
输出：0

提示:

1 <= s.length <= 10^4
s 仅有英文字母和空格 ' ' 组成
```

## 代码

- 语言：Java

```
class Solution {

    public int lengthOfLastWord(String s) {
        // 最后一个单词长度
        int lastWordLength = 0;

        // 从尾到头遍历字符串s
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (lastWordLength > 0) {
                    // 若最后一个单词长度大于0，则之前已经递增过，那么最后一个单词的长度已经计算出来了，这里直接结束循环即可
                    break;
                }
            } else {
                ++lastWordLength;
            }
        }

        return lastWordLength;
    }

}
```