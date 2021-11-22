## 源码路径

/src/main/java/org/pure/algorithm/buddyStrings/Main.java

## 题目地址(亲密字符串)

https://leetcode-cn.com/problems/buddy-strings

## 题目描述

```
给你两个字符串s和goal，只要我们可以通过交换s中的两个字母得到与goal相等的结果，就返回true；否则返回false。

交换字母的定义是：取两个下标i和j(下标从0开始)且满足i != j，接着交换s[i]和s[j]处的字符。

例如，在"abcd"中交换下标0和下标2的元素可以生成"cbad"。

示例1：

输入：s = "ab", goal = "ba"
输出：true
解释：你可以交换s[0] = 'a'和s[1] = 'b'生成"ba"，此时s和goal相等。

示例2：

输入：s = "ab", goal = "ab"
输出：false
解释：你只能交换s[0] = 'a'和s[1] = 'b'生成"ba"，此时s和goal不相等。

示例3：

输入：s = "aa", goal = "aa"
输出：true
解释：你可以交换s[0] = 'a'和s[1] = 'a'生成"aa"，此时s和goal相等。

示例4：

输入：s = "aaaaaaabc", goal = "aaaaaaacb"
输出：true

提示:

1 <= s.length, goal.length <= 2 * 10^4
s和goal由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean buddyStrings(String a, String b) {
        // 枚举法，三种情况，注意审题，是只交换两个字母一次，不是交换两个字母多次，而且必须要交换，不能不进行交换

        if (a.length() != b.length()) {
            // 情况1：若两个字符串的长度不同，无论怎么交换两个字符都不可能相等，直接返回false
            return false;
        }

        if (a.equals(b)) {
            // 情况2：若两个字符串相等，只要字符串存在重复字符，那么就能在交换字符后还是两个字符串相等

            // 定义集合，统计字符串a每种字符的数量
            Map<Character, Integer> map = new HashMap<>();

            // 遍历字符串a的字符，统计每种字符的数量
            for (int i = 0; i < a.length(); ++i) {
                map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
            }

            // 遍历集合
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    // 若有一种字符的数量大于等于2，那么存在重复字符，可以交换这两个字符后是的两个字符串依然相等，返回true
                    return true;
                }
            }

            // 若没有有一种字符的数量大于等于2，那么不存在重复字符，那么交换两个字符后必定导致两个字符串不相等，返回false
            return false;
        } else {
            // 情况3：若两个字符串不相等，判断字符串a是否和字符串b只有两处字符不同，并且这两处字符是否交换后相等

            // 统计不同字符的数量
            int count = 0;
            // 定义第一个不同字符的下标
            int first = -1;
            // 定义第二个不同字符的下标
            int second = -1;

            // 遍历字符串a的字符
            for (int i = 0; i < a.length(); ++i) {
                if (a.charAt(i) != b.charAt(i)) {
                    // 若字符串a和字符串b相同下标的字符不等，不同字符的数量加1
                    ++count;

                    if (count == 1) {
                        // 获得第一个不同字符的下标
                        first = i;
                    } else if (count == 2) {
                        // 获得第二个不同字符的下标
                        second = i;
                    } else {
                        // 若有第三个不同字符，直接返回false
                        return false;
                    }
                }
            }

            // 最后判断交换两个不同字符的下标在两个字符串中交叉比较对应的值是否相等，若相等返回true，否则返回false
            return first != -1 && second != -1 && a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
        }
    }

}
```