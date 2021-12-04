## 源码路径

/src/main/java/org/pure/algorithm/poorPigs/Main.java

## 题目地址(可怜的小猪)

https://leetcode-cn.com/problems/poor-pigs

## 题目描述

```
有buckets桶液体，其中正好有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有minutesToTest分钟时间来确定哪桶液体是有毒的。

喂猪的规则如下：

选择若干活猪进行喂养
可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
小猪喝完水后，必须有minutesToDie分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
过了minutesToDie分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
重复这一过程，直到时间用完。
给你桶的数目buckets，minutesToDie和minutesToTest，返回在规定时间内判断哪个桶有毒所需的最小猪数。

示例1：

输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60
输出：5

示例2：

输入：buckets = 4, minutesToDie = 15, minutesToTest = 15
输出：2

示例3：

输入：buckets = 4, minutesToDie = 15, minutesToTest = 30
输出：2

提示：

1 <= buckets <= 1000
1 <= minutesToDie <= minutesToTest <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 数学法，待理解原理

        int states = minutesToTest / minutesToDie + 1;

        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }

}
```