## 源码路径

/src/main/java/org/pure/algorithm/longestHarmoniousSubsequence/Main.java

## 题目地址(最长和谐子序列)

https://leetcode-cn.com/problems/longest-harmonious-subsequence

## 题目描述

```
和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

现在，给你一个整数数组nums，请你在所有可能的子序列中找到最长的和谐子序列的长度。

数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。

示例1：

输入：nums = [1,3,2,2,5,2,3,7]
输出：5
解释：最长的和谐子序列是[3,2,2,2,3]

示例2：

输入：nums = [1,2,3,4]
输出：2

示例3：

输入：nums = [1,1,1,1]
输出：0

提示：

1 <= nums.length <= 2 * 10^4
-10^9 <= nums[i] <= 10^9
```

## 代码

- 语言：Java

```
class Solution {

    public int findLHS(int[] nums) {
        // 哈希表法

        // 定义集合map，保存数组中每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，统计数组中每个数字出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 定义最长的和谐子序列的长度
        int maxLength = 0;

        // 遍历集合map中的key
        for (int key : map.keySet()) {
            // 寻找是否存在比当前key大1的key，因为和谐子序列是最大值和最小值的差正好是1
            if (map.containsKey(key + 1)) {
                // 当前和谐子序列的长度是key的次数和key+1的次数之和，因为子序列不一定连续，所以任意两个最大值和最小值都可以去构造出和谐子序列
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1));
            }
        }

        // 返回最长的和谐子序列的长度
        return maxLength;
    }

}
```