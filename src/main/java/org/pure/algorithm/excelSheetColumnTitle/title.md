## 源码路径

/src/main/java/org/pure/algorithm/excelSheetColumnTitle/Main.java

## 题目地址(Excel表列名称)

https://leetcode-cn.com/problems/excel-sheet-column-title

## 题目描述

```
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

示例1:

输入: 1
输出: "A"

示例2:

输入: 28
输出: "AB"

示例3:

输入: 701
输出: "ZY"
```

## 代码

- 语言：Java

```
class Solution {

    public String convertToTitle(int columnNumber) {
        // 10进制转26进制

        // 定义字符串集合sb
        StringBuilder sb = new StringBuilder();

        // 对列号columnNumber循环除以26，直到0
        while (columnNumber > 0) {
            // 先自减1，这一步很关键，因为如果不先自减1，遇到刚好除以26除得尽的数会出错，例如输入52，52对26取余是0，0加上字符A的ASCII还是字符A，但是输入52的结果是AZ，最后一位字符是字符Z，不是字符A
            --columnNumber;
            // 列号columnNumber对26取余，加上字符A的ASCII码，再整体转为字符char，得到倒数第n位的字符
            sb.append((char) (columnNumber % 26 + 'A'));
            // 列号columnNumber除以26
            columnNumber /= 26;
        }

        // 字符串集合sb反转后转为字符串，返回结果
        return sb.reverse().toString();
    }

}
```