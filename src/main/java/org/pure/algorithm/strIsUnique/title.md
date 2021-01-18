## 源码路径

/src/main/java/org/pure/algorithm/strsUnique/Main.java

## 题目地址(判定字符是否唯一)

https://leetcode-cn.com/problems/is-unique-lcci

## 题目描述

```
实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

示例1:

输入: s = "leetcode"
输出: false 

示例2:

输入: s = "abc"
输出: true

限制：

0 <= len(s) <= 100
如果你不使用额外的数据结构，会很加分。
```

## 代码

- 语言：Java

```
class Main {

    public boolean isUnique(String astr) {
        // 第一次从第一个字符遍历到最后第二个字符
        for (int i = 0; i < astr.length() - 1; ++i) {
            // 第一次从第i+1个字符遍历到最后一个字符
            for (int j = i + 1; j < astr.length(); ++j) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    // 若有一对字符相同，那么所有字符不是全都不同
                    return false;
                }
            }
        }

        // 没有找到相同的，那么所有字符全都不同
        return true;
    }

}
```