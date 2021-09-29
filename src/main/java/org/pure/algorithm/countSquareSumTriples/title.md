## 源码路径

/src/main/java/org/pure/algorithm/countSquareSumTriples/Main.java

## 题目地址(统计平方和三元组的数目)

https://leetcode-cn.com/problems/count-square-sum-triples

## 题目描述

```
一个平方和三元组(a,b,c)指的是满足a2 + b2 = c2的整数三元组a，b和c。

给你一个整数n，请你返回满足1 <= a, b, c <= n的平方和三元组的数目。

示例1:

输入：n = 5
输出：2
解释：平方和三元组为(3,4,5)和(4,3,5)。

示例2:

输入：n = 10
输出：4
解释：平方和三元组为(3,4,5)，(4,3,5)，(6,8,10)和(8,6,10)。

提示:

1 <= n <= 250
```

## 代码

- 语言：Java

```
class Solution {

    public int countTriples(int n) {
        // 枚举法

        // 定义数目
        int count = 0;

        // 从1开始遍历到n，枚举a
        for (int a = 1; a <= n; ++a) {
            // 从1开始遍历到n，枚举b
            for (int b = 1; b <= n; ++b) {
                // 通过以下的判断，减少第三层for循环的判断，不需要再通过第三层的for循环来枚举c
                // 满足条件的肯定a不等于b，因为如果a等于b，a^2+b^2的开方肯定不是一个整数
                if (a != b) {
                    // 计算a^2+b^2的开方，对结果取整，假设是结果是c
                    int c = (int)(Math.sqrt(a * a + b * b));
                    // 判断结果c是否落在小于等于n的范围内，并且是否符合a^2+b^2=c^2
                    if (c <= n && a * a + b * b == c * c) {
                        count++;
                    }
                }
            }
        }

        // 返回数目
        return count;
    }

}
```