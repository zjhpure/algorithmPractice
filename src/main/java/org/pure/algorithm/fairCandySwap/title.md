## 源码路径

/src/main/java/org/pure/algorithm/fairCandySwap/Main.java

## 题目地址(公平的糖果棒交换)

https://leetcode-cn.com/problems/fair-candy-swap

## 题目描述

```
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

如果有多个答案，你可以返回其中任何一个。保证答案存在。

示例1:

输入：A = [1,1], B = [2,2]
输出：[1,2]

示例2:

输入：A = [1,2], B = [2,3]
输出：[1,2]

示例3:

输入：A = [2], B = [1,3]
输出：[2,3]

示例4:

输入：A = [1,2,5], B = [2,4]
输出：[5,4]

提示:

1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
保证爱丽丝与鲍勃的糖果总量不同。
答案肯定存在。
```

## 代码

- 语言：Java

```
class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        // 定义数组A的总和
        int sumA = 0;
        // 定义数组B的总和
        int sumB = 0;

        // 遍历数组A，计算出数组A的总和
        for (int a : A) {
            sumA += a;
        }

        // 遍历数组B，计算出数组B的总和
        for (int b : B) {
            sumB += b;
        }

        // 遍历数组A
        for (int a : A) {
            // 遍历数组B
            for (int b : B) {
                // 数组A的元素和数组B的元素交换，判断两边的数组总和是否相等
                if (sumA - a + b == sumB - b + a) {
                    return new int[]{a, b};
                }
            }
        }

        return null;
    }

}
```