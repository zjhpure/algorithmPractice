## 源码路径

/src/main/java/org/pure/algorithm/containsDuplicateII/Main.java

## 题目地址(存在重复元素II)

https://leetcode-cn.com/problems/contains-duplicate-ii

## 题目描述

```
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

示例1:

输入: nums = [1,2,3,1], k = 3
输出: true

示例2:

输入: nums = [1,0,1,1], k = 1
输出: true

示例3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false
```

## 代码

- 语言：Java

```
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 这道题要注意读题，只要存在两个不同的索引i和j，使得两数相等，并且i和j的差的绝对值至多为k，这里的意思是只要找到两个相等的数，并且他们的索引之差不大于k即可，注意存在这个字，注意理解清楚示例2，示例2没有出错

        // 定义集合map，保存元素的索引
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组nums
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                // 若集合map中已存在元素，索引相减判断是否小于等于k
                if (i - map.get(nums[i]) <= k) {
                    // 若索引相减小于等于k，那么存在两个不同的索引i和j，使得两数相等，并且i和j的差的绝对值至多为k，即马上可以返回true
                    return true;
                } else {
                    // 若索引相减大于k，那么更新当前索引为元素的索引，后面的索引和当前索引相减来计算索引之差
                    map.put(nums[i], i);
                }
            } else {
                // 若集合map中不存在元素，把元素作为key，把当前索引作为value，保存到集合map中
                map.put(nums[i], i);
            }
        }
        
        // 若能遍历完数组nums，那么不存在两个不同的索引i和j，使得两数相等，并且i和j的差的绝对值至多为k
        return false;
    }

}
```