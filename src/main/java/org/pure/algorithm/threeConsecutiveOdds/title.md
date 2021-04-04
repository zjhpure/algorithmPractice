## 源码路径

/src/main/java/org/pure/algorithm/threeConsecutiveOdds/Main.java

## 题目地址(存在连续三个奇数的数组)

https://leetcode-cn.com/problems/three-consecutive-odds

## 题目描述

```
给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。

示例1:

输入：arr = [2,6,4,1]
输出：false
解释：不存在连续三个元素都是奇数的情况。

示例2:

输入：arr = [1,2,34,3,4,5,7,23,12]
输出：true
解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。

提示：

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
```

## 代码

- 语言：Java

```
class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length >= 3) {
            // 若数组arr长度大于等于3，遍历数组arr
            for (int i = 2; i < arr.length; ++i) {
                // 获取前2个元素和当前元素，一共就是3个元素
                int first = arr[i - 2];
                int second = arr[i - 1];
                int third = arr[i];

                // 判断这3个元素是否都是奇数
                if (first % 2 == 1 && second % 2 == 1 && third % 2 == 1) {
                    return true;
                }
            }

            return false;
        } else {
            // 若数组arr长度小于3，那么肯定不符合连续三个元素都是奇数的情况
            return false;
        }
    }

}
```