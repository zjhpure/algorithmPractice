## 源码路径

/src/main/java/org/pure/algorithm/addDigits/Main.java

## 题目地址(各位相加)

https://leetcode-cn.com/problems/add-digits

## 题目描述

```
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例1:

输入: 38
输出: 2 
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。

进阶:

你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
```

## 代码

- 语言：Java

```
class Solution {

    public int addDigits(int num) {
        // 通过整数num除以10是否大于0判断整数num是否为一位数
        while (num / 10 > 0) {
            // 若整数num不是一位数，计算各位相加的和
            num = getPositionSum(num);
        }

        // 若是整数num是一位数，则返回整数num作为结果
        return num;
    }

    // 计算各位相加的和
    private int getPositionSum(int num) {
        // 定义各位相加的和
        int sum = 0;

        while (num > 0) {
            // 通过整数num对10取余获取数位上的值
            int res = num % 10;
            // 累加数位上的值
            sum += res;
            // 整数num除以10减少一位
            num = num / 10;
        }

        return sum;
    }

}
```