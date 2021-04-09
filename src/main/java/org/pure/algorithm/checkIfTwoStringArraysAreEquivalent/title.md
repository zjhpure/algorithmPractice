## 源码路径

/src/main/java/org/pure/algorithm/checkIfTwoStringArraysAreEquivalent/Main.java

## 题目地址(检查两个字符串数组是否相等)

https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent

## 题目描述

```
给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。

数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。

示例1:

输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
输出：true
解释：
word1 表示的字符串为 "ab" + "c" -> "abc"
word2 表示的字符串为 "a" + "bc" -> "abc"
两个字符串相同，返回 true

示例2:

输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
输出：false

示例3:

输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
输出：true

提示:

1 <= word1.length, word2.length <= 10^3
1 <= word1[i].length, word2[i].length <= 10^3
1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
word1[i] 和 word2[i] 由小写字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // 定义集合list，保存字符串
        List<Character> list = new ArrayList<>();

        // 遍历第一个字符串数组word1
        for (String s : word1) {
            // 遍历每一个字符串的字符
            for (int j = 0; j < s.length(); ++j) {
                // 添加字符到集合list中
                list.add(s.charAt(j));
            }
        }

        // 定义索引k
        int k = 0;

        // 遍历第二个字符串数组word2
        for (String s : word2) {
            // 遍历每一个字符串的字符
            for (int j = 0; j < s.length(); ++j) {
                if (k < list.size()) {
                    // 当索引k小于集合list的长度时，才开始进行判断，避免数组越界
                    if (list.get(k) != s.charAt(j)) {
                        // 若发现有一个字符不相等，那么两个数组的字符串就不相等了
                        return false;
                    }
                } else {
                    // 若索引k已大于集合list的长度，那么字符串数组word2的长度已经大于字符串数组word1的长度，两个数组的字符串肯定不会再相等
                    return false;
                }

                // 每一次索引k加1
                ++k;
            }
        }

        // 若是索引k和集合list的长度相等，那么两个数组的字符串相等
        return k == list.size();
    }

}
```