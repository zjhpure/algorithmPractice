## 源码路径

/src/main/java/org/pure/algorithm/consecutiveCharacters/Main.java

## 题目地址(连续字符)

https://leetcode-cn.com/problems/consecutive-characters

## 题目描述

```
给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

请你返回字符串的能量。

示例1:

输入：s = "leetcode"
输出：2
解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。

示例2:

输入：s = "abbcccddddeeeeedcba"
输出：5
解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。

示例3:

输入：s = "triplepillooooow"
输出：5

示例4:

输入：s = "hooraaaaaaaaaaay"
输出：11

示例5:

输入：s = "tourist"
输出：1

提示:

1 <= s.length <= 500
s 只包含小写英文字母。
```

## 代码

- 语言：Java

```
class Solution {

    public int maxPower(String s) {
        // 定义最大能量
        int max = 0;

        // 定义当前子字符串的长度
        int currentCount = 0;
        // 定义当前字符
        char currentC = '0';

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (currentC == c) {
                // 如果当前字符等于遍历到的字符，那么当前子字符串的长度加1
                ++currentCount;
            } else {
                // 如果当前字符不等于遍历到的字符，那么前面的子字符串结束，从这里重新开始，把当前字符设置为遍历到的字符，并且当前子字符串的长度设置为1
                currentC = c;
                currentCount = 1;
            }

            // 比较当前子字符串的长度和最大能量，取较大值
            max = Math.max(currentCount, max);
        }

        // 最后得出子字符串的最长长度
        return max;
    }

}
```