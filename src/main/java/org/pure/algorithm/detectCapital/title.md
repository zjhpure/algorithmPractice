## 源码路径

/src/main/java/org/pure/algorithm/detectCapital/Main.java

## 题目地址(检测大写字母)

https://leetcode-cn.com/problems/detect-capital

## 题目描述

```
给定一个单词，你需要判断单词的大写使用是否正确。

我们定义，在以下情况时，单词的大写用法是正确的：

全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。

示例1:

输入: "USA"
输出: True

示例2:

输入: "FlaG"
输出: False

注意：输入是由大写和小写拉丁字母组成的非空单词。
```

## 代码

- 语言：Java

```
class Solution {

    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            // 若字母只有一个，单词写法都是对的
            return true;
        } else {
            // 若字母大于一个，进行单词写法是否正确的判断

            // 是否判断小写字母
            boolean isJudgeLowercase = true;

            char c1 = word.charAt(0);
            char c2 = word.charAt(1);

            if (c1 >= 97 && c1 <= 122) {
                // 若第一个字母是小写字母
                if (c2 >= 97 && c2 <= 122) {
                    // 若第二个字母是小写字母，属于都是小写字母的情况，那么要判断后面的字母是否都是小写字母
                    isJudgeLowercase = true;
                } else {
                    // 若第二个字母是大写字母，属于不正确的情况
                    return false;
                }
            } else {
                // 若第一个字母是大写字母
                if (c2 >= 97 && c2 <= 122) {
                    // 若第二个字母是小写字母，属于首字母大写的情况，那么要判断后面的字母是否都是小写字母
                    isJudgeLowercase = true;
                } else {
                    // 若第二个字母是大写字母，属于都是大写字母的情况，判断后面的字母是否都是大写字母
                    isJudgeLowercase = false;
                }
            }

            // 遍历字符串word，从第二个字母开始遍历
            for (int i = 1; i < word.length(); ++i) {
                if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                    // 若是小写字母
                    if (!isJudgeLowercase) {
                        // 若不是判断小写字母，直接返回不正确
                        return false;
                    }
                } else {
                    // 若是大写字母
                    if (isJudgeLowercase) {
                        // 若是判断小写字母，直接返回不正确
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
```