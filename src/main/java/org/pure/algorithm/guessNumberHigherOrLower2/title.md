## 源码路径

/src/main/java/org/pure/algorithm/guessNumberHigherOrLower2/Main.java

## 题目地址(猜数字大小II)

https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii

## 题目描述

```
我们正在玩一个猜数游戏，游戏规则如下：

我从1到n之间选择一个数字。
你来猜我选了哪个数字。
如果你猜到正确的数字，就会赢得游戏。
如果你猜错了，那么我会告诉你，我选的数字比你的更大或者更小，并且你需要继续猜数。
每当你猜了数字x并且猜错了的时候，你需要支付金额为x的现金。如果你花光了钱，就会输掉游戏。
给你一个特定的数字n，返回能够确保你获胜的最小现金数，不管我选择那个数字。

示例1：

输入：n = 10
输出：16
解释：制胜策略如下：
- 数字范围是[1,10]。你先猜测数字为7。
    - 如果这是我选中的数字，你的总费用为$0。否则，你需要支付$7。
    - 如果我的数字更大，则下一步需要猜测的数字范围是[8,10]。你可以猜测数字为9。
        - 如果这是我选中的数字，你的总费用为$7。否则，你需要支付$9。
        - 如果我的数字更大，那么这个数字一定是10。你猜测数字为10并赢得游戏，总费用为$7 + $9 = $16。
        - 如果我的数字更小，那么这个数字一定是8。你猜测数字为8并赢得游戏，总费用为$7 + $9 = $16。
    - 如果我的数字更小，则下一步需要猜测的数字范围是[1,6]。你可以猜测数字为3。
        - 如果这是我选中的数字，你的总费用为$7。否则，你需要支付$3。
        - 如果我的数字更大，则下一步需要猜测的数字范围是[4,6]。你可以猜测数字为5。
            - 如果这是我选中的数字，你的总费用为$7 + $3 = $10。否则，你需要支付$5。
            - 如果我的数字更大，那么这个数字一定是6。你猜测数字为6并赢得游戏，总费用为$7 + $3 + $5 = $15。
            - 如果我的数字更小，那么这个数字一定是4。你猜测数字为4并赢得游戏，总费用为$7 + $3 + $5 = $15。
        - 如果我的数字更小，则下一步需要猜测的数字范围是[1,2]。你可以猜测数字为1。
            - 如果这是我选中的数字，你的总费用为$7 + $3 = $10。否则，你需要支付$1。
            - 如果我的数字更大，那么这个数字一定是2。你猜测数字为2并赢得游戏，总费用为$7 + $3 + $1 = $11。
在最糟糕的情况下，你需要支付$16。因此，你只需要$16就可以确保自己赢得游戏。

示例2：

输入：n = 1
输出：0
解释：只有一个可能的数字，所以你可以直接猜1并赢得游戏，无需支付任何费用。

示例3：

输入：n = 2
输出：1
解释：有两个可能的数字1和2。
- 你可以先猜1。
    - 如果这是我选中的数字，你的总费用为$0。否则，你需要支付$1。
    - 如果我的数字更大，那么这个数字一定是2。你猜测数字为2并赢得游戏，总费用为$1。
最糟糕的情况下，你需要支付$1。

提示:

1 <= n <= 200
```

## 代码

- 语言：Java

```
class Solution {

    public int getMoneyAmount(int n) {
        // 动态规划法，待理解原理
        
        int[][] f = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 1; --i) {
            for (int j = i + 1; j <= n; ++j) {
                int minCost = Integer.MAX_VALUE;

                for (int k = i; k < j; ++k) {
                    int cost = k + Math.max(f[i][k - 1], f[k + 1][j]);
                    minCost = Math.min(minCost, cost);
                }

                f[i][j] = minCost;
            }
        }
        return f[1][n];
    }

}
```