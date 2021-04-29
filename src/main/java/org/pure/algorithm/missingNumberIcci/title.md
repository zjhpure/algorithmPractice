## 源码路径

/src/main/java/org/pure/algorithm/missingNumberIcci/Main.java

## 题目地址(消失的数字)

https://leetcode-cn.com/problems/missing-number-lcci

## 题目描述

```
数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？

示例1:

输入：[3,0,1]
输出：2

示例2:

输入：[9,6,4,2,3,5,7,0,1]
输出：8
```

## 代码

- 语言：Java

```
class Solution {

    public int missingNumber(int[] nums) {
        // 数组nums的长度即为n
        int n = nums.length;
        // 计算从0到n的总和，总和=(首项+末项)*数量/2
        int sum = n * (n + 1) / 2;

        // 遍历数组nums
        for (int num : nums) {
            // 总和每次减去数组nums的元素
            sum -= num;
        }

        // 最后剩下的就是缺失的数字
        return sum;
    }

}
```