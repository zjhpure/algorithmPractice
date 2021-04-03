## 源码路径

/src/main/java/org/pure/algorithm/findNUniqueIntsSumUpToZero/Main.java

## 题目地址(和为零的N个唯一整数)

https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero

## 题目描述

```
给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。

示例1:

输入：n = 5
输出：[-7,-1,1,3,4]
解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。

示例2:

输入：n = 3
输出：[-1,0,1]

示例3:

输入：n = 1
输出：[0]

提示：

1 <= n <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int[] sumZero(int n) {
        // 定义结果数组results
        int[] results = new int[n];

        if (n <= 1) {
            // 若n小于等于1，那么结果数组results只有一个元素，并且是0
            results[0] = 0;
        }

        // 定义总和
        int sum = 0;

        // 从1开始遍历到n-1
        for (int i = 1; i <= n - 1; ++i) {
            // 每次把n本身赋值到结果数组results中
            results[i - 1] = i;

            // 累加n值得到总和
            sum += i;
        }

        // 结果数组results的最后一个元素取总和的负数，那么他们相加之和就肯定为0了
        results[n - 1] = sum * -1;

        return results;
    }

}
```