## 源码路径

/src/main/java/org/pure/algorithm/validAnagram/Main.java

## 题目地址(有效的字母异位词)

https://leetcode-cn.com/problems/valid-anagram

## 题目描述

```
给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词。

示例1:

输入: s = "anagram", t = "nagaram"
输出: true

示例2:

输入: s = "rat", t = "car"
输出: false

注意:
1 <= s.length, t.length <= 5 * 10^4
s和t仅包含小写字母
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            // 若字符串s和字符串t的长度不同，肯定不是字母异位词，返回false
            return false;
        }

        // 思路：用集合map保存字符串s的字符的数量，遍历字符串t时集合map中的字符数量减1，若有集合map中不存在的字符，不是字母异位词，遍历完字符串t，若集合map中的字符数量全部变为0，那么就是字母异位词，否则不是字母异位词

        // 定义集合map，保存字符串s各个字符的数量
        Map<Character, Integer> map = new HashMap<>();

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            // 保存字符的数量到集合map中，若集合map中不存在此字符的key，数量保存为1
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 遍历字符串t的字符
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                // 若集合map中存在key，数量减1
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    // 若集合map中的key的数量小于0，那么字符串s和字符串t中的此字符数量不相等，不是字母异位词，返回false
                    return false;
                }
            } else {
                // 若集合map中不存在key，那么不是字母异位词，返回false
                return false;
            }
        }

        // 遍历集合map
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                // 只要有一个key的数量大于0，那么字符串s和字符串t中就存在数量不相等字符，返回false
                return false;
            }
        }

        // 遍历结束，证明字符串s和字符串t中的所有字符的数量相等，返回true
        return true;
    }

}
```