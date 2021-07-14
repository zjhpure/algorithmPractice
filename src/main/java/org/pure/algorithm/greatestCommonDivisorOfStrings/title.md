## 源码路径

/src/main/java/org/pure/algorithm/greatestCommonDivisorOfStrings/Main.java

## 题目地址(字符串的最大公因子)

https://leetcode-cn.com/problems/greatest-common-divisor-of-strings

## 题目描述

```
对于字符串S和T，只有在S = T + ... + T(T自身连接1次或多次)时，我们才认定“T能除尽S”。

返回最长字符串X，要求满足X能除尽str1且X能除尽str2。

示例1:

输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"

示例2:

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"

示例3:

输入：str1 = "LEET", str2 = "CODE"
输出：""

提示:

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1[i]和str2[i]为大写英文字母
```

## 代码

- 语言：Java

```
class Solution {

    public String gcdOfStrings(String str1, String str2) {
        // 思路：答案肯定是某个字符串的前缀，如果要满足最大公因子的条件，前缀的长度必须同时是两个字符串str1和str2的长度的约数

        // 获取字符串str1的长度
        int length1 = str1.length();
        // 获取字符串str2的长度
        int length2 = str2.length();
        
        // 求出字符串str1和字符串str2的较小长度，从较小长度遍历到1，从大到小遍历
        for (int i = Math.min(length1, length2); i >= 1; --i) {
            // 判断前缀的长度是否同时是两个字符串str1和str2的长度的约数
            if (length1 % i == 0 && length2 % i == 0) {
                // 获取前缀，用其中的一个字符串切割即可，因为最大范围已经限定在了较小长度里
                String str = str1.substring(0, i);

                if (judgeCommon(str, str1) && judgeCommon(str, str2)) {
                    // 若前缀和字符串str1、前缀和字符串str2都满足因子关系，那么字符串str1和字符串str2拥有公因子str，因为前缀的长度是从大到小遍历的，所以这里一旦找到符合条件的前缀，即可以返回结果str
                    return str;
                }
            }
        }

        // 若不能找到符合条件的前缀，返回空字符串
        return "";
    }

    // 定义判断是否满足字符串因子的函数
    private boolean judgeCommon(String t, String s) {
        // 因为字符串s等于多个字符串t相加，所以用字符串s的长度除以字符串t的长度，获取倍数length
        int length = s.length() / t.length();

        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 遍历倍数length次，每次字符串集合sb添加字符串t
        for (int i = 0; i < length; ++i) {
            sb.append(t);
        }

        // 最后若字符串集合sb刚好就等于字符串s，那么满足字符串t能除尽字符串s，即满足字符串t是字符串s的字符串因子的条件
        return s.equals(sb.toString());
    }

}
```