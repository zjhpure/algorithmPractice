## 源码路径

/src/main/java/org/pure/algorithm/uglyNumber2/Main.java

## 题目地址(丑数II)

https://leetcode-cn.com/problems/ugly-number-ii

## 题目描述

```
给你一个整数n，请你找出并返回第n个丑数 。

丑数就是只包含质因数2、3或5的正整数。

示例1:

输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12]是由前10个丑数组成的序列。

示例2:

输入：n = 1
输出：1
解释：1通常被视为丑数。

提示：

1 <= n <= 1690
```

## 代码

- 语言：Java

```
class Solution {

    public int nthUglyNumber(int n) {
        // 此方法直接沿用之前判断丑数的解题思路，从1遍历n-1，遍历时调用之前判断丑数的函数，若是丑数数量加1，若数量达到了n个，结束循环，返回当前的数字，此数字正是第n个丑数，但是此方法耗时多，提交后运行超时，不能使用

        // 丑数，第一个为1
        int i = 1;

        // 丑数个数
        int count = 1;
        
        while (count < n) {
            ++i;
            if (isUgly(i)) {
                // 若找到丑数，丑数个数加1
                ++count;
            }
        }

        return i;
    }

    // 判断是否为丑数
    private boolean isUgly(int num) {
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