## 源码路径

/src/main/java/org/pure/algorithm/findPeakElement/Main.java

## 题目地址(寻找峰值)

https://leetcode-cn.com/problems/find-peak-element

## 题目描述

```
峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为O(logn)的算法来解决此问题。

示例1:

输入：nums = [1,2,3,1]
输出：2
解释：3是峰值元素，你的函数应该返回其索引2。

示例2:

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5 
解释：你的函数可以返回索引1，其峰值元素为2；
     或者返回索引5，其峰值元素为6。

提示:

1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
对于所有有效的i都有nums[i] != nums[i + 1]
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，枚举法，寻找最大值的下标
    public int findPeakElement(int[] nums) {
        // 寻找数组最大值的下标，因为nums[i] != nums[i + 1]，所以数组最大值的下标是一个可行的峰值的下标

        // 定义数组最大值的下标
        int maxIndex = 0;

        // 从数组的第二个元素开始遍历到最后一个元素，寻找数组最大值的下标
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                maxIndex = i;
            }
        }

        // 返回数组最大值的下标
        return maxIndex;
    }

}
```

```
class Solution {

    // 方法2，二分查找法
    public int findPeakElement(int[] nums) {
        // 二分查找法，从中间开始查找，和下一个元素比较大小，如果较大，那么峰值在左侧；如果较小，那么峰值在右侧

        // 因为nums[-1] = nums[n] = -∞，所以数组两端是负无穷的，而对于所有有效的i都有nums[i] != nums[i + 1]，那么必定有两个相邻的元素nums[i] < nums[i + 1]或nums[i] > nums[i + 1]，从这里就可以推导出必定存在一个地方达到峰值，所以数组中必定能找到一个峰值

        // 定义左指针，初始为0
        int left = 0;
        // 定义右指针，初始为数组最后一个元素的下标
        int right = nums.length - 1;

        // 二分查找，从两边不断往里缩小范围，当左指针和右指针相等时，结束循环
        while (left < right) {
            // 二分计算中间指针
            int mid = (left + right) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                // 若当前元素大于下一个元素，那么峰值在左侧，右指针等于中间指针，把范围缩小到左侧
                right = mid;
            } else {
                // 因为nums[i] != nums[i + 1]，所以相邻元素不会相等，所以这里是当前元素小于下一个元素
                // 若当前元素小于下一个元素，那么峰值在右侧，左指针等于中间指针加1，把范围缩小到右侧
                left = mid + 1;
            }
        }

        // 最后把位置缩小到只有一个元素，即left=right，这时的元素就是峰值之一
        return left;
    }

}
```