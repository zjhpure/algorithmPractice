## 源码路径

/src/main/java/org/pure/algorithm/reverseWordsInAString3/Main.java

## 题目地址(反转字符串中的单词III)

https://leetcode-cn.com/problems/reverse-words-in-a-string-iii

## 题目描述

```
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例:

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：

在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
```

## 代码

- 语言：Java

```
class Solution {

    public String reverseWords(String s) {
        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 以空格为分隔符切割字符串s，获取字符串数组
        String[] strs = s.split(" ");

        // 遍历字符串数组
        for (int i = 0; i < strs.length; ++i) {
            // 获取字符串
            String str = strs[i];

            // 遍历字符串的字符，从尾部到头部
            for (int j = str.length() - 1; j >= 0; --j) {
                sb.append(str.charAt(j));
            }

            // 判断是否为最后一个字符串，若是最后一个字符串，则不用添加空格，否则要添加空格
            if (i < strs.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
```