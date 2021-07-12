## 源码路径

/src/main/java/org/pure/algorithm/mostCommonWord/Main.java

## 题目地址(最常见的单词)

https://leetcode-cn.com/problems/most-common-word

## 题目描述

```
给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。

题目保证至少有一个词不在禁用列表中，而且答案唯一。

禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

示例:

输入: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
输出: "ball"
解释: 
"hit" 出现了3次，但它是一个禁用的单词。
"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。 
注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"）， 
"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。

提示：

1 <= 段落长度 <= 1000
0 <= 禁用单词个数 <= 100
1 <= 禁用单词长度 <= 10
答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
paragraph 只包含字母、空格和下列标点符号!?',;.
不存在没有连字符或者带有连字符的单词。
单词里只包含字母，不会出现省略号或者其他标点符号。
```

## 代码

- 语言：Java

```
class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        // 定义字符串集合sb，保存处理过特殊字符后的字符串paragraph，注意这里的字符串paragraph有可能逗号后面没有接空格，例如："a, a, a, a, b,b,b,c, c"，也能出现多个特殊字符连续的情况
        StringBuilder sb = new StringBuilder();

        // 遍历字符串paragraph的字符，构造一个分隔字符为空格的新paragraph字符串
        for (int i = 0; i < paragraph.length(); ++i) {
            char c = paragraph.charAt(i);

            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
                // 若字符是小写字母或大写字母，保存到字符串集合sb中
                sb.append(c);
            } else {
                // 若字符串不是小写字母和大写字母，根据情况判断是否保存空格到字符串集合sb中
                if (sb.length() > 0) {
                    // 获取当前字符串集合sb的最后一个字符
                    char ch = sb.charAt(sb.length() - 1);

                    if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
                        // 若当前字符串集合sb的最后一个字符是小写字母或大写字母，那么保存空格到字符串集合sb中，因为要构造一个分隔字符为空格的新paragraph字符串，不能保存连续多个空格，空格只能保存一个
                        sb.append(' ');
                    }
                }
            }
        }

        // 定义集合map，保存单词的个数
        Map<String, Integer> map = new HashMap<>();

        // 切割字符串集合sb，获得单词数组
        String[] strs = sb.toString().split(" ");

        // 遍历单词数组
        for (String str : strs) {
            boolean isFind = false;

            // 遍历禁用单词列表
            for (String b : banned) {
                // 因为单词不区分大小写，而禁用单词列表都是小写字母，所以都转化为小写字母再判断是否相等
                if (str.toLowerCase().equals(b)) {
                    // 若单词相等，那么在禁用单词列表中找到，结束循环
                    isFind = true;
                    break;
                }
            }
            
            if (!isFind) {
                // 若单词在禁用单词列表中没有找到，保存单词和单词的个数到集合map中
                map.put(str.toLowerCase(), map.getOrDefault(str.toLowerCase(), 0) + 1);
            }
        }

        // 定义单词最大个数
        int maxNum = 0;
        // 定义最大个数单词
        String maxNumString = null;

        // 遍历集合map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxNum) {
                // 更新单词最大个数
                maxNum = entry.getValue();
                // 更新最大个数单词
                maxNumString = entry.getKey();
            }
        }

        // 最后返回最大个数单词
        return maxNumString;
    }

}
```