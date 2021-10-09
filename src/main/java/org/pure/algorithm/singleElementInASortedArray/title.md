## 源码路径

/src/main/java/org/pure/algorithm/singleElementInASortedArray/Main.java

## 题目地址(有序数组中的单一元素)

https://leetcode-cn.com/problems/single-element-in-a-sorted-array

## 题目描述

```
给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

示例1:

输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2

示例2:

输入: nums = [3,3,7,7,10,11,11]
输出: 10

提示：

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

进阶: 

采用的方案可以在O(logn)时间复杂度和O(1)空间复杂度中运行吗？
```

## 代码

- 语言：Java

```
class Solution {

    public int singleNonDuplicate(int[] nums) {
        // 位运算法，相同的两个整数进行异或运算等于0，0和任何其他整数进行异或运算等于其他整数本身，只出现两次的整数通过异或运算都等于0，而0和0异或也等于0，最后剩下只出现一次的整数

        // 定义累计异或运算的结果
        int result = 0;

        // 遍历数组，累计异或运算
        for (int num : nums) {
            // 累计异或运算，抵消掉只出现两次的整数，最后剩下只出现一次的整数
            result ^= num;
        }

        // 返回累计异或运算的结果，累计异或运算的结果就是只出现一次的整数
        return result;
    }

}
```