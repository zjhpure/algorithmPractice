## 源码路径

/src/main/java/org/pure/algorithm/singleNumber/Main.java

## 题目地址(只出现一次的数字)

https://leetcode-cn.com/problems/single-number

## 题目描述

```
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例1:

输入: [2,2,1]
输出: 1

示例2:

输入: [4,1,2,1,2]
输出: 4
```

## 代码

- 语言：Java

```
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        // 把全部数进行异或运算，最后结果就是只出现一次的元素
        // 因为两个相同数异或为0，0和任何数异或是任何数本身，这里刚好一个元素只出现一次的元素，其他元素都是出现两次
        // 而异或运算符合交换律和结合律，所以等于把所以两两出现的元素刚好抵消成0，最后剩下0异或只出现一次的元素，就是这个元素本身
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
```