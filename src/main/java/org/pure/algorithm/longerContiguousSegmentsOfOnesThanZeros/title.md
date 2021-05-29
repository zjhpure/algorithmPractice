## 源码路径

/src/main/java/org/pure/algorithm/longerContiguousSegmentsOfOnesThanZeros/Main.java

## 题目地址(哪种连续子字符串更长)

https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros

## 题目描述

```
给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。

例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。

示例1:

输入：s = "1101"
输出：true
解释：
由 1 组成的最长连续子字符串的长度是 2："1101"
由 0 组成的最长连续子字符串的长度是 1："1101"
由 1 组成的子字符串更长，故返回 true 。

示例2:

输入：s = "111000"
输出：false
解释：
由 1 组成的最长连续子字符串的长度是 3："111000"
由 0 组成的最长连续子字符串的长度是 3："111000"
由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。

示例3:

输入：s = "110100010"
输出：false
解释：
由 1 组成的最长连续子字符串的长度是 2："110100010"
由 0 组成的最长连续子字符串的长度是 3："110100010"
由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。

提示:

1 <= s.length <= 100
s[i] 不是 '0' 就是 '1'
```

## 代码

- 语言：Java

```
class Solution {

    public boolean checkZeroOnes(String s) {
        // 定义最长1的长度
        int maxOneLength = 0;
        // 定义最长0的长度
        int maxZeroLength = 0;

        // 定义当前1的长度
        int currentOneLength = 0;
        // 定义当前0的长度
        int currentZeroLength = 0;

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                // 若字符为1，先把当前0的长度设为0
                currentZeroLength = 0;

                if (i > 0 && s.charAt(i - 1) == '1') {
                    // 若不是第一个字符并且这个字符的前一个字符是1，那么连续子字符串1还在继续，所以当前1的长度加1
                    ++currentOneLength;
                } else {
                    // 若是第一个字符或者不是第一个字符但前一个字符不是1，那么连续子字符串1重新开始，所以当前1的长度设为1
                    currentOneLength = 1;
                }

                // 比较最长1的长度和当前1的长度，更新最长1的长度
                if (maxOneLength < currentOneLength) {
                    maxOneLength = currentOneLength;
                }
            } else {
                // 若字符为0，先把当前1的长度设为0
                currentOneLength = 0;

                if (i > 0 && s.charAt(i - 1) == '0') {
                    // 若不是第一个字符并且这个字符的前一个字符是0，那么连续子字符串0还在继续，所以当前1的长度加1
                    ++currentZeroLength;
                } else {
                    // 若是第一个字符或者不是第一个字符但前一个字符不是0，那么连续子字符串0重新开始，所以当前0的长度设为1
                    currentZeroLength = 1;
                }

                // 比较最长0的长度和当前0的长度，更新最长0的长度
                if (maxZeroLength < currentZeroLength) {
                    maxZeroLength = currentZeroLength;
                }
            }
        }

        // 若最长1的长度大于最长0的长度，返回true，否则返回false
        return maxOneLength > maxZeroLength;
    }

}
```