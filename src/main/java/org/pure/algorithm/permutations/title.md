## 源码路径

/src/main/java/org/pure/algorithm/permutations/Main.java

## 题目地址(全排列)

https://leetcode-cn.com/problems/permutations

## 题目描述

```
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例1:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## 代码

- 语言：Java

```
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        // 定义结果列表
        List<List<Integer>> list = new ArrayList<>();

        // 定义每条结果列表
        List<Integer> itemList = new ArrayList<>();

        // 调用排列函数，初始层数0
        arrange(list, itemList, nums, 0);

        return list;
    }

    // 排列函数，递归，回溯算法
    // 想象成树，遍历数组nums就是以哪个元素开头，用一个列表保存每次排列的结果，找到一次结果后删除最后元素进行回溯，逐步向上回溯
    private void arrange(List<List<Integer>> list, List<Integer> itemList, int[] nums, int n) {
        if (n == nums.length) {
            // 若层数达到了数组nums的长度，结果列表添加元素，结束函数
            list.add(new ArrayList<>(itemList));
            return;
        }

        // 遍历数组nums
        for (int num : nums) {
            if (itemList.contains(num)) {
                // 重复元素不添加，直接跳过
                continue;
            }

            // 每条结果列表添加元素
            itemList.add(num);

            // 递归调用，n增加一层
            arrange(list, itemList, nums, n + 1);

            // 每条结果列表去掉最后一个元素，进行回溯
            itemList.remove(itemList.size() - 1);
        }
    }

}
```