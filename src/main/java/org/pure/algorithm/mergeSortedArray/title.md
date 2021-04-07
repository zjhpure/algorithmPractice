## 源码路径

/src/main/java/org/pure/algorithm/mergeSortedArray/Main.java

## 题目地址(合并两个有序数组)

https://leetcode-cn.com/problems/merge-sorted-array

## 题目描述

```
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

示例1:

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]

示例2:

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[i] <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 若数组nums2的长度为0，那么结果就是数组nums1本身
        if (n > 0) {
            // 定义排序后的数组sorted
            int[] sorted = new int[m + n];

            // 定义索引k
            int k = 0;

            // 双指针循环，同时循环数组nums1和数组nums2，注意这里的数组nums1和数组nums2是本身有序的数组
            for (int i = 0, j = 0; i < m || j < n;) {
                if (i >= m || j >= n) {
                    // 两个数组有一个结束循环
                    if (i >= m) {
                        // 若是数组nums1结束循环，直接取数组nums2的元素，指针j加1
                        sorted[k] = nums2[j];
                        ++j;
                    } else {
                        if (j >= n) {
                            // 若是数组nums2结束循环，直接取数组nums1的元素，指针i加1
                            sorted[k] = nums1[i];
                            ++i;
                        }
                    }
                } else {
                    // 两个数组都没有结束循环
                    if (nums1[i] < nums2[j]) {
                        // 若数组nums1的元素比数组nums2的元素小，那么取数组nums1的元素，指针i加1
                        sorted[k] = nums1[i];
                        ++i;
                    } else {
                        // 若数组nums2的元素比数组nums1的元素小，那么取数组nums2的元素，指针j加1
                        sorted[k] = nums2[j];
                        ++j;
                    }
                }

                // 每次索引k加1
                ++k;
            }

            // 复制排序后的数组sorted给数组nums1
            System.arraycopy(sorted, 0, nums1, 0, sorted.length);
        }
    }

}
```