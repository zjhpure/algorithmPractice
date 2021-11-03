## 源码路径

/src/main/java/org/pure/algorithm/countingElements/Main.java

## 题目地址(数元素)

https://leetcode-cn.com/problems/counting-elements

## 题目描述

```
给你一个整数数组arr，对于元素x，只有当x + 1也在数组arr里时，才能记为1个数。

如果数组arr里有重复的数，每个重复的数单独计算。

示例1：

输入：arr = [1,2,3]
输出：2
解释：1和2被计算次数因为2和3在数组arr里。

示例2：

输入：arr = [1,1,3,3,5,5,7,7]
输出：0
解释：所有的数都不算, 因为数组里没有2、4、6、8。

示例3：

输入：arr = [1,3,2,3,5,0]
输出：3
解释：0、1、2被计算了因为1、2、3 在数组里。

示例4：

输入：arr = [1,1,2,2]
输出：2
解释：两个1被计算了因为有2在数组里。

提示:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public int countElements(int[] arr) {
        // 哈希集合法

        // 定义数量
        int count = 0;

        // 定义哈希集合，保存不重复的数
        Set<Integer> set = new HashSet<>();

        // 第一次遍历数组，统计出不重复的数，保存到哈希集合中
        for (int e : arr) {
            set.add(e);
        }

        // 第二次遍历数组，判断每个数加1是否在哈希集合中，如果在，那么记为1个数，数量加1
        for (int e : arr) {
            if (set.contains(e + 1)) {
                ++count;
            }
        }

        // 返回数量
        return count;
    }

}
```