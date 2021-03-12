## 源码路径

/src/main/java/org/pure/algorithm/countConsistentStrings/Main.java

## 题目地址(统计一致字符串的数目)

https://leetcode-cn.com/problems/count-the-number-of-consistent-strings

## 题目描述

```
给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。

请你返回 words 数组中 一致字符串 的数目。

示例1:

输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
输出：2
解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。

示例2:

输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
输出：7
解释：所有字符串都是一致的。

示例3:

输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
输出：4
解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。

提示:

1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
allowed 中的字符 互不相同 。
words[i] 和 allowed 只包含小写英文字母。
```

## 代码

- 语言：Java

```
class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        // 定义一致字符串数目
        int count = 0;

        // 遍历words字符串数组
        for (String word : words) {
            // 是否符合一致字符串条件
            boolean isConform = true;

            // 遍历word字符串的字符
            for (int j = 0; j < word.length(); ++j) {
                if (allowed.indexOf(word.charAt(j)) < 0) {
                    // 若有一个字符不在字符串allowed中，那么这个字符串就不是一致字符串
                    isConform = false;
                    break;
                }
            }

            if (isConform) {
                // 若符合一致字符串条件，一致字符串数目加1
                ++count;
            }
        }

        return count;
    }

}
```