## 源码路径

/src/main/java/org/pure/algorithm/substringsOfSizeThreeWithDistinctChars/Main.java

## 题目地址(长度为三且各字符不同的子字符串)

https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters

## 题目描述

```
如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。

给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。

注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。

子字符串 是一个字符串中连续的字符序列。

示例1:

输入：s = "xyzzaz"
输出：1
解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
唯一的长度为 3 的好子字符串是 "xyz" 。

示例2:

输入：s = "aababcabc"
输出：4
解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。

提示:

1 <= s.length <= 100
s​​​​​​ 只包含小写英文字母。
```

## 代码

- 语言：Java

```
class Solution {

    public int countGoodSubstrings(String s) {
        // 定义好子字符串的数量
        int count = 0;

        // 遍历字符串s的字符，从第1个字符遍历到倒数3个字符
        for (int i = 0; i < s.length() - 2; ++i) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                // 遍历到的每一个字符，和后两个字符组成长度为3的子字符串，若这三个字符都不两两都相等，那么就是好子字符串，数量加1
                ++count;
            }
        }

        // 返回好子字符串的数量
        return count;
    }

}
```