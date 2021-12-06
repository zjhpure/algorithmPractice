## 源码路径

/src/main/java/org/pure/algorithm/truncateSentence/Main.java

## 题目地址(截断句子)

https://leetcode-cn.com/problems/truncate-sentence

## 题目描述

```
句子是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成(不含标点符号)。

例如，"Hello World"、"HELLO"和"hello world hello world"都是句子。
给你一个句子s​​​​​和一个整数k​​​​​​，请你将s​​截断，​​​使截断后的句子仅含前k​​​​​​个单词。返回截断s​​​​​​后得到的句子。

示例1：

输入：s = "Hello how are you Contestant", k = 4
输出："Hello how are you"
解释：
s中的单词为["Hello", "how" "are", "you", "Contestant"]
前4个单词为["Hello", "how", "are", "you"]
因此，应当返回"Hello how are you"

示例2：

输入：s = "What is the solution to this problem", k = 4
输出："What is the solution"
解释：
s中的单词为["What", "is" "the", "solution", "to", "this", "problem"]
前4个单词为["What", "is", "the", "solution"]
因此，应当返回"What is the solution"

示例3：

输入：s = "chopper is not a tanuki", k = 5
输出："chopper is not a tanuki"

提示：

1 <= s.length <= 500
k的取值范围是[1, s中单词的数目]
s仅由大小写英文字母和空格组成
s中的单词之间由单个空格隔开
不存在前导或尾随空格
```

## 代码

- 语言：Java

```
class Solution {

    public String truncateSentence(String s, int k) {
        // 模拟法

        // 以空格切割单词为字符串数组
        String[] strs = s.split(" ");

        // 定义字符串集合，保存结果
        StringBuilder sb = new StringBuilder();

        // 从0遍历到k-1，取前k个单词
        for (int i = 0; i < k; ++i) {
            sb.append(strs[i]);
            
            // 处理最后一个单词，最后一个单词没有空格
            if (i < k - 1) {
                sb.append(" ");
            }
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
```