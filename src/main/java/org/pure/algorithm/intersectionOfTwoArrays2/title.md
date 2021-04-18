## 源码路径

/src/main/java/org/pure/algorithm/intersectionOfTwoArrays2/Main.java

## 题目地址(两个数组的交集II)

https://leetcode-cn.com/problems/intersection-of-two-arrays-ii

## 题目描述

```
给定两个数组，编写一个函数来计算它们的交集。

示例1:

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。

进阶：
如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
```

## 代码

- 语言：Java

```
class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        // 定义集合map，保存交集数字，key为下标，value为数字
        Map<Integer, Integer> map = new HashMap<>();

        // 定义下标列表list，保存已找到的交集的下标
        List<Integer> indexList = new ArrayList<>();

        // 遍历数组nums1
        for (int i = 0; i < nums1.length; ++i) {
            int num1 = nums1[i];

            // 遍历数组nums2
            for (int j = 0; j < nums2.length; ++j) {
                int num2 = nums2[j];

                if (num1 == num2 && !map.containsKey(i) && !indexList.contains(j)) {
                    // 若两个数相等、数字不在集合map中、下标不在下标列表list中，则添加到集合map中
                    map.put(i, num1);

                    // 下标列表list添加下标
                    indexList.add(j);
                } 
            }
        }

        // 定义数组nums，保存交集结果
        int[] nums = new int[map.size()];

        // 定义数组nums下标
        int n = 0;

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 把元素装进数组nums中
            nums[n] = entry.getValue();

            // 数组nums下标自增
            ++n;
        }

        return nums;
    }

}
```