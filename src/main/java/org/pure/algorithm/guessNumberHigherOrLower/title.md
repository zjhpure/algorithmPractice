## 源码路径

/src/main/java/org/pure/algorithm/guessNumberHigherOrLower/Main.java

## 题目地址(猜数字大小)

https://leetcode-cn.com/problems/guess-number-higher-or-lower

## 题目描述

```
猜数字游戏的规则如下：

每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

-1：我选出的数字比你猜的数字小 pick < num
1：我选出的数字比你猜的数字大 pick > num
0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
返回我选出的数字。

示例1:

输入：n = 10, pick = 6
输出：6

示例2:

输入：n = 1, pick = 1
输出：1

示例3:

输入：n = 2, pick = 1
输出：1

示例4:

输入：n = 2, pick = 2
输出：2

提示:

1 <= n <= 2^31 - 1
1 <= pick <= n
```

## 代码

- 语言：Java

```
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        // 定义左右指标，左指标初始为1，右指标初始为n
        int left = 1, right = n;

        // 计算中间指标，不用center = (left + right) / 2来计算，防止计算时溢出
        int center = left + (right - left) / 2;

        // 计算猜测结果
        int result = guess(center);

        // 循环直至guess的结果为0
        while (result != 0) {
            if (result > 0) {
                // 若是小于0，那么pick < num，选出的数字小于猜测的数字，所以选出的数字在区间[left + 1, mid]中
                left = center + 1;
            } else {
                // 若是大于0，那么pick > num，选出的数字大于猜测的数字，所以选出的数字在区间[mid + 1, right]中
                right = center - 1;
            }

            // 计算中间指标，不用center = (left + right) / 2来计算，防止计算时溢出
            center = left + (right - left) / 2;

            // 计算猜测结果
            result = guess(center);
        }

        // 当猜测结果为0时，即为二分查找到的数字
        return center;
    }

}
```