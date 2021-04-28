## 源码路径

/src/main/java/org/pure/algorithm/magicIndex/Main.java

## 题目地址(魔术索引)

https://leetcode-cn.com/problems/magic-index-lcci

## 题目描述

```
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

示例1:

输入：nums = [0, 2, 3, 4, 5]
输出：0
说明: 0下标的元素为0

示例2:

输入：nums = [1, 1, 1]
输出：1

说明：

nums长度在[1, 1000000]之间
此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
```

## 代码

- 语言：Java

```
class Solution {

    public int findMagicIndex(int[] nums) {
        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums[i]) {
                // 若索引等于索引下的数组元素值，那就是魔术索引
                return i;
            }
        }

        // 如果没有找到索引等于索引下的数组元素值的索引，那么返回-1
        return -1;
    }

}
```