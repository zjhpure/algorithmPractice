## 源码路径

/src/main/java/org/pure/algorithm/majorityElement2/Main.java

## 题目地址(求众数II)

https://leetcode-cn.com/problems/majority-element-ii

## 题目描述

```
给定一个大小为n的整数数组，找出其中所有出现超过n/3次的元素。

示例1:

输入：[3,2,3]
输出：[3]

示例2:

输入：nums = [1]
输出：[1]

示例3:

输入：[1,1,1,3,3,2,2,2]
输出：[1,2]

提示：

1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9

进阶：

尝试设计时间复杂度为O(n)、空间复杂度为O(1)的算法解决此问题。
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> majorityElement(int[] nums) {
        // 计算数组长度除以3
        int count = nums.length / 3;

        // 定义列表，保存数组中出现超过n/3次的元素
        List<Integer> list = new ArrayList<>();

        // 定义集合，保存数组中每种元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int num : nums) {
            // 更新此元素出现的次数
            int time = map.getOrDefault(num, 0) + 1;

            // 把此元素出现的次数更新到集合中
            map.put(num, time);
        }

        // 遍历集合，统计出现次数大于数组长度除以3的元素，添加元素到列表中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                list.add(entry.getKey());
            }
        }

        // 返回集合作为结果
        return list;
    }

}
```