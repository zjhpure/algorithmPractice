## 源码路径

/src/main/java/org/pure/algorithm/checkIfOneStringSwapCanMakeStringsEqual/Main.java

## 题目地址(仅执行一次字符串交换能否使两个字符串相等)

https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal

## 题目描述

```
给你长度相等的两个字符串s1和s2。一次字符串交换操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。

如果对其中一个字符串执行最多一次字符串交换 就可以使两个字符串相等，返回true；否则，返回false。

示例1:

输入：s1 = "bank", s2 = "kanb"
输出：true
解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"

示例2:

输入：s1 = "attack", s2 = "defend"
输出：false
解释：一次字符串交换无法使两个字符串相等

示例3:

输入：s1 = "kelb", s2 = "kelb"
输出：true
解释：两个字符串已经相等，所以不需要进行字符串交换

示例4:

输入：s1 = "abcd", s2 = "dcba"
输出：false

提示:

1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 和 s2 仅由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            // 若两个字符串相等，不用字符交换，直接返回true
            return true;
        }

        // 定义统计两个字符串同一下标字符不同的数量
        int count = 0;
        // 定义统计到的第一个字符的下标
        int m = -1;
        // 定义统计到的第二个字符的下标
        int n = -1;

        // 遍历字符串s1和s2的字符，题目已说明字符串s1和字符串s2的长度相等
        for (int i = 0; i < s1.length(); ++i) {
            // 比较两个字符串同一下标的字符是否相等
            if (s1.charAt(i) != s2.charAt(i)) {
                // 若两个字符串同一下标的字符相等，统计数量加1
                ++count;
                if (count == 1) {
                    // 若统计数量达到了1，第一个字符的下标为当前下标
                    m = i;
                } else if (count == 2) {
                     // 若统计数量达到了2，第二个字符的下标为当前下标
                    n = i;
                }
            }

            if (count > 2) {
                // 若统计数量大于2，肯定无法做到最多一次字符串交换就可以使两个字符串相等
                return false;
            }
        }

        // 最后先判断m和n是否都不等于-1了，如果还有等于-1的，那么统计数量小于2，返回false，如果m和n都不等于-1，那么刚好找到两个字符不同的下标m和n，在两个字符串中交叉下标对应的值是否相等，如果都相等，返回true，否则，返回false
        return m != -1 && n != -1 && s1.charAt(m) == s2.charAt(n) && s1.charAt(n) == s2.charAt(m);
    }

}
```