## 源码路径

/src/main/java/org/pure/algorithm/decompressRunLengthEncodedList/Main.java

## 题目地址(解压缩编码列表)

https://leetcode-cn.com/problems/decompress-run-length-encoded-list

## 题目描述

```
给你一个以行程长度编码压缩的整数列表 nums 。

考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

请你返回解压后的列表。

示例1:

输入：nums = [1,2,3,4]
输出：[2,4,4,4]
解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。

示例2:

输入：nums = [1,1,2,3]
输出：[1,3,3]

提示:

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int[] decompressRLElist(int[] nums) {
        // 定义列表list，保存解压后的列表
        List<Integer> list = new ArrayList<>();

        // 遍历数组nums，只遍历奇数下标
        for (int i = 1; i < nums.length; i += 2) {
            // 奇数下标的前一个元素表示数量，遍历数量
            for (int j = 0; j < nums[i - 1]; ++j) {
                // 每次添加奇数下标的元素到列表list中
                list.add(nums[i]);
            }
        }

        // 定义结果数组
        int[] results = new int[list.size()];

        // 把解压后的列表转为结果数组
        for (int i = 0; i < list.size(); ++i) {
            results[i] = list.get(i);
        }

        return results;
    }

}
```