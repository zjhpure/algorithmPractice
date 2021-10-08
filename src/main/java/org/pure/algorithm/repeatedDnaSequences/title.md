## 源码路径

/src/main/java/org/pure/algorithm/repeatedDnaSequences/Main.java

## 题目地址(重复的DNA序列)

https://leetcode-cn.com/problems/repeated-dna-sequences

## 题目描述

```
所有DNA都由一系列缩写为'A'，'C'，'G'和'T'的核苷酸组成，例如："ACGAATTCCG"。在研究DNA时，识别DNA中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为10，且在DNA字符串s中出现次数超过一次。

示例1:

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]

示例2:

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]

提示：

0 <= s.length <= 10^5
s[i]为'A'、'C'、'G'或'T'
```

## 代码

- 语言：Java

```
class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        // 定义列表，保存所有目标子串
        List<String> list = new ArrayList<>();

        // 定义集合，保存所有长度为10的子串的个数
        Map<String, Integer> map = new HashMap<>();

        // 遍历字符串s所有长度为10的子串的个数
        for (int i = 0; i <= s.length() - 10; ++i) {
            // 往后取10个字符，组成以i下标开头的长度为10的子串
            String sub = s.substring(i, i + 10);
            // 保存个数到集合中
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            // 若个数达到了2，那么就是目标子串了，保存到列表中(注意：这里不使用大于等于2去判断，因为目标子串只保存一个到列表中)
            if (map.get(sub) == 2) {
                list.add(sub);
            }
        }

        // 返回目标子串
        return list;
    }

}
```