## 源码路径

/src/main/java/org/pure/algorithm/divingBoard/Main.java

## 题目地址(跳水板)

https://leetcode-cn.com/problems/diving-board-lcci

## 题目描述

```
你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

示例1:

输入：
shorter = 1
longer = 2
k = 3
输出： [3,4,5,6]
解释：
可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。

提示:

0 < shorter <= longer
0 <= k <= 100000
```

## 代码

- 语言：Java

```
class Solution {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            // 当k为0时，没有木板，没有可能的长度，返回空数组
            return new int[]{};
        }

        if (shorter == longer) {
            // 当shorter和longer相等时，只有一种可能的长度，shorter或longer乘以k就是可能的长度
            return new int[]{shorter * k};
        }

        // 定义长度数组nums，数量是k+1
        int[] nums = new int[k + 1];

        // 注意：这里的长度数组nums，需要从小到大排列

        // 长度数组nums的第一个长度是，全部木块都用shorter长度
        nums[0] = shorter * k;

        // 从1遍历到k-1，长度数组nums中间有k-2个元素，构造其中shorter和longer的分布情况
        for (int i = 1; i <= k - 1; ++i) {
            // 每个长度等于最小值加上n个longer-shorter的差，最小值时全部是shorter，每次把一个元素变为longer，最后把k-1个元素变为longer，刚好就得到除去最小值和最大值的所有长度，而且还是从小到大排列的，这里不用再一次考虑最大值减去n个longer-shorter的差的情况，因为这里得到的长度和最小值加上n个longer-shorter的差是一样的，只是顺序刚好颠倒过来
            nums[i] = nums[0] + (longer - shorter) * i;
        }

        // 长度数组nums的最后一个长度是，全部木块都用longer长度
        nums[k] = longer * k;

        // 最后返回长度数组nums
        return nums;
    }

}
```