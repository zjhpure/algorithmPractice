## 源码路径

/src/main/java/org/pure/algorithm/threeDivisors/Main.java

## 题目地址(三除数)

https://leetcode-cn.com/problems/three-divisors

## 题目描述

```
给你一个整数n。如果n恰好有三个正除数，返回true；否则，返回false。

如果存在整数k，满足n = k * m，那么整数m就是n的一个除数。

示例1:

输入：n = 2
输出：false
解释：2只有两个除数：1和2。

示例2:

输入：n = 4
输出：true
解释：4有三个除数：1、2和4。

提示:

1 <= n <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isThree(int n) {
        // 定义除数个数
        int count = 0;

        // 从1遍历到n的开方
        for (int i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                // 若能除尽，那么符合除数条件
                if (n / i == i) {
                    // 若结果和除数相等，那么刚好是n的开方，除数只有一个，除数个数加1，比如49=7*7
                    ++count;
                } else {
                    // 若结果和除数不相等，那么结果落到大于n的开方那一侧，刚好是两个除数的组合，除数个数加2，比如10=2*5，当i=2时，对应5
                    count += 2;
                }
                if (count > 3) {
                    // 若除数大于了3个，个数超过，不符合条件，马上返回false
                    return false;
                }
            }
        }

        // 遍历结束后，判断除数个数是否恰好3个
        return count == 3;
    }

}
```