## 源码路径

/src/main/java/org/pure/algorithm/uglyNumber/Main.java

## 题目地址(丑数)

https://leetcode-cn.com/problems/ugly-number

## 题目描述

```
编写一个程序判断给定的数是否为丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例1:

输入: 6
输出: true
解释: 6 = 2 × 3

示例2:

输入: 8
输出: true
解释: 8 = 2 × 2 × 2

示例3:

输入: 14
输出: false 
解释: 14 不是丑数，因为它包含了另外一个质因数 7

提示：

1.1 是丑数。
2.输入不会超过 32 位有符号整数的范围: [−2^31,  2^31 − 1]。
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isUgly(int num) {
        if (num <= 0) {
            // 丑数都是正整数
            return false;
        } else if (num == 1) {
            // 1是丑数
            return true;
        } else {
            // 先判断一次能否整除2、3、5
            int n = divide(num);

            if (n == -1) {
                // 若返回-1，则不能整除2、3、5，不是丑数
                return false;
            } else if (n == 1) {
                // 若结果为1，则是丑数
                return true;
            }

            // 循环判断
            while (n > 1) {
                // 除2、3、5
                n = divide(n);

                if (n == -1) {
                    // 若返回-1，则不能整除2、3、5，不是丑数
                    return false;
                }
            }

            return true;
        }
    }

    // 除2、3、5
    private int divide(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else if (n % 3 == 0) {
            return n / 3;
        } else if (n % 5 == 0) {
            return n / 5;
        } else {
            return -1;
        }
    }

}
```