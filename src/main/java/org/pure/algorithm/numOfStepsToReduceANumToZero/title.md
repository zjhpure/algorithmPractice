## 源码路径

/src/main/java/org/pure/algorithm/numOfStepsToReduceANumToZero/Main.java

## 题目地址(将数字变成0的操作次数)

https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero

## 题目描述

```
给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。

示例1:

输入：num = 14
输出：6
解释：
步骤 1) 14 是偶数，除以 2 得到 7 。
步骤 2） 7 是奇数，减 1 得到 6 。
步骤 3） 6 是偶数，除以 2 得到 3 。
步骤 4） 3 是奇数，减 1 得到 2 。
步骤 5） 2 是偶数，除以 2 得到 1 。
步骤 6） 1 是奇数，减 1 得到 0 。

示例2:

输入：num = 8
输出：4
解释：
步骤 1） 8 是偶数，除以 2 得到 4 。
步骤 2） 4 是偶数，除以 2 得到 2 。
步骤 3） 2 是偶数，除以 2 得到 1 。
步骤 4） 1 是奇数，减 1 得到 0 。

示例3:

输入：num = 123
输出：12

提示：

0 <= num <= 10^6
```

## 代码

- 语言：Java

```
class Solution {

    public int numberOfSteps(int num) {
        // 定义操作次数
        int count = 0;

        // 循环判断非负整数num是否等于0
        while (num > 0) {
            if (num % 2 == 0) {
                // 若是偶数，除以2
                num = num / 2;
            } else {
                // 若是奇数，减去1
                --num;
            }

            // 每次增加一次操作次数
            ++count;
        }

        return count;
    }

}
```