## 源码路径

/src/main/java/org/pure/algorithm/palindromePermutation/Main.java

## 题目地址(回文排列)

https://leetcode-cn.com/problems/palindrome-permutation-lcci

## 题目描述

```
给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。

回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。

回文串不一定是字典当中的单词。

示例1:

输入："tactcoa"
输出：true（排列有"tacocat"、"atcocta"，等等）
```

## 代码

- 语言：Java

```
class Solution {

    public boolean canPermutePalindrome(String s) {
        // 字符串长度
        int size = s.length();

        // 单个字符出现次数
        int singleTime = 0;

        while (s.length() > 0) {
            // 获取字符串的第一个字符
            char c = s.charAt(0);

            // 获取出现字符c的第一个索引
            int i = s.indexOf(c);

            // 获取去掉一个字符c后的字符串
            s = s.substring(0, i) + s.substring(i + 1);

            // 获取出现字符c的第二个索引
            int n = s.indexOf(c);

            if (n > -1) {
                // 若存在第二个字符c，获取去掉两个字符c后的字符串
                s = s.substring(0, n) + s.substring(n + 1);
            } else {
                // 若不存在第二个字符c，单个字符出现次数自增1
                ++singleTime;

                if (size % 2 == 0) {
                    // 若字符串长度为偶数，字符必须成对出现才能构成回文串
                    return false;
                } else {
                    // 若字符串长度为奇数，必须要出现一个单独的字符
                    if (singleTime != 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
```