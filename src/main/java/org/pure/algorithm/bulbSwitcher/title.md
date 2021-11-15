## 源码路径

/src/main/java/org/pure/algorithm/bulbSwitcher/Main.java

## 题目地址(灯泡开关)

https://leetcode-cn.com/problems/bulb-switcher

## 题目描述

```
初始时有n个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。

第三轮，你每三个灯泡就切换一个灯泡的开关(即，打开变关闭，关闭变打开)。第i轮，你每i个灯泡就切换一个灯泡的开关。直到第n轮，你只需要切换最后一个灯泡的开关。

找出并返回n轮后有多少个亮着的灯泡。

示例1：

输入：n = 3
输出：1 
解释：
初始时, 灯泡状态[关闭, 关闭, 关闭].
第一轮后, 灯泡状态[开启, 开启, 开启].
第二轮后, 灯泡状态[开启, 关闭, 开启].
第三轮后, 灯泡状态[开启, 关闭, 关闭]. 

你应该返回1，因为只有一个灯泡还亮着。

示例2：

输入：n = 0
输出：0

示例3：

输入：n = 1
输出：1

提示:

0 <= n <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，模拟法，直接暴力，超时，不推荐
    public int bulbSwitch(int n) {
        // 数学法，直接暴力，超时，不推荐

        // 定义亮着的灯泡数量
        int lightNum = 0;

        // 定义灯泡数组，用布尔数组表示，true表示打开，false表示关闭
        boolean[] bulbs = new boolean[n];

        // 遍历轮数，从1到n
        for (int i = 1; i <= n; ++i) {
            if (i == 1) {
                // 若是第一轮，全部灯泡变为打开
                Arrays.fill(bulbs, true);
                // 亮着的灯泡数量就是布尔数组的长度
                lightNum = bulbs.length;
            } else if (i == 2) {
                // 若是第二轮，每两个灯泡关闭一个，即每两个元素等于false
                for (int j = i - 1; j < bulbs.length; j += i) {
                    bulbs[j] = false;
                    --lightNum;
                }
            } else {
                // 若是第i轮，每i个灯泡切换一个，即每i个元素等于这个元素的否定
                for (int j = i - 1; j < bulbs.length; j += i) {
                    bulbs[j] = !bulbs[j];
                    if (bulbs[j])  {
                        ++lightNum;
                    } else {
                        --lightNum;
                    }
                }
            }
        }

        // 返回亮着的灯泡数量
        return lightNum;
    }

}
```

```
class Solution {

    // 方法2，数学法，找规律，推荐
    public int bulbSwitch(int n) {
        // 数学法，找规律

        // 通过找规律发现，刚好等于n的开方向下取整
        return (int) Math.sqrt(n);
    }

}
```