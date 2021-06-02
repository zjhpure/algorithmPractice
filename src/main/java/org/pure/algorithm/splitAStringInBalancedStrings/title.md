## 源码路径

/src/main/java/org/pure/algorithm/splitAStringInBalancedStrings/Main.java

## 题目地址(分割平衡字符串)

https://leetcode-cn.com/problems/split-a-string-in-balanced-strings

## 题目描述

```
在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。

给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

注意：分割得到的每个字符串都必须是平衡字符串。

返回可以通过分割得到的平衡字符串的 最大数量 。

示例1:

输入：s = "RLRRLLRLRL"
输出：4
解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。

示例2:

输入：s = "RLLLLRRRLR"
输出：3
解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。

示例3:

输入：s = "LLLLRRRR"
输出：1
解释：s 只能保持原样 "LLLLRRRR"。

示例4:

输入：s = "RLRRRLLRLL"
输出：2
解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。

提示:

1 <= s.length <= 1000
s[i] = 'L' 或 'R'
s 是一个 平衡 字符串
```

## 代码

- 语言：Java

```
class Solution {

    public int balancedStringSplit(String s) {
        // 定义最大数量
        int maxSum = 0;

        // 定义L字符数量
        int totalLeft = 0;
        // 定义R字符数量
        int totalRight = 0;

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            if ('L' == s.charAt(i)) {
                // 若是L字符，L字符数量加1
                ++totalLeft;
            } else {
                // 若是R字符，R字符数量加1
                ++totalRight;
            }

            if (totalRight > 0 && totalLeft == totalRight) {
                // 若L字符数量和R字符数量都大于0，并且两者相等，那么找到了切割后的平衡字符串，最大数量加1
                ++maxSum;
                // 找到一个平衡字符串后，把L字符数量和R字符数量都重置为0，重新开始判断后面的平衡字符串
                totalLeft = 0;
                totalRight = 0;
            }
        }

        return maxSum;
    }

}
```