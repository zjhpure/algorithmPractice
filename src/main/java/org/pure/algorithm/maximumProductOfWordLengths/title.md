## 源码路径

/src/main/java/org/pure/algorithm/maximumProductOfWordLengths/Main.java

## 题目地址(最大单词长度乘积)

https://leetcode-cn.com/problems/maximum-product-of-word-lengths

## 题目描述

```
给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回0。

示例1：

输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16 
解释: 这两个单词为"abcw", "xtfn"。

示例2：

输入: ["a","ab","abc","d","cd","bcd","abcd"]
输出: 4 
解释: 这两个单词为"ab", "cd"。

示例3：

输入: ["a","aa","aaa","aaaa"]
输出: 0 
解释: 不存在这样的两个单词。

提示：

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i]仅包含小写字母
```

## 代码

- 语言：Java

```
class Solution {

    public int maxProduct(String[] words) {
        // 模拟法
        
        // 定义最大值
        int maxCount = 0;

        // 遍历字符串数组
        for (int i = 0; i < words.length; ++i) {
            // 获取字符串
            String word = words[i];

            // 再次遍历字符串数组，获取下一个字符串
            for (int j = i + 1; j < words.length; ++j) {
                // 获取下一个字符串
                String str = words[j];

                // 定义是否合法标识，判断两个单词是否不含有公共字母
                boolean isValid = true;

                // 遍历下一个字符串中的所有字符
                for (int k = 0; k < str.length(); ++k) {
                    if (word.indexOf(str.charAt(k)) > -1) {
                        // 若下一个字符串中的所有字符有一个在字符串中能找到，那么这两个单词含有公共字母
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    // 若两个单词不含有公共字母，计算两个单词的长度乘积，和最大值比较，取最大值
                    maxCount = Math.max(maxCount, word.length() * words[j].length());
                }
            }
        }

        // 返回最大值
        return maxCount;
    }

}
```