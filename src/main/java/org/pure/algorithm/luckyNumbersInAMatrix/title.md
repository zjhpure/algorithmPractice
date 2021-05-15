## 源码路径

/src/main/java/org/pure/algorithm/luckyNumbersInAMatrix/Main.java

## 题目地址(矩阵中的幸运数)

https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix

## 题目描述

```
给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。

幸运数是指矩阵中满足同时下列两个条件的元素：

在同一行的所有元素中最小
在同一列的所有元素中最大

示例1:

输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
输出：[15]
解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

示例2:

输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
输出：[12]
解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

示例3:

输入：matrix = [[7,8],[1,2]]
输出：[7]

提示：

m == matrix.length
n == matrix[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5
矩阵中的所有元素都是不同的
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> luckyNumbers (int[][] matrix) {
        // 定义列表list，保存幸运数列表
        List<Integer> list = new ArrayList<>();

        // 定义集合map，保存每行找到的最小元素
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历矩阵
        for (int[] ints : matrix) {
            // 定义每行最小元素
            int min = ints[0];
            // 定义每行最小元素下标
            int minIndex = 0;

            // 遍历矩阵每行的元素
            for (int j = 1; j < ints.length; ++j) {
                // 更新每行最小元素和每行最小元素下标
                if (ints[j] < min) {
                    min = ints[j];
                    minIndex = j;
                }
            }

            if (map.containsKey(minIndex)) {
                // 若集合map已保存有此下标的元素，判断元素是否为最大
                if (min > map.get(minIndex)) {
                    // 若当前元素更大，更新元素保存到集合map中
                    map.put(minIndex, min);
                }
            } else {
                // 若集合map没保存有此下标的元素，保存到集合map中
                map.put(minIndex, min);
            }
        }

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 定义判断是否最大的标志
            boolean isMax = true;

            // 遍历矩阵
            for (int[] ints : matrix) {
                // 比较矩阵每列的元素，判断当前元素是否是此列的最大元素
                if (ints[entry.getKey()] > entry.getValue()) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                // 若当前元素是此列的最大元素，保存到列表list中
                list.add(entry.getValue());
            }
        }

        return list;
    }

}
```