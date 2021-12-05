## 源码路径

/src/main/java/org/pure/algorithm/ransomNote/Main.java

## 题目地址(赎金信)

https://leetcode-cn.com/problems/ransom-note

## 题目描述

```
为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。

给你一个赎金信(ransomNote)字符串和一个杂志(magazine)字符串，判断ransomNote能不能由magazines里面的字符构成。

如果可以构成，返回true；否则返回false。

magazine中的每个字符只能在ransomNote中使用一次。

示例1：

输入：ransomNote = "a", magazine = "b"
输出：false

示例2：

输入：ransomNote = "aa", magazine = "ab"
输出：false

示例3：

输入：ransomNote = "aa", magazine = "aab"
输出：true

提示：

1 <= ransomNote.length, magazine.length <= 105
ransomNote和magazine由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        // 计数统计

        // 若赎金信字符串的长度和杂志字符串的长度不等，直接不符合条件，返回false
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 定义数组，长度为26，保存字符串中每一个字符的数量
        int[] cnt = new int[26];

        // 遍历杂志字符串的字符，统计每一个字符的数量，使用计数统计的方法
        for (char c : magazine.toCharArray()) {
            ++cnt[c - 'a'];
        }

        // 遍历赎金信字符串的字符，同样使用计数统计的方法，但是数量递减
        for (char c : ransomNote.toCharArray()) {
            --cnt[c - 'a'];

            if (cnt[c - 'a'] < 0) {
                // 若数量出现了小于0的，证明赎金信字符串的这个字符数量大于杂志社字符串的这个字符数量，不符合条件，返回false
                return false;
            }
        }

        // 若程序能走到最后，证明赎金信字符串的每个字符数量都小于等于杂志社字符串的每个字符数量，符合条件，返回true
        return true;
    }

}
```