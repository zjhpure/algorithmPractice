## 源码路径

/src/main/java/org/pure/algorithm/findLuckyIntInArray/Main.java

## 题目地址(找出数组中的幸运数)

https://leetcode-cn.com/problems/find-lucky-integer-in-an-array

## 题目描述

```
在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。

给你一个整数数组 arr，请你从中找出并返回一个幸运数。

如果数组中存在多个幸运数，只需返回 最大 的那个。
如果数组中不含幸运数，则返回 -1 。

示例1:

输入：arr = [2,2,3,4]
输出：2
解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。

示例2:

输入：arr = [1,2,2,3,3,3]
输出：3
解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。

示例3:

输入：arr = [2,2,2,3,3]
输出：-1
解释：数组中不存在幸运数。

示例4:

输入：arr = [5]
输出：-1

示例5:

输入：arr = [7,7,7,7,7,7,7]
输出：7

提示:

1 <= arr.length <= 500
1 <= arr[i] <= 500
```

## 代码

- 语言：Java

```
class Solution {

    public int findLucky(int[] arr) {
        // 定义集合map，保存每种数字的个数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组arr
        for (int e : arr) {
            if (map.containsKey(e)) {
                // 若集合map中已保存有这种数字，这种数字的个数加1
                map.put(e, map.get(e) + 1);
            } else {
                // 若集合map中无保存有这种数字，这种数字的个数设为1
                map.put(e, 1);
            }
        }

        // 定义最大幸运数
        int maxLucky = -1;

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 获取集合map中每个元素的key值
            int key = entry.getKey();

            // 若每个元素的key值和每个元素的value值相等，那么就是找到了幸运数
            if (key == entry.getValue()) {
                if (key > maxLucky) {
                    // 更新最大幸运数
                    maxLucky = key;
                }
            }
         }

         return maxLucky;
    }

}
```