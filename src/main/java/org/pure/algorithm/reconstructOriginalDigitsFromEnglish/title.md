## 源码路径

/src/main/java/org/pure/algorithm/reconstructOriginalDigitsFromEnglish/Main.java

## 题目地址(从英文中重建数字)

https://leetcode-cn.com/problems/reconstruct-original-digits-from-english

## 题目描述

```
给你一个字符串s，其中包含字母顺序打乱的用英文单词表示的若干数字(0-9)。按升序返回原始的数字。

示例1：

输入：s = "owoztneoer"
输出："012"

示例2：

输入：s = "fviefuro"
输出："45"

提示：

1 <= s.length <= 10^5
s[i]为["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]这些字符之一
s保证是一个符合题目要求的字符串
```

## 代码

- 语言：Java

```
class Solution {

    public String originalDigits(String s) {
        //  哈希表+计数排序

        // 定义哈希表，用来统计每种字符出现的次数
        Map<Character, Integer> map = new HashMap<>();

        // 遍历字符串的字符，统计每种字符出现的次数
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // zero、one、two、three、four、five、six、seven、eight、nine
        // 各类字符落到的数字上
        // e：0 1 3 5 7 8 9 
        // g：8
        // f：4 5 
        // i：5 6 8 9 
        // h：3 8 
        // o：0 1 2 4 
        // n：1 7 9 
        // s：6 7 
        // r：0 3 4 
        // u：4 
        // t：2 3 8 
        // w：2 
        // v：5 7 
        // x：6 
        // z：0

        // 定义数组，保存0-9数字有多少个，利用计数排序的原理，因为这里的数字范围很小，只有0-9，所以把每一个数字的数量统计出来，就相当于进行了排序
        int[] cnt = new int[10];

        // 只在一个数字出现的字符，这个字符的个数就是数字的个数
        cnt[0] = map.getOrDefault('z', 0);
        cnt[2] = map.getOrDefault('w', 0);
        cnt[4] = map.getOrDefault('u', 0);
        cnt[6] = map.getOrDefault('x', 0);
        cnt[8] = map.getOrDefault('g', 0);

        // 在两个数字出现的字符，把这个字符的个数减去另一个已知数字的个数
        cnt[3] = map.getOrDefault('h', 0) - cnt[8];
        cnt[5] = map.getOrDefault('f', 0) - cnt[4];
        cnt[7] = map.getOrDefault('s', 0) - cnt[6];

        // 在四个数字出现的字符，把这个字符的个数减去另三个已知数字的个数
        cnt[1] = map.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        // 计算剩下的数字9的个数，挑选i字符的个数减去另三个已知数字的个数
        cnt[9] = map.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        // 定义字符串集合，保存升序的数字
        StringBuilder sb = new StringBuilder();

        // 遍历数字的范围，从0-9，进行升序排序
        for (int i = 0; i < 10; ++i) {
            // 根据这种数字的数量，添加到字符串集合
            for (int j = 0; j < cnt[i]; ++j) {
                sb.append((char) (i + '0'));
            }
        }
        
        // 返回字符串集合，即为升序的数字
        return sb.toString();
    }

}
```