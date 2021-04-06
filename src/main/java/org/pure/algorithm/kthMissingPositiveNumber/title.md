## 源码路径

/src/main/java/org/pure/algorithm/kthMissingPositiveNumber/Main.java

## 题目地址(第k个缺失的正整数)

https://leetcode-cn.com/problems/kth-missing-positive-number

## 题目描述

```
给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。

请你找到这个数组里第 k 个缺失的正整数。

示例1:

输入：arr = [2,3,4,7,11], k = 5
输出：9
解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。

示例2:

输入：arr = [1,2,3,4], k = 2
输出：6
解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。

提示：

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
```

## 代码

- 语言：Java

```
class Solution {

    public int findKthPositive(int[] arr, int k) {
        // 定义列表list
        List<Integer> list = new ArrayList<>();

        // 遍历数组arr，把数组的元素放进列表list中
        for (int e : arr) {
            list.add(e);
        }

        // 定义起始正整数
        int i = 0;
        // 定义起始缺失的正整数的数目
        int n = 0;

        // 从0开始循环下去，统计缺失的正整数的数目
        while (n < k) {
            // 每次加1
            ++i;

            // 判断正整数i是否在列表list中
            if (!list.contains(i)) {
                // 若正整数i不在列表list中，那么就是缺失的正整数，那么数目加1
                ++n;
            }
        }

        // 最后统计出第k个缺失的正整数
        return i;
    }

}
```