## 源码路径

/src/main/java/org/pure/algorithm/palindromeNum/Main.java

## 题目地址(回文数)

https://leetcode-cn.com/problems/palindrome-number

## 题目描述

```
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例1:

输入: 121
输出: true

示例2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶：

你能不将整数转为字符串来解决这个问题吗？
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int n = x;
            int sum = 0;
            // 得到反转后的数
            while (x > 0) {
                int m = x % 10;
                sum = sum * 10 + m;
                x = x / 10;
            }
            return n == sum;
        }
    }

}
```