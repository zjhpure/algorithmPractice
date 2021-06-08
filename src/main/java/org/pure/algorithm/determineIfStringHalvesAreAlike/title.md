## 源码路径

/src/main/java/org/pure/algorithm/determineIfStringHalvesAreAlike/Main.java

## 题目地址(判断字符串的两半是否相似)

https://leetcode-cn.com/problems/determine-if-string-halves-are-alike

## 题目描述

```
给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。

两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。

如果 a 和 b 相似，返回 true ；否则，返回 false 。

示例1:

输入：s = "book"
输出：true
解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。

示例2:

输入：s = "textbook"
输出：false
解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
注意，元音 o 在 b 中出现两次，记为 2 个。

示例3:

输入：s = "MerryChristmas"
输出：false

示例4:

输入：s = "AbCdEfGh"
输出：true

说明:

2 <= s.length <= 1000
s.length 是偶数
s 由 大写和小写 字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean halvesAreAlike(String s) {
        // 定义前一半元音数量
        int preCount = 0;
        // 定义后一半元音数量
        int lastCount = 0;

        // 遍历字符串s的字符，使用双指针，从两边往中间遍历，因为字符串长度都是偶数，所以刚好会切分成两半
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (isContains(s.charAt(i))) {
                // 若包含元音，前一半元音数量加1
                ++preCount;
            }

            if (isContains(s.charAt(j))) {
                // 若包含元音，后一半元音数量加1
                ++lastCount;
            }
        }

        return preCount == lastCount;
    }

    // 判断是否包含元音
    private boolean isContains(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E': 
            case 'I':
            case 'O':
            case 'U':
                return true;
        }

        return false;
    }

}
```