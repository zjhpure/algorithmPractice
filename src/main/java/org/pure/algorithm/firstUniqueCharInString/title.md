## 源码路径

/src/main/java/org/pure/algorithm/firstUniqueCharInString/Main.java

## 题目地址(字符串中的第一个唯一字符)

https://leetcode-cn.com/problems/first-unique-character-in-a-string

## 题目描述

```
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例:

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2

提示:你可以假定该字符串只包含小写字母。
```

## 代码

- 语言：Java

```
class Solution {

    public int firstUniqChar(String s) {
        // 定义集合map，记录每种字符的数量
        Map<Character, Integer> map = new LinkedHashMap<>();

        // 遍历字符串s
        for (int i = 0; i < s.length(); ++i) {
            // 获取字符
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                // 若字符在集合map中有出现，更新集合map中字符的数量
                map.put(c, map.get(c) + 1);
            } else {
                // 若字符在集合map中没出现，往集合map中推进字符，数量为1
                map.put(c, 1);
            }
        }

        // 遍历map集合
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 若字符的数量为1，这就是第一个唯一字符，返回此字符在字符串s中第一个位置的索引
                return s.indexOf(entry.getKey());
            }
        }

        // 若没有字符的数量为1，就是没有唯一字符，返回-1
        return -1;
    }

}
```