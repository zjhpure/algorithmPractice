## 源码路径

/src/main/java/org/pure/algorithm/rankTransformOfAnArray/Main.java

## 题目地址(数组序号转换)

https://leetcode-cn.com/problems/rank-transform-of-an-array

## 题目描述

```
给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。

序号代表了一个元素有多大。序号编号的规则如下：

序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。

示例1:

输入：arr = [40,10,20,30]
输出：[4,1,2,3]
解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。

示例2:

输入：arr = [100,100,100]
输出：[1,1,1]
解释：所有元素有相同的序号。

示例3:

输入：arr = [37,12,28,9,100,56,80,5,12]
输出：[5,3,4,2,8,6,7,1,3]

提示：

0 <= arr.length <= 10^5
-10^9 <= arr[i] <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    public int[] arrayRankTransform(int[] arr) {
        // 定义结果数组result
        int[] result = new int[arr.length];

        // 定义排序后的数组sortedArr
        int[] sortedArr = new int[arr.length];

        // 把数组arr的复制到数组sortedArr
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        // 对数组sortedArr进行排序，用系统提供的sort排序，效率更高，如果用冒泡排序会超时
        Arrays.sort(sortedArr);      

        // // 对数组sortedArr冒泡排序
        // for (int i = 0; i < sortedArr.length - 1; ++i) {
        //     for (int j = 0; j < sortedArr.length - 1 - i; ++j) {
        //         if (sortedArr[j] > sortedArr[j + 1]) {
        //             sortedArr[j] ^= sortedArr[j + 1];
        //             sortedArr[j + 1] ^= sortedArr[j];
        //             sortedArr[j] ^= sortedArr[j + 1];
        //         }
        //     }
        // }

        // 定义集合map，保存数组的序号
        Map<Integer, Integer> map = new HashMap<>();

        // 定义初始序号
        int sortNum = 0;

        // 遍历排序后的数组sortedArr
        for (int e : sortedArr) {
            if (!map.containsKey(e)) {
                // 若集合map中没有这个元素，才进行操作，保存元素对应的序号
                ++sortNum;
                map.put(e, sortNum);
            }
        }

        // 遍历原数组arr
        for (int i = 0; i < arr.length; ++i) {
            // 把序号赋值给结果数组result
            result[i] = map.get(arr[i]);
        }

        return result;
    }

}
```