## 源码路径

/src/main/java/org/pure/algorithm/majorityElement/Main.java

## 题目地址(多数元素)

https://leetcode-cn.com/problems/majority-element

## 题目描述

```
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1:

输入：[3,2,3]
输出：3

示例2:

输入：[2,2,1,1,1,2,2]
输出：2

进阶：

尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
```

## 代码

- 语言：Java

```
class Solution {

    public int majorityElement(int[] nums) {
        if (nums.length <= 1) {
            // 若数组nums长度不大于1，那么多数元素就是数目nums的第一个元素
            return nums[0];
        }

        // 定义元素统计数量
        int count = 0;

        // 第一轮遍历数组nums，从第一个元素到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 每次把元素统计数量重新设置为1
            count = 1;

            // 第二轮遍历数组nums，从上一轮元素的下一个元素到倒数第一个元素
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == nums[i]) {
                    // 若两个元素相等，元素统计数量加1
                    ++count;

                    if (count > nums.length / 2) {
                        // 如果此元素在数组中出现次数大于n/2，那么找到多数元素
                        return nums[i];
                    }
                }
            }
        }

        return count;
    }

}
```