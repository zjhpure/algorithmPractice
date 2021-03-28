## 源码路径

/src/main/java/org/pure/algorithm/nRepeatedElementIn2nArray/Main.java

## 题目地址(重复N次的元素)

https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array

## 题目描述

```
在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

返回重复了 N 次的那个元素。

示例1:

输入：[1,2,3,3]
输出：3

示例2:

输入：[2,1,2,5,3,2]
输出：2

示例3:

输入：[5,1,5,2,5,3,5,4]
输出：5

提示：

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length 为偶数
```

## 代码

- 语言：Java

```
class Solution {

    public int repeatedNTimes(int[] A) {
        // 定义集合map保存每个元素出现的次数
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // 遍历数组A
        for (int value : A) {
            if (map.containsKey(value)) {
                // 若集合map中已保存有元素，那么元素数量加1
                map.put(value, map.get(value) + 1);
            } else {
                // 若集合map中不保存有元素，那么元素数量为0
                map.put(value, 1);
            }
        }

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                // 若集合map中有元素的数量大于1，那么这个元素就是重复了N次的元素
                return entry.getKey();
            }
        }

        return 0;
    }

}
```