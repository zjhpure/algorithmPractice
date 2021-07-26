## 源码路径

/src/main/java/org/pure/algorithm/minimumOperationsToMakeASubsequence/Main.java

## 题目地址(得到子序列的最少操作次数)

https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence

## 题目描述

```
给你一个数组target，包含若干互不相同的整数，以及另一个整数数组arr，arr可能包含重复元素。

每一次操作中，你可以在arr的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。

请你返回最少操作次数，使得target成为arr的一个子序列。

一个数组的 子序列 指的是删除原数组的某些元素(可能一个元素都不删除)，同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列，但[2,4,2]不是子序列。

示例1:

输入：target = [5,1,3], arr = [9,4,2,3,4]
输出：2
解释：你可以添加5和1，使得arr变为[5,9,4,1,2,3,4]，target为arr的子序列。

示例2:

输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
输出：3

提示：

1 <= target.length, arr.length <= 10^5
1 <= target[i], arr[i] <= 10^9
target 不包含任何重复元素。
```

## 代码

- 语言：Java

```
class Solution {

    public int minOperations(int[] target, int[] arr) {
        // 这道题的思路还不是很理解，先放着，日后还需要理解清楚

        // 数组target和数组arr的公共子序列越长，需要添加的元素个数也就越少
        // 所以最少添加的元素个数为：n - 两数组的最长公共子序列的长度

        // 定义集合map
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组target的元素，把数组target里的元素保存到集合map中
        for (int i = 0; i < target.length; ++i) {
            // 记录数组target中各个元素的下标
            map.put(target[i], i);
        }

        // 定义列表list，长度和数组arr相等
        List<Integer> list = new ArrayList<>(arr.length);

        // 遍历数组arr的元素，保存在集合map中有的元素到列表list中
        for (int value : arr) {
            if (map.containsKey(value)) {
                // 若在集合map中有此元素，保存元素在数组target中的下标到列表list中
                list.add(map.get(value));
            }
        }

        // 使用贪心+二分查找法，找到两数组的最长公共子序列的长度
        // 求原来两数组的最长公共子序列等价于求数组target的下标数组和列表list的最长公共子序列。

        // 定义两数组的公共子序列长度
        int res = 0;

        // 定义数组dp，长度为列表list的长度
        int[] dp = new int[list.size()];

        // 遍历列表list的元素
        for (int num : list) {
            // 定义头指针为0
            int start = 0;
            // 定义尾指针为当前两数组的公共子序列长度
            int end = res;

            // 当头指针小于尾指针时，循环；当头指针大于等于尾指针时，结束循环
            while (start < end) {
                // 中间指针 = 头指针 + (尾指针 -  头指针) / 2
                int mid = start + (end - start) / 2;

                if (dp[mid] < num) {
                    // 若数组dp的中间指针位置元素小于当前元素，头指针 = 中间指针 + 1
                    start = mid + 1;
                } else {
                    // 若数组dp的中间指针位置元素大于等于当前元素，尾指针 = 中间指针
                    end = mid;
                }
            }

            // 数组dp赋值为当前元素
            dp[start] = num;

            if (start == res) {
                // 若头指针等于当前两数组的公共子序列长度，两数组的公共子序列长度加1
                ++res;
            }
        }

        // 最少添加的元素个数为：n - 两数组的最长公共子序列的长度
        return target.length - res;
    }

}
```