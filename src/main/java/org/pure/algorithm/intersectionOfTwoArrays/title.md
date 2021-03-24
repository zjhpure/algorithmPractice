## 源码路径

/src/main/java/org/pure/algorithm/intersectionOfTwoArrays/Main.java

## 题目地址(两个数组的交集)

https://leetcode-cn.com/problems/intersection-of-two-arrays

## 题目描述

```
给定两个数组，编写一个函数来计算它们的交集。

示例1:

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
```

## 代码

- 语言：Java

```
class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 定义列表list保存交集数字
        List<Integer> list = new ArrayList<>();

        // 遍历数组nums1
        for (int num1 : nums1) {
            // 遍历数组nums2
            for (int num2 : nums2) {
                // 若两个数字相等并且在列表list中不存在，那么就是交集数字
                if (num1 == num2 && !list.contains(num1)) {
                    list.add(num1);
                }
            }
        }

        // 定义数组nums，保存结果
        int[] nums = new int[list.size()];

        // 遍历列表list，把交集数字装进数组nums
        for (int i = 0; i < list.size(); ++i) {
            nums[i] = list.get(i);
        }

        return nums;
    }

}
```