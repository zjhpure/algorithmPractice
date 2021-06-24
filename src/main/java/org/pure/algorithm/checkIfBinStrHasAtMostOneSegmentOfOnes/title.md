## 源码路径

/src/main/java/org/pure/algorithm/checkIfBinStrHasAtMostOneSegmentOfOnes/Main.java

## 题目地址(检查二进制字符串字段)

https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones

## 题目描述

```
给你一个二进制字符串s，该字符串不含前导零。

如果s最多包含一个由连续的'1'组成的字段，返回true​​​。否则，返回false。

示例1:

输入：s = "1001"
输出：false
解释：字符串中的 1 没有形成一个连续字段。

示例2:

输入：s = "110"
输出：true

提示：

1 <= s.length <= 100
s[i]​​​​ 为 '0' 或 '1'
s[0] 为 '1'
```

## 代码

- 语言：Java

```
class Solution {

    public boolean checkOnesSegment(String s) {
        // 这道题最重要的是要理解题目，不要读错题，最多包含一个由连续的'1'组成的子弹，注意最多、连续的字眼，在这里，一个1也是连续1

        // 从字符串s的第三个元素开始遍历，因为字符串s第一个元素是1，那么第二个元素无论是0还是1，都是符合连续1的，返回true
        for (int i = 2; i < s.length(); ++i) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                // 如果从第三个元素起，一旦出现这个元素为1而且前一个元素为0时，那么因为第一个元素是1，已经有一个连续1了，而这里又出现了一个连续1，那么就不符合最多包含一个连续1了，所以不符合条件，返回false
                return false;
            }
        }

        // 如果能遍历完，那么从第三个元素起，没有出现连续1，而第一个元素已经是一个连续1了，所以符合条件，返回true
        return true;
    }

}
```