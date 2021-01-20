## 源码路径

/src/main/java/org/pure/algorithm/repeatNum/Main.java

## 题目地址(数组中重复的数字)

https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof

## 题目描述

```
找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例1:

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

限制：

2 <= n <= 100000
```

## 代码

- 语言：Java

```
class Solution {

    public int findRepeatNumber(int[] nums) {
        // 构造数组，因为说明了长度为n的数组nums里的所有数字都在0~n-1范围，所以此数组不会越界
        int[] arrs = new int[nums.length];

        // 遍历数组nums
        for (int num : nums) {
            // 把nums数组的元素作为arrs的下标
            ++arrs[num];

            // 若arrs数组中此下标的值大于1，那么证明已经有重复的数了
            if (arrs[num] > 1) {
                return num;
            }
        }

        return 0;
    }

}
```