## 源码路径

/src/main/java/org/pure/algorithm/missingNumber/Main.java

## 题目地址(丢失的数字)

https://leetcode-cn.com/problems/missing-number

## 题目描述

```
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

进阶：

你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

示例1:

输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。

示例2:

输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。

示例3:

输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。

示例4:

输入：nums = [0]
输出：1
解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。

提示：

n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
nums 中的所有数字都 独一无二
```

## 代码

- 语言：Java

```
class Solution {

    public int missingNumber(int[] nums) {
        // 定义列表list保存数组
        List<Integer> list = new ArrayList<>();

        // 遍历数组nums，把nums的元素保存进列表list
        for (int num : nums) {
            list.add(num);
        }

        // 遍历[0,n]范围的整数
        for (int i = 0; i <= nums.length; ++i) {
            if (!list.contains(i)) {
                // 若列表list中不包含此元素，那么这个就是丢失的数字
                return i;
            }
        }

        return 0;
    }

}
```