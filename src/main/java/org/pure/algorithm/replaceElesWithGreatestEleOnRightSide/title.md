## 源码路径

/src/main/java/org/pure/algorithm/replaceElesWithGreatestEleOnRightSide/Main.java

## 题目地址(将每个元素替换为右侧最大元素)

https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side

## 题目描述

```
给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。

完成所有替换操作后，请你返回这个数组。

示例1:

输入：arr = [17,18,5,4,6,1]
输出：[18,6,6,6,1,-1]
解释：
- 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
- 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
- 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
- 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
- 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
- 下标 5 的元素 --> 右侧没有其他元素，替换为 -1

示例2:

输入：arr = [400]
输出：[-1]
解释：下标 0 的元素右侧没有其他元素。

提示：

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
```

## 代码

- 语言：Java

```
class Solution {

    public int[] replaceElements(int[] arr) {
        // 定义结果数组results
        int[] results = new int[arr.length];

        // 遍历数组arr
        for (int i = 0; i < arr.length; ++i) {
            // 定义元素右侧最大元素
            int max = -1;

            // 遍历元素右侧元素
            for (int j = i + 1; j < arr.length; ++j) {
                // 更新元素右侧最大元素
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            // 结果数组设置右侧最大元素
            results[i] = max;
        }

        return results;
    }

}
```