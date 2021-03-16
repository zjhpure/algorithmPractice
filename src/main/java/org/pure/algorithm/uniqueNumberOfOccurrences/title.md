## 源码路径

/src/main/java/org/pure/algorithm/uniqueNumberOfOccurrences/Main.java

## 题目地址(独一无二的出现次数)

https://leetcode-cn.com/problems/unique-number-of-occurrences

## 题目描述

```
给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

示例1:

输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。

示例2:

输入：arr = [1,2]
输出：false

示例3:

输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
输出：true

提示:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        // 定义map集合
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组arr
        for (int e : arr) {
            if (map.containsKey(e)) {
                // 若map集合中已有数组元素，元素出现次数加1
                int count = map.get(e);
                map.put(e, ++count);
            } else {
                // 若map集合中没有数组元素，推进map集合，元素出现次数为1
                map.put(e, 1);
            }
        }

        // 定义list列表，保存元素出现次数
        List<Integer> list = new ArrayList<>();

        // 遍历map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 获取元素出现次数
            int value = entry.getValue();

            if (list.contains(value)) {
                // 若有一个元素出现次数相同，那么次数就不是独一无二了
                return false;
            } else {
                // 若元素出现次数没有和其他元素出现次数相同，推进list列表
                list.add(value);
            }
        }

        // 若能遍历完map集合，则证明没有一个元素出现次数相同，次数是独一无二的
        return true;
    }

}
```