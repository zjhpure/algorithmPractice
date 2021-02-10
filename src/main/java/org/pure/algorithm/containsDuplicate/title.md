## 源码路径

/src/main/java/org/pure/algorithm/containsDuplicate/Main.java

## 题目地址(存在重复元素)

https://leetcode-cn.com/problems/contains-duplicate

## 题目描述

```
给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

示例1:

输入: [1,2,3,1]
输出: true

示例2:

输入: [1,2,3,4]
输出: false

示例3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
```

## 代码

- 语言：Java

```
class Solution {

    public boolean containsDuplicate(int[] nums) {
        // 定义集合保存不重复的元素
        Set<Integer> set = new HashSet<>();

        // 遍历数组nums的元素
        for (int num : nums) {
            if (set.contains(num)) {
                // 若集合中能找到元素，则返回true
                return true;
            } else {
                // 若集合中不能找到元素，则添加到集合中
                set.add(num);
            }
        }

        // 若能遍历结果结束，则没有找到重复元素
        return false;
    }

}
```