## 源码路径

/src/main/java/org/pure/algorithm/kInversePairsArray/Main.java

## 题目地址(K个逆序对数组)

https://leetcode-cn.com/problems/k-inverse-pairs-array

## 题目描述

```
给出两个整数n和k，找出所有包含从1到n的数字，且恰好拥有k个逆序对的不同的数组的个数。

逆序对的定义如下：对于数组的第i个和第j个元素，如果满i < j且a[i] > a[j]，则其为一个逆序对；否则不是。

由于答案可能很大，只需要返回答案 mod 10^9 + 7的值。

示例1：

输入: n = 3, k = 0
输出: 1
解释: 
只有数组[1,2,3]包含了从1到3的整数并且正好拥有0个逆序对。

示例2：

输入: n = 3, k = 1
输出: 2
解释: 
数组[1,3,2]和[2,1,3]都有1个逆序对。

说明：

n的范围是[1, 1000]并且k的范围是[0, 1000]。
```

## 代码

- 语言：Java

```
class Solution {

    public int kInversePairs(int n, int k) {
        // 动态规划
        
        // 定义模
        int mod = 1000000007;

        // 定义二维数组n * (k + 1)
        int[][] dp = new int[n][k + 1];

        // dp初始化
        for (int i = 0; i < n; ++i){
            dp[i][0] = 1;
        }

        // 从1遍历到n - 1
        for (int i = 1; i < n; ++i){
            // 从1遍历到k
            for (int j = 1; j <= k; ++j){
                // 获取二维数组当前值
                long sum = dp[i][j];

                // 从0遍历到i和j中最小值
                for (int w = 0; w <= i && w <= j; ++w){
                    // 累加
                    sum += dp[i - 1][j - w];
                }

                // 取模，更新到二维数组
                dp[i][j] = (int)(sum % mod);
            }
        }

        // 返回二维数组最后一行最后一列的值
        return dp[n - 1][k];
    }

}
```