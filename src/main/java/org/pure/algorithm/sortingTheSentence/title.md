## 源码路径

/src/main/java/org/pure/algorithm/sortingTheSentence/Main.java

## 题目地址(将句子排序)

https://leetcode-cn.com/problems/sorting-the-sentence

## 题目描述

```
一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。

我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。

比方说，句子 "This is a sentence" 可以被打乱顺序得到 "sentence4 a3 is2 This1" 或者 "is2 sentence4 This1 a3" 。
给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。

示例1:

输入：s = "is2 sentence4 This1 a3"
输出："This is a sentence"
解释：将 s 中的单词按照初始位置排序，得到 "This1 is2 a3 sentence4" ，然后删除数字。

示例2:

输入：s = "Myself2 Me1 I4 and3"
输出："Me Myself and I"
解释：将 s 中的单词按照初始位置排序，得到 "Me1 Myself2 and3 I4" ，然后删除数字。

提示：

2 <= s.length <= 200
s 只包含小写和大写英文字母、空格以及从 1 到 9 的数字。
s 中单词数目为 1 到 9 个。
s 中的单词由单个空格分隔。
s 不包含任何前导或者后缀空格。
```

## 代码

- 语言：Java

```
class Solution {

    public String sortSentence(String s) {
        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 定义字符串数组strs，通过切割字符串s获取字符串数组strs
        String[] strs = s.split(" ");

        // 定义整数数组arrays，记录字符串数组strs每个元素的索引
        int[] arrays = new int[strs.length];

        // 定义集合map，记录字符串数组strs里每个索引对应的元素
        Map<Integer, String> map = new HashMap<>();

        // 遍历字符串数组strs，构造整数数组arrays和集合map
        for (int i = 0; i < strs.length; ++i) {
            // 取字符串数组strs的元素
            String str = strs[i];

            // 取元素的最后一个字符为索引，保存到整数数组arrays中
            arrays[i] = Integer.parseInt(str.substring(str.length() - 1));

            // 保存索引和元素到集合map中
            map.put(arrays[i], str.substring(0, str.length() - 1));
        }

        // 对整数数组arrays进行排序
        Arrays.sort(arrays);

        // 遍历整数数组arrays，构造字符串集合sb
        for (int i = 0; i < arrays.length; ++i) {
            // 以整数数组arrays的元素作为key值，获取集合map中的元素
            sb.append(map.get(arrays[i]));

            if (i < arrays.length - 1) {
                // 判断若不是最后一个元素，添加空格
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
```