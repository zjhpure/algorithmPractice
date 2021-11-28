## 源码路径

/src/main/java/org/pure/algorithm/findAllAnagramsInAString/Main.java

## 题目地址(找到字符串中所有字母异位词)

https://leetcode-cn.com/problems/find-all-anagrams-in-a-string

## 题目描述

```
给定两个字符串s和p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词指由相同字母重排列形成的字符串(包括相同的字符串)。

示例1：

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于0的子串是"cba", 它是"abc"的异位词。
起始索引等于6的子串是"bac", 它是"abc"的异位词。

示例2：

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于0的子串是"ab", 它是"ab"的异位词。
起始索引等于1的子串是"ba", 它是"ab"的异位词。
起始索引等于2的子串是"ab", 它是"ab"的异位词。

提示：

1 <= s.length, p.length <= 3 * 10^4
s和p仅包含小写字母
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        // 计数排序法

        // 定义列表，保存结果
        List<Integer> list = new ArrayList<>();

        if (p.length() > s.length()) {
            // 若字符串p的长度大于字符串s的长度，不能存在异位词，直接返回空列表
            return list;
        }

        // 定义长度为26的数组，保存字符串p中每个字符的个数
        int[] pCount = new int[26];

        // 遍历字符串p的字符
        for (int i = 0; i < p.length(); ++i) {
            // 计数排序统计各个字符的个数
            ++pCount[p.charAt(i) - 'a'];
        }

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            // 获取结束索引加1
            int endIndex = i + p.length();

            // 若结束索引加1小于等于字符串s的长度，那么进行异位词的判断
            if (endIndex <= s.length()) {
                // 获取起始索引
                int j = i;

                // 定义长度为26的数组，保存从起始索引到结束索引的每个字符的个数
                int[] sCount = new int[26];

                // 从起始索引的字符遍历到结束索引的字符
                while (j < endIndex) {
                    // 计数排序统计各个字符的个数
                    ++sCount[s.charAt(j) - 'a'];
                    ++j;
                }

                if (Arrays.equals(pCount, sCount)) {
                    // 若两个计数排序的数组相等，那么符合异位词的条件，添加起始索引到列表
                    list.add(i);
                }
            }
        }

        // 返回结果
        return list;
    }

}
```