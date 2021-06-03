## 源码路径

/src/main/java/org/pure/algorithm/contiguousArray/Main.java

## 题目地址(连续数组)

https://leetcode-cn.com/problems/contiguous-array

## 题目描述

```
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

示例1:

输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。

示例2:

输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。

说明:

1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1
```

## 代码

- 语言：Java

```
class Solution {

    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) {
            // 若数组nums的长度不大于1，只能是0或1，那么不存在同时含有0和1的子数组，返回0
            return 0;
        }

        // 定义列表list
        List<Integer> list = new ArrayList<>();

        // 定义当前0的数量
        int currentZeroNum;
        // 定义当前1的数量
        int currentOneNum;

        // 第一轮遍历数组nums的元素，从第一个元素到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 对第一个元素进行当前0、1的数量统计
            if (nums[i] == 1) {
                currentOneNum = 1;
                currentZeroNum = 0;
            } else {
                currentZeroNum = 1;
                currentOneNum = 0;
            }

            // 第二轮遍历数组nums的元素，从上一轮的下一个元素到倒数第一个元素
            for (int j = i + 1; j < nums.length; ++j) {
                // 统计当前0、1的数量
                if (nums[j] == 1) {
                    ++currentOneNum;
                } else {
                    ++currentZeroNum;
                }

                if (currentZeroNum == currentOneNum) {
                    // 若当前0的数量等于当前1的数量，则找到了符合条件的连续子数组，保存子数组长度到列表list中
                    list.add(j - i + 1);
                }
            }
        }

        // 定义最长连续子数组的长度
        int maxNum = 0;

        for (int num : list) {
            // 和所有符合条件的连续子数组长度对比，找出最大长度
            if (num > maxNum) {
                maxNum = num;
            }
        }

        return maxNum;
    }

}
```