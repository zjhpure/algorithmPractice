## 源码路径

/src/main/java/org/pure/algorithm/subtractProductAndSum/Main.java

## 题目地址(整数的各位积和之差)

https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer

## 题目描述

```
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

示例1:

输入：n = 234
输出：15 
解释：
各位数之积 = 2 * 3 * 4 = 24 
各位数之和 = 2 + 3 + 4 = 9 
结果 = 24 - 9 = 15

示例2:

输入：n = 4421
输出：21
解释： 
各位数之积 = 4 * 4 * 2 * 1 = 32 
各位数之和 = 4 + 4 + 2 + 1 = 11 
结果 = 32 - 11 = 21

提示:

1 <= n <= 10^5
```

## 代码

- 语言：Java

```
class Solution {

    public int subtractProductAndSum(int n) {
        // 各位数之积
        int product = 1;

        // 各位数之和
        int sum = 0;

        // 循环获取整数n各位数字
        while (n > 0) {
            // 通过对10取余获取各位数字
            int num = n % 10;

            // 计算累加值
            product *= num;

            // 计算累积值
            sum += num;

            // 通过除以10降一位
            n = n / 10;
        }

        return product - sum;
    }

}
```