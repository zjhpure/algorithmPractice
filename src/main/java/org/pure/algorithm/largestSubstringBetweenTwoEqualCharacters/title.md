## 源码路径

/src/main/java/org/pure/algorithm/largestSubstringBetweenTwoEqualCharacters/Main.java

## 题目地址(两个相同字符之间的最长子字符串)

https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters

## 题目描述

```
给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。

子字符串 是字符串中的一个连续字符序列。

示例1:

输入：s = "aa"
输出：0
解释：最优的子字符串是两个 'a' 之间的空子字符串。

示例2:

输入：s = "abca"
输出：2
解释：最优的子字符串是 "bc" 。

示例3:

输入：s = "cbzxy"
输出：-1
解释：s 中不存在出现出现两次的字符，所以返回 -1 。

示例4:

输入：s = "cabbac"
输出：4
解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。

提示：

1 <= s.length <= 300
s 只含小写英文字母
```

## 代码

- 语言：Java

```
class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        // 定义最长子字符串长度
        int maxLength = -1;

        // 遍历字符串s的字符，从0到倒数第二个
        for (int i = 0; i < s.length() - 1; ++i) {
            // 遍历字符串s的字符，从i+1到最后一个
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果两次遍历找到的字符相等，那么就是找到了子字符串
                    if (j - i - 1 > maxLength) {
                        // 更新子字符串的最大长度
                        maxLength = j - i - 1;
                    }
                }
            }
        }

        return maxLength;
    }

}
```