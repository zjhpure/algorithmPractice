## 源码路径

/src/main/java/org/pure/algorithm/countPrimes/Main.java

## 题目地址(计数质数)

https://leetcode-cn.com/problems/count-primes

## 题目描述

```
统计所有小于非负整数 n 的质数的数量。

示例1:

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例2:

输入：n = 0
输出：0

示例2:

输入：n = 1
输出：0

提示:

0 <= n <= 5 * 10^6
```

## 代码

- 语言：Java

```
class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            // 若n小于3，结果为0
            return 0;
        } else {
            // 质数数量
            int num = 1;

            // 从3开始循环判断，每次自增2，因为偶数不是质数，不用判断
            for (int i = 3; i < n; i += 2) {
                // 是否为质数
                boolean isPrime = true;

                // 从3循环到这个数的平方根
                for (int j = 3; j * j <= i; j += 2) {
                    if (i % j == 0) {
                        // 若能被除尽，则不是质数
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    // 质数数量加1
                    ++num;
                }
            }

            return num;
        }
    }
}
```