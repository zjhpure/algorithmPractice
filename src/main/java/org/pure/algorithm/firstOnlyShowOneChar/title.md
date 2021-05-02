## 源码路径

/src/main/java/org/pure/algorithm/firstOnlyShowOneChar/Main.java

## 题目地址(第一个只出现一次的字符)

https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof

## 题目描述

```
给在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例1:

s = "abaccdeff"
返回 "b"

示例2:

s = "" 
返回 " "

限制:

0 <= s 的长度 <= 50000
```

## 代码

- 语言：Java

```
class Solution {

    public char firstUniqChar(String s) {
        // 定义有序集合map，保存每种字符出现的次数
        Map<Character, Integer> map = new LinkedHashMap<>();

        // 遍历字符串s的字符
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                // 如果字符在集合map中已存在，数量加1
                map.put(c, map.get(c) + 1);
            } else {
                // 如果字符在集合map中不存在，添加到集合map中，数量为1
                map.put(c, 1);
            }
        }
        
        // 遍历有序集合map
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 如果找到有字符出现的次数为1，那么此字符就是第一个只出现一次的字符
                return entry.getKey();
            }
        }
        
        // 如果没有找到有字符出现的次数为1，那么就是没有只出现一次的字符，返回单空格
        return ' ';
    }

}
```