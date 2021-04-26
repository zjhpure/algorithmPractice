## 源码路径

/src/main/java/org/pure/algorithm/smallestRangeI/Main.java

## 题目地址(最小差值I)

https://leetcode-cn.com/problems/smallest-range-i

## 题目描述

```
给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。

返回数组 B 的最大值和最小值之间可能存在的最小差值。

示例1:

输入：A = [1], K = 0
输出：0
解释：B = [1]

示例2:

输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]

示例3:

输入：A = [1,3,6], K = 3
输出：0
解释：B = [3,3,3] 或 B = [4,4,4]

提示:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
```

## 代码

- 语言：Java

```
class Solution {

    public int smallestRangeI(int[] A, int K) {
        // 定义最小值和最大值
        int min = A[0], max = A[0];

        // 遍历数组A，找到最小值和最大值
        for (int e : A) {
            if (e < min) {
                // 更新最小值
                min = e;
            }
            if (e > max) {
                // 更新最大值
                max = e;
            }
        }

        if (max - min <= K * 2) {
            // 若数组A的最大值和最小值的差值小于等于k的2倍，那么数组A的最小值和最大值一加一减小于等于k绝对值的某个数，总能使得数组A的最大值和最小值相等，所以数组B的最小差值为0
            return 0;
        } else {
            // 若数组A的最大值和最小值的差值大于k的2倍，那么数组A的最小值和最大值一加一减k就会得到数组B的最小差值
            return max - min - K * 2;
        }
    }

}
```