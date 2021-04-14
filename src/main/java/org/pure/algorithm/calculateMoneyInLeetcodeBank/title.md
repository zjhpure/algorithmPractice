## 源码路径

/src/main/java/org/pure/algorithm/calculateMoneyInLeetcodeBank/Main.java

## 题目地址(计算力扣银行的钱)

https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank

## 题目描述

```
Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。

最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。

给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。

示例1:

输入：n = 4
输出：10
解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。

示例2:

输入：n = 10
输出：37
解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。

示例3:

输入：n = 20
输出：96
解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。

提示:

1 <= n <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int totalMoney(int n) {
        // 定义总和
        int total = 0;

        // 获取除以7的商
        int quotient = n / 7;

        // 获取对7取余的余数
        int res = n % 7;

        // 定义每个星期的总和
        int everyTotal = 28;

        // 遍历除以7的商，也就是遍历有多少个星期
        for (int i = 0; i < quotient; ++i) {
            // 总和累加
            total += everyTotal;

            // 每个星期的总和累加7，因为下一个星期周一都会比前一个星期周一多1块钱
            everyTotal += 7; 
        }

        // 定义最后一个星期的总和
        int lastTotal = 0;

        // 遍历对7取余的余数，也就是最后一个星期，这一个星期不够7天
        for (int i = 0; i < res; ++i) {
            // 最后一个星期的总和累加，根据除以7的商加1获得周一的值
            lastTotal += quotient + 1 + i;
        }

        // 总和加上最后一个星期的总和
        total += lastTotal;

        return total;
    }

}
```