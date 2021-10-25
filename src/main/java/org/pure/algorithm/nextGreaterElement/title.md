## 源码路径

/src/main/java/org/pure/algorithm/nextGreaterElement/Main.java

## 题目地址(下一个更大元素I)

https://leetcode-cn.com/problems/next-greater-element-i

## 题目描述

```
给你两个没有重复元素的数组nums1和nums2，其中nums1是nums2的子集。

请你找出nums1中每个元素在nums2中的下一个比其大的值。

nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出-1。

示例1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出-1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出-1。

示例2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出-1。

提示：

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
nums1和nums2中所有整数互不相同
nums1中的所有整数同样出现在nums2中
```

## 代码

- 语言：Java

```
class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 暴力法

        // 定义结果数组results
        int[] results = new int[nums1.length];

        // 遍历数组nums1
        for (int i = 0; i < nums1.length; ++i) {
            // 定义在数组nums2中第一个比数组nums1元素大的索引值
            int findIndex = -1;

            // 是否找到下一个更大元素
            boolean isFind = false;

            // 遍历数组nums2
            for (int j = 0; j < nums2.length; ++j) {
                if (nums2[j] == nums1[i]) {
                    // 如果数组nums2中的元素等于数组nums1中的元素，记录索引值
                    findIndex = j;
                } else if (nums2[j] > nums1[i]) {
                    // 如果数组nums2中的元素等于数组nums1中的元素
                    if (findIndex > -1) {
                        // 如果前面已找到了相等元素，那么数组nums2中找到的比数组num1中大的元素就是下一个更大元素
                        results[i] = nums2[j];
                        isFind = true;
                        break;
                    }
                }
            }

            if (!isFind) {
                // 如果没有找到下一个更大元素，那么给结果数组赋值-1
                results[i] = -1;
            }
        }

        return results;
    }

}
```