## 源码路径

/src/main/java/org/pure/algorithm/thirdMaximumNumber/Main.java

## 题目地址(第三大的数)

https://leetcode-cn.com/problems/third-maximum-number

## 题目描述

```
给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

示例1:

输入：[3, 2, 1]
输出：1
解释：第三大的数是 1 。

示例2:

输入：[1, 2]
输出：2
解释：第三大的数不存在, 所以返回最大的数 2 。

示例3:

输入：[2, 2, 3, 1]
输出：1
解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。

提示：

1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1

进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
```

## 代码

- 语言：Java

```
class Solution {

    public int thirdMax(int[] nums) {
        // 三次遍历，先找出第一大的数，再找出第二大的数，最后找出第三大的数，时间复杂度O(3n)，O(3n)=O(n)

        // 定义第一大的数
        int first = -2147483648;

        // 第一次遍历数组nums，找出第一大的数
        for (int num : nums) {
            if (num >= first) {
                first = num;
            }
        }

        // 定义第二大的数
        int second = -2147483648;

        // 第二次遍历数组nums，找出第二大的数
        for (int num : nums) {
            if (num >= second && num < first) {
                second = num;
            }
        }

        // 定义第三大的数
        int third = -2147483648;

        // 是否找到第三大的数
        boolean isFind = false;

        // 第三次遍历数组nums，找出第三大的数
        for (int num : nums) {
            if (num >= third && num < second) {
                third = num;
                isFind = true;
            }
        }

        if (isFind) {
            // 若找到第三大的数，返回第三大的数
            return third;
        } else {
            // 若没有找到第三大的数，返回第一大的数
            return first;
        }
    }

}
```