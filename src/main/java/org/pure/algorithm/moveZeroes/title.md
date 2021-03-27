## 源码路径

/src/main/java/org/pure/algorithm/moveZeroes/Main.java

## 题目地址(移动零)

https://leetcode-cn.com/problems/move-zeroes

## 题目描述

```
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

说明：

1.必须在原数组上操作，不能拷贝额外的数组。
2.尽量减少操作次数。
```

## 代码

- 语言：Java

```
class Solution {

    public void moveZeroes(int[] nums) {
        // 定义非0数字索引
        int j = 0;

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                // 对非0数字进行操作
                if (i > j) {
                    // 若非0数字在0数字的后面，此元素才和0数字进行交换
                    nums[j] = nums[i];
                    nums[i] = 0;
                }

                // 非0数字索引加1
                ++j;
            }
        }
    }

}
```