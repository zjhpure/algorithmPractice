## 源码路径

/src/main/java/org/pure/algorithm/monotonicArray/Main.java

## 题目地址(单调数列)

https://leetcode-cn.com/problems/monotonic-array

## 题目描述

```
如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。

示例1:

输入：[1,2,2,3]
输出：true

示例2:

输入：[6,5,4,4]
输出：true

示例3:

输入：[1,3,2]
输出：false

示例4:

输入：[1,2,4,5]
输出：true

示例5:

输入：[1,1,1]
输出：true

提示：

1 <= A.length <= 50000
-100000 <= A[i] <= 100000
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isMonotonic(int[] A) {
        if (A.length > 2) {
            // 数组长度大于2的才进行判断，长度小于等于2的都是单调数列
            // 定义另一个数组B，保存数组A中相隔的两数的差列表
            int[] B = new int[A.length - 1];

            // 遍历数组A，从第2个元素开始，到最后1个元素结束
            for (int i = 1; i < A.length; ++i) {
                B[i - 1] = A[i] - A[i - 1];
            }

            // 是否要递增判断
            boolean isAdd = false;

            // 遍历数组B
            for (int value : B) {
                if (value > 0) {
                    // 若有大于0的差，那么进行递增的判断
                    isAdd = true;
                    break;
                }
            }

            // 再次遍历数组B
            for (int value : B) {
                if (isAdd) {
                    // 若是递增判断
                    if (value < 0) {
                        // 若递增判断中出现负数差，那么就不是单调数列了
                        return false;
                    }
                } else {
                    // 若是递减判断
                    if (value > 0) {
                        // 若递减判断中出现正数差，那么就不是单调数列了
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
```