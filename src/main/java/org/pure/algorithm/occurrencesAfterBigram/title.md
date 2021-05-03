## 源码路径

/src/main/java/org/pure/algorithm/occurrencesAfterBigram/Main.java

## 题目地址(Bigram分词)

https://leetcode-cn.com/problems/occurrences-after-bigram

## 题目描述

```
给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。

对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

示例1:

输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
输出：["girl","student"]

示例2:

输入：text = "we will we will rock you", first = "we", second = "will"
输出：["we","rock"]

提示:

1.1 <= text.length <= 1000
2.text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
3.1 <= first.length, second.length <= 10
4.first 和 second 由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        // 定义列表list，保存第三个词
        List<String> list = new ArrayList<>();

        // 切割字符串text，得到字符串数组strs
        String[] strs = text.split(" ");

        // 遍历字符串数组strs，从第一个元素遍历到倒数第三个元素
        for (int i = 0; i < strs.length - 2; ++i) {
            if (first.equals(strs[i]) && second.equals(strs[i + 1])) {
                // 如果出现当前元素等于first，下一个元素等于second，那么符合条件，下两个元素就是第三个词，把它添加到列表list中
                list.add(strs[i + 2]);
            }
        }

        // 列表list转为数组
        return list.toArray(new String[0]);
    }

}
```