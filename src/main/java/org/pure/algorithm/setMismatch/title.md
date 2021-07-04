## 源码路径

/src/main/java/org/pure/algorithm/setMismatch/Main.java

## 题目地址(错误的集合)

https://leetcode-cn.com/problems/set-mismatch

## 题目描述

```
集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。

给定一个数组 nums 代表了集合 S 发生错误后的结果。

请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

示例1:

输入：nums = [1,2,2,4]
输出：[2,3]

示例2:

输入：nums = [1,1]
输出：[1,2]

提示：

2 <= nums.length <= 10^4
1 <= nums[i] <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public int[] findErrorNums(int[] nums) {
        // 定义返回结果数组results，数组第一个元素保存重复出现的整数，第二个元素保存丢失的整数
        int[] results = new int[2];

        // 对数组nums进行排序
        Arrays.sort(nums);

        // 定义减去丢失的整数的总和，第一个整数不可能是重复的，初始化时先累加第一个整数
        int sum = nums[0];

        // 循环遍历数组nums，从第二个整数开始遍历，找到重复出现的整数，并且累加得到减去丢失的整数的总和
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                // 若当前整数和前一个整数相等，那么找到重复出现的整数，赋值到结果数组results的第一个位置
                results[0] = nums[i];
            } else {
                // 若当前整数和前一个整数不相等，累加
                sum += nums[i];
            }
        }

        // 丢失的整数 = 从1到n的总和 - 减去丢失的整数的总和
        results[1] = (1 + nums.length) * nums.length / 2 - sum;

        // 最后返回结果数组results
        return results;
    }

}
```