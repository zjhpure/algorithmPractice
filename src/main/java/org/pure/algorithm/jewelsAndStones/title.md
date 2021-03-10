## 源码路径

/src/main/java/org/pure/algorithm/jewelsAndStones/Main.java

## 题目地址(宝石与石头)

https://leetcode-cn.com/problems/jewels-and-stones

## 题目描述

```
给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例1:

输入: J = "aA", S = "aAAbbbb"
输出: 3

示例2:

输入: J = "z", S = "ZZ"
输出: 0

注意：

S 和 J 最多含有50个字母。
 J 中的字符不重复。
```

## 代码

- 语言：Java

```
class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        // 定义宝石数量
        int count = 0;

        // 遍历石头中的字符
        for (int i = 0; i < stones.length(); ++i) {
            if (jewels.indexOf(stones.charAt(i)) > - 1) {
                // 若宝石字符串中找到石头字符，那么石头字符是宝石，宝石数量加1
                ++count;
            }
        }

        return count;
    }

}
```