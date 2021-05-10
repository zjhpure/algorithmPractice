## 源码路径

/src/main/java/org/pure/algorithm/takeCoins/Main.java

## 题目地址(拿硬币)

https://leetcode-cn.com/problems/na-ying-bi

## 题目描述

```
桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。

示例1:

输入：[4,2,1]
输出：4
解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。

示例2:

输入：[2,3,10]
输出：8

限制：

1 <= n <= 4
1 <= coins[i] <= 10
```

## 代码

- 语言：Java

```
class Solution {

    public int minCount(int[] coins) {
        // 定义总次数
        int sum = 0;

        // 遍历数组coins
        for (int coin : coins) {
            if (coin % 2 == 0) {
                // 若元素能被2整除，那么可以每次拿两枚，总次数就是累加上元素整除2的值
                sum += coin / 2;
            } else {
                // 若元素不能被2整除，那么每次拿两枚，最后一次拿一枚，总次数就是累加上元素整除2的值和1
                sum += coin / 2 + 1;
            }
        }

        return sum;
    }

}
```