## 源码路径

/src/main/java/org/pure/algorithm/pascalsTriangle/Main.java

## 题目地址(杨辉三角)

https://leetcode-cn.com/problems/pascals-triangle

## 题目描述

![杨辉三角](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

```
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例1:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## 代码

- 语言：Java

```
class Solution {

    public List<List<Integer>> generate(int numRows) {
        // 定义杨辉三角列表
        List<List<Integer>> dataList = new ArrayList<>();

        // 构造杨辉三角，每次构造一行
        for (int i = 0; i < numRows; ++i) {
            // 定义杨辉三角单行列表
            List<Integer> list = new ArrayList<>();

            // 第一列
            list.add(1);

            if (i > 0) {
                // 第一行之后
                // 获取上一行的结果
                List<Integer> listTemp = dataList.get(i - 1);

                // 遍历上一行的结果，从第二列到最后一列
                for (int j = 1; j < listTemp.size(); ++j) {
                    // 若不是第一列和最后一列，第n行第m列等于上一行第m-1列+第m列
                    list.add(listTemp.get(j - 1) + listTemp.get(j));
                }

                // 最后一列
                list.add(1);

                dataList.add(list);
            } else {
                // 第一行
                dataList.add(list);
            }
        }

        return dataList;
    }

}
```