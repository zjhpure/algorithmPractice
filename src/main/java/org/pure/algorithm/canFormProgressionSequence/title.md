## 源码路径

/src/main/java/org/pure/algorithm/canFormProgressionSequence/Main.java

## 题目地址(判断能否形成等差数列)

https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence

## 题目描述

```
给你一个数字数组 arr 。

如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。

如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

示例1:

输入：arr = [3,5,1]
输出：true
解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。

示例2:

输入：arr = [1,2,4]
输出：false
解释：无法通过重新排序得到等差数列。

提示:

2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
```

## 代码

- 语言：Java

```
class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {
        // 先对数组arr进行冒泡排序
        // 需要进行排序的趟数刚好为数组arr的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    // 若当前元素大于下一个元素，交换两个元素
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
        }

        // 定义数列的初始差
        int dif = arr[1] - arr[0];

        // 遍历排序后的数组arr，从第3个元素开始遍历
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != dif) {
                // 若有两个相邻数的差不等于初始差，那么数组arr就不是等差数列
                return false;
            }
        }

        // 若遍历排序后的数组arr能遍历完，那么证明任意两个相邻数的差是相等的，数组arr是等差数列
        return true;
    }

}
```