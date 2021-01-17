## 源码路径

/src/main/java/org/pure/algorithm/longestSubstring/Main.java

## 题目地址(无重复字符的最长子串)

https://leetcode-cn.com/problems/longest-substring-without-repeating-characters

## 题目描述

```
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

示例4:

输入: s = ""
输出: 0

提示：

0 <= s.length <= 5 * 10^4
s 由英文字母、数字、符号和空格组成
```

## 代码

- 语言：Java

```
class Solution {

    /**
     * 方法1：两个for循环完成
     */
    public int lengthOfLongestSubstring(String s) {
        // 最长字串长度
        int size = 0;

        if (s != null && !"".equals(s) && s.length() > 0) {
            // 最长字串列表
            List<Character> charList = new ArrayList<>();

            // 遍历i次，获得i次最长字串长度
            for (int i = 0; i <= s.length() - 1; ++i) {
                // 构造最长字串列表
                for (int j = i; j <= s.length() - 1; ++j) {
                    char c = s.charAt(j);

                    // 判断字符是否在最长字串列表中
                    if (charList.contains(c)) {
                        break;
                    } else {
                        charList.add(c);
                    }
                }

                // 更新最长字串长度
                if (charList.size() > size) {
                    size = charList.size();
                }

                // 字串列表清空元素
                charList.clear();
            }
        }

        return size;
    }

}
```

```
class Solution {

    /**
     * 方法2：一个for循环完成
     */
    public int lengthOfLongestSubstring(String s) {
        // 最长字串长度
        int size = 0;

        if (s != null && !"".equals(s) && s.length() > 0) {
            // 字串集合
            Map<Character, Integer> map = new HashMap<>();

            // 起始索引
            int start = 0;

            // 遍历字符串
            for (int i = 0; i <= s.length() - 1; ++i) {
                char c = s.charAt(i);

                // 判断字符是否在字串集合中
                if (map.containsKey(c)) {
                    int index = map.get(c) + 1;

                    // 更新起始索引
                    if (index > start) {
                        start = index;
                    }
                }

                // 获取当前最长字串长度
                int length = i - start + 1;

                // 更新最长字串长度
                if (length > size) {
                    size = length;
                }

                map.put(c, i);
            }
        }

        return size;
    }

}
```