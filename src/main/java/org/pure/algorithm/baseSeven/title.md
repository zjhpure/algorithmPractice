## 源码路径

/src/main/java/org/pure/algorithm/baseSeven/Main.java

## 题目地址(七进制数)

https://leetcode-cn.com/problems/base-7

## 题目描述

```
给定一个整数，将其转化为7进制，并以字符串形式输出。

示例1:

输入: 100
输出: "202"

示例2:

输入: -7
输出: "-10"

注意:

输入范围是 [-1e7, 1e7]。
```

## 代码

- 语言：Java

```
class Solution {

    public String convertToBase7(int num) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            // 如果num是0，对应的7进制也是0
            sb.append("0");
            return sb.toString();
        }

        // 定义是否负数的标志
        boolean isNegative = num < 0;

        // 通过辗转相除法循环判断num是否为0
        while (num != 0) {
            // 取除以7的余数
            int rem = num % 7;
            if (rem < 0) {
                // 若余数小于0，乘以-1变成对于的正数
                rem = rem * -1;
            }
            // 添加余数结果到字符串集合中
            sb.append(rem);
            // // 这里记录一下，如果这样写，执行用时会明显上升，大概在7ms-9ms之间，但是如果直接是sb.append(rem)，执行用时都是1ms，原因不明，待研究
            // sb.append(rem + "");
            // num除以7
            num /= 7;
        }

        // 定义字符串集合，保存返回的结果
        StringBuilder sbRes = new StringBuilder();

        if (isNegative) {
            // 如果num原先是负数，字符串集合sbRes添加上负号
            sbRes.append("-");
        }

        // 遍历字符串集合sb，从尾到头，因为辗转相除法得到的结果是倒过来的
        for (int i = sb.length() - 1; i >= 0; --i) {
            // 把字符串集合sb倒过来的结果保存到字符串集合sbRes中
            sbRes.append(sb.charAt(i));
        }

        // 字符串集合sbRes转为字符串，返回字符串结果
        return sbRes.toString();
    }

}
```