## 源码路径

/src/main/java/org/pure/algorithm/missingTwo/Main.java

## 题目地址(消失的两个数字)

https://leetcode-cn.com/problems/missing-two-lcci

## 题目描述

```
给定一个数组，包含从1到N所有的整数，但其中缺了两个数字。你能在O(N)时间内只用O(1)的空间找到它们吗？

以任意顺序返回这两个数字均可。

示例1:

输入: [1]
输出: [2,3]

示例2:

输入: [2,3]
输出: [1,4]

提示:

nums.length <= 30000
```

## 代码

- 语言：Java

```
class Solution {

    public int[] missingTwo(int[] nums) {
        // 思路：总和累减法，用总和累减法可以找出缺失的一个数字，而这里缺失的是两个数字，那么先用总和累减法找出缺失的两个数字的总和，总和除以2，确定切分的位置，切分为两部分后，两部分各缺失一个数字，第一部分再用总和累减法找出缺失的那个数字，再用原来缺失的两个数字的总和减去找到的这个缺失的数字得到另一个缺失的数字，即可找到缺失的两个数字，不过这种方法先要保证不能总和不能溢出

        // 定义整数长度，因为缺失两个数字，所以整数范围是数组长度加2
        int size = nums.length + 2;

        // 计算从1到n的总和，总和=(首项+末项)*数量/2
        int sum = (1 + size) * size / 2;

        // 遍历数组，总和累减数组的整数，最后得到缺失的两个数字的总和
        for (int num : nums) {
            sum -= num;
        }

        // 这时sum变成缺失的两个数字的总和

        // 缺失的两个数字的总和除以2，因为数字不重复，所以缺失的两个数字一个小于等于mid，另一个大于mid
        int mid = sum / 2;

        // 数组被切分为了两部分，两部分各分布一个缺失的数字

        // 计算第一部分的总和，即从1到mid的总和，总和=(首项+末项)*数量/2
        int sum1 = (1 + mid) * mid / 2;

        // 定义第一部分在数组中的总和
        int sumOfLessMid = 0;

        // 遍历数组，累加得到第一部分在数组中的总和
        for (int num : nums) {
            if (num <= mid) {
                // 小于等于mid的数字是符合条件的
                sumOfLessMid += num;
            }
        }

        // 第一部分中缺失的数字=第一部分的总和-第一部分在数组中的总和
        int one = sum1 - sumOfLessMid;
        // 第二部分中缺失的数字=缺失的两个数字的总和-第一部分中缺失的数字
        int two = sum - one;

        // 返回两个缺失的数字组成的数组
        return new int[]{one,two};
    }

}
```