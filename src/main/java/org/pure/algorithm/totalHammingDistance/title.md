## 源码路径

/src/main/java/org/pure/algorithm/totalHammingDistance/Main.java

## 题目地址(汉明距离总和)

https://leetcode-cn.com/problems/total-hamming-distance

## 题目描述

```
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。

示例1:

输入: 4, 14, 2

输出: 6

解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

注意:
数组中元素的范围为从 0到 10^9。
数组的长度不超过 10^4。
```

## 代码

- 语言：Java

```
class Solution {

    public int totalHammingDistance(int[] nums) {
        // 定义汉明距离总和
        int sum = 0;

        // 两层遍历找出数组nums所有两个元素之间的组合
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                // 计算两个数的汉明距离，汉明距离就是两个数的位不同的个数之和，先把两个数进行异或运算，因为位不同异或运算会得到1，所以也就是统计异或运算后的这个数的位为1的个数，调用函数bitCount，统计位为1的个数
                sum += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }

        return sum;
    }

}
```