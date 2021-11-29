## 源码路径

/src/main/java/org/pure/algorithm/kThSmallestPrimeFraction/Main.java

## 题目地址(第K个最小的素数分数)

https://leetcode-cn.com/problems/k-th-smallest-prime-fraction

## 题目描述

```
给你一个按递增顺序排序的数组arr和一个整数k。数组arr由1和若干素数组成，且其中所有整数互不相同。

对于每对满足0 < i < j < arr.length的i和j，可以得到分数arr[i] / arr[j]。

那么第k个最小的分数是多少呢? 以长度为2的整数数组返回你的答案, 这里answer[0] == arr[i]且answer[1] == arr[j]。

示例1：

输入：arr = [1,2,3,5], k = 3
输出：[2,5]
解释：已构造好的分数,排序后如下所示: 
1/5, 1/3, 2/5, 1/2, 3/5, 2/3
很明显第三个最小的分数是2/5

示例2：

输入：arr = [1,7], k = 1
输出：[1,7]

提示：

2 <= arr.length <= 1000
1 <= arr[i] <= 3 * 10^4
arr[0] == 1
arr[i]是一个素数，i > 0
arr中的所有数字互不相同，且按严格递增排序
1 <= k <= arr.length * (arr.length - 1) / 2
```

## 代码

- 语言：Java

```
class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 暴力法+自定义排序，先把所有素数分数放到列表中，然后进行自定义排序，用交叉相乘比较大小，若a/b < c/d，那么ad < bc

        // 定义列表，保存所有素数分数
        List<int[]> list = new ArrayList<>();

        // 遍历数组，获取第一个素数
        for (int i = 0; i < arr.length; ++i) {
            // 遍历数组，获取第二个素数
            for (int j = i + 1; j < arr.length; ++j) {
                // 把素数分数添加到列表中
                list.add(new int[]{arr[i], arr[j]});
            }
        }

        // 使用自定义排序，对列表进行排序
        list.sort((o1, o2) -> o1[0] * o2[1] - o1[1] * o2[0]);

        // 返回第k个元素，就是第k个最小的素数分数
        return list.get(k - 1);
    }

}
```