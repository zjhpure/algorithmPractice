## 源码路径

/src/main/java/org/pure/algorithm/thousandSeparator/Main.java

## 题目地址(千位分隔数)

https://leetcode-cn.com/problems/thousand-separator

## 题目描述

```
给你一个整数n，请你每隔三位添加点(即"."符号)作为千位分隔符，并将结果以字符串格式返回。

示例1:

输入：n = 987
输出："987"

示例2:

输入：n = 1234
输出："1.234"

示例3:

输入：n = 123456789
输出："123.456.789"

示例4:

输入：n = 0
输出："0"

提示:

0 <= n < 2^31
```

## 代码

- 语言：Java

```
class Solution {

    public String thousandSeparator(int n) {
        // 模拟法

        // 若整数是0，直接返回0
        if (n == 0) {
            return "0";
        }

        // 定义栈，保存字符串结果，因为是通过不断对1000取余和除以1000得到结果的，所以结果是倒叙的，用栈保存
        Stack<String> stack = new Stack<>();

        // 循环，不断对1000取余和除以1000
        while (n > 0) {
            // 先对1000取余获取余数
            int rem = n % 1000;
            // 再除以1000缩小，直到变为0，结束循环
            n /= 1000;
            if (n > 0) {
                // 若还没有变为0，那么还不是最后一次，这里除了把处理后的余数推进栈，还要再把点分隔符推进栈
                if (rem >= 100) {
                    // 若余数是三位数，直接原样把余数推进栈
                    stack.push(rem + "");
                } else if (rem >= 10) {
                    // 若余数是两位数，那么余数前面补一个零再推进栈
                    stack.push("0" + rem + "");
                } else {
                    // 若余数是一位数，那么余数前面补两个零再推进栈
                    stack.push("00" + rem + "");
                }
                // 把点分隔符推进栈
                stack.push(".");
            } else {
                // 若变为了0，那么已经到了最后一次，这里就没有了点分隔符，直接把余数推进栈即可
                stack.push(rem + "");
            }
        }

        // 定义字符串集合，保存最后的结果
        StringBuilder sb = new StringBuilder();

        // 循环出栈，把栈里的数据转移到字符串集合中，刚好把原来倒叙的结果变成顺序的结果
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

}
```