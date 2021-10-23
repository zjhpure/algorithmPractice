## 源码路径

/src/main/java/org/pure/algorithm/constructTheRectangle/Main.java

## 题目地址(构造矩形)

https://leetcode-cn.com/problems/construct-the-rectangle

## 题目描述

```
作为一位web开发者，懂得怎样去规划一个页面的尺寸是很重要的。现给定一个具体的矩形页面面积，你的任务是设计一个长度为L和宽度为W且满足以下要求的矩形的页面。要求：

1. 你设计的矩形页面必须等于给定的目标面积。

2. 宽度W不应大于长度L，换言之，要求L >= W。

3. 长度L和宽度W之间的差距应当尽可能小。

你需要按顺序输出你设计的页面的长度L和宽度W。

示例:

输入: 4
输出: [2, 2]
解释: 目标面积是4，所有可能的构造方案有[1,4], [2,2], [4,1]。
但是根据要求2，[1,4]不符合要求; 根据要求3，[2,2]比[4,1]更能符合要求. 所以输出长度L为2，宽度W为2。

说明:

给定的面积不大于10,000,000且为正整数。
你设计的页面的长度和宽度必须都是正整数。
```

## 代码

- 语言：Java

```
class Solution {

    public int[] constructRectangle(int area) {
        // 定义最小差，长度和宽度的差，初始时长度为area，宽度为1
        int minDiff = area - 1;

        // 定义长度和宽度的数组，初始时长度为area，宽度为1
        int[] results = {area, 1};

        // 从1遍历到area的开方，i作为当前的宽度
        for (int i = 1; i * i <= area; ++i) {
            // 若面积除以当前宽度能除尽，那么作为构造方案之一
            if (area % i == 0) {
                // 计算当前长度
                int j = area / i;
                // 计算当前差，即当前长度和宽度的差
                int diff = j - i;
                // 若当前差小于最小差，那么更新最小差，更新长度和宽度的数组，注意j更长作为长度，i更短作为宽度
                if (diff < minDiff) {
                    minDiff = diff;
                    results[0] = j;
                    results[1] = i;
                }
            }
        }

        // 返回长度和宽度的数组
        return results;
    }

}
```