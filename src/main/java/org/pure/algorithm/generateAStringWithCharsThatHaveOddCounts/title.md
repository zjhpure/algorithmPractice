## 源码路径

/src/main/java/org/pure/algorithm/generateAStringWithCharsThatHaveOddCounts/Main.java

## 题目地址(生成每种字符都是奇数个的字符串)

https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts

## 题目描述

```
给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。

返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。

示例1:

输入：n = 4
输出："pppz"
解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。

示例2:

输入：n = 2
输出："xy"
解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。

示例3:

输入：n = 7
输出："holasss"

提示:

1 <= n <= 500
```

## 代码

- 语言：Java

```
class Solution {

    public String generateTheString(int n) {
        // 定义字符数组，长度为n
        char[] cs = new char[n];

        if (n % 2 == 0) {
            // 若n是偶数，即偶数个字符，生成两种奇数个的字符，由1个a字符和n-1个字符b组成
            cs[0] = 'a';
            for (int i = 1; i < n; ++i) {
                cs[i] = 'b';
            }
        } else {
            // 若n是奇数，即奇数个字符，只生成一种奇数个的字符，全部由字符a组成
            for (int i = 0; i < n; ++i) {
                cs[i] = 'a';
            }
        }

        // 字符数组转为字符串
        return String.valueOf(cs);
    }

}
```