## 源码路径

/src/main/java/org/pure/algorithm/countGoodTriplets/Main.java

## 题目地址(统计好三元组)

https://leetcode-cn.com/problems/count-good-triplets

## 题目描述

```
给你一个整数数组arr，以及a、b、c三个整数。请你统计其中好三元组的数量。

如果三元组(arr[i], arr[j], arr[k])满足下列全部条件，则认为它是一个好三元组。

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c

其中|x|表示x的绝对值。

返回好三元组的数量。

示例1:

输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
输出：4
解释：一共有4个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)]。

示例2:

输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
输出：0
解释：不存在满足所有条件的三元组。

提示:

3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // 定义好三元组数量
        int count = 0;

        // 枚举法，遍历三层数组arr
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                for (int k = j + 1; k < arr.length; ++k) {
                    // 判断是否满足好三元组的条件
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        // 若满足好三元组的条件，好三元组数量加1
                        ++count;
                    }
                }
            }
        }

        // 返回好三元组数量
        return count;
    }

}
```