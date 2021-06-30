## 源码路径

/src/main/java/org/pure/algorithm/excelSheetColumnNumber/Main.java

## 题目地址(Excel表列序号)

https://leetcode-cn.com/problems/excel-sheet-column-number

## 题目描述

```
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

示例1:

输入: "A"
输出: 1

示例2:

输入: "AB"
输出: 28

示例3:

输入: "ZY"
输出: 701
```

## 代码

- 语言：Java

```
class Solution {

    public int titleToNumber(String columnTitle) {
        // 26进制转10进制

        // 定义结果，初始为0
        int sum = 0;
        // 定义26的指数结果，初始为26^0=1
        int e = 1;

        // 遍历字符串columnTitle的字符，从尾到头
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            // 当前字符减去字符A加1，等于这个位上的数值，再乘上26的指数结果，等于这个位转换出的数值
            // 例如：AB = 2 ^ 26 ^ 0 + 1 ^ 26 ^ 1 = 28
            sum += (columnTitle.charAt(i) - 'A' + 1) * e;
            // 26的指数结果增加一次幂
            e *= 26;
        }

        // 最后返回结果
        return sum;
    }

}
```