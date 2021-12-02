## 源码路径

/src/main/java/org/pure/algorithm/relativeRanks/Main.java

## 题目地址(相对名次)

https://leetcode-cn.com/problems/relative-ranks

## 题目描述

```
给你一个长度为n的整数数组score，其中score[i]是第i位运动员在比赛中的得分。所有得分都互不相同。

运动员将根据得分决定名次，其中名次第1的运动员得分最高，名次第2的运动员得分第2高，依此类推。运动员的名次决定了他们的获奖情况：

名次第1的运动员获金牌"Gold Medal"。
名次第2的运动员获银牌"Silver Medal"。
名次第3的运动员获铜牌"Bronze Medal"。
从名次第4到第n的运动员，只能获得他们的名次编号(即，名次第x的运动员获得编号"x")。
使用长度为n的数组answer返回获奖，其中answer[i]是第i位运动员的获奖情况。

示例1：

输入：score = [5,4,3,2,1]
输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
解释：名次为[1st, 2nd, 3rd, 4th, 5th]。

示例2：

输入：score = [10,3,8,9,4]
输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
解释：名次为[1st, 5th, 3rd, 2nd, 4th]。

提示：

n == score.length
1 <= n <= 10^4
0 <= score[i] <= 10^6
score中的所有值互不相同
```

## 代码

- 语言：Java

```
class Solution {

    public String[] findRelativeRanks(int[] score) {
        // 排序法

        // 定义原数组，先保存一份score数组
        int[] original = new int[score.length];

        // 复制score数组给original数组，避免后面对score数组排序后无法再使用数组原样
        System.arraycopy(score, 0, original, 0, score.length);

        // 对score数组升序排序
        Arrays.sort(score);

        // 定义集合，因为所有得分都互不相同，所以用集合保存数组中每个数字的下标
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历score数组，保存数组中数字的下标，注意score数组经过了升序，但是题目要的是降序，所以下标刚好是最大下标减去当前下标
        for (int i = 0; i < score.length; ++i) {
            map.put(score[i], score.length - 1 - i);
        }

        // 定义结果数组
        String[] result = new String[score.length];

        // 遍历原数组original
        for (int i = 0; i < original.length; ++i) {
            // 通过集合获取当前数字的下标
            int e = map.get(original[i]);

            // 下标为0，1，2的对应金牌、银牌、铜牌，其他的对应e+1的名次
            if (0 == e) {
                result[i] = "Gold Medal";
            } else if (1 == e) {
                result[i] = "Silver Medal";
            } else if (2 == e) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = (e + 1)+ "";
            }
        }

        // 返回结果数组
        return result;
    }

}
```