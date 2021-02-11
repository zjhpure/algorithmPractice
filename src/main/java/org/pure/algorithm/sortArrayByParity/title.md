## 源码路径

/src/main/java/org/pure/algorithm/sortArrayByParity/Main.java

## 题目地址(按奇偶排序数组)

https://leetcode-cn.com/problems/sort-array-by-parity

## 题目描述

```
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

示例1:

输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。

提示:

1 <= A.length <= 5000
0 <= A[i] <= 5000
```

## 代码

- 语言：Java

```
class Solution {

    public int[] sortArrayByParity(int[] A) {
        // 定义数组B保存奇偶排序后的数组
        int[] B = new int[A.length];

        // 数组B偶数当前索引
        int evenIndex = 0;

        // 数组B奇数当前索引
        int oddIndex = A.length - 1;

        // 遍历数组A
        for (int value : A) {
            if (value % 2 == 0) {
                // 若是偶数，保存进数组B前面
                B[evenIndex] = value;
                // 数组B偶数当前索引加1
                ++evenIndex;
            } else {
                // 若是奇数，保存进数组B后面
                B[oddIndex] = value;
                // 数组B奇数当前索引减1
                --oddIndex;
            }
        }

        return B;
    }

}
```