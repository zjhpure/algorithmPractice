## 源码路径

/src/main/java/org/pure/algorithm/isomorphicStrings/Main.java

## 题目地址(同构字符串)

https://leetcode-cn.com/problems/isomorphic-strings

## 题目描述

```
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

示例1:

输入：s = "egg", t = "add"
输出：true

示例2:

输入：s = "foo", t = "bar"
输出：false

示例3:

输入：s = "paper", t = "title"
输出：true

提示：

可以假设 s 和 t 长度相同。
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isIsomorphic(String s, String t) {
        // 定义集合map，保存字符的映射关系
        Map<Character, Character> map = new HashMap<>();

        // 遍历字符串s和字符串t的字符
        for (int i = 0; i < s.length(); ++i) {
            // 获取字符串s的字符
            char a = s.charAt(i);
            // 获取字符串t的字符
            char b = t.charAt(i);

            if (map.containsKey(a)) {
                // 若集合map中存在key值，那么因为一个字符只有一种映射关系，所以判断对于的字符串t中的字符是否和前面映射的字符相等
                if (b != map.get(a)) {
                    // 若字符串t中的字符和前面映射的字符不相等，那么同一个字符映射关系就有多个了，两个字符串不是同构字符串，返回false
                    return false;
                }
            } else {
                // 若集合map中不存在key值，判断是否可以保存进集合map中
                if (!map.containsValue(b)) {
                    // 若集合map中不存在value值，那么映射关系是唯一的，保存进集合map中
                    map.put(a, b);
                } else {
                    // 若集合map中存在value值，因为不同字符不能映射到同一个字符上，所以两个字符串不是同构字符串，返回false
                    return false;
                }
            }
        }

        // 若能顺利遍历完，那么两个字符串是同构字符串
        return true;
    }

}
```