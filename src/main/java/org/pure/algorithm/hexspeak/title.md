## 源码路径

/src/main/java/org/pure/algorithm/hexspeak/Main.java

## 题目地址(十六进制魔术数字)

https://leetcode-cn.com/problems/hexspeak

## 题目描述

```
你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字0变成字母O，将数字1变成字母I。

如果一个数字在转换后只包含{"A", "B", "C", "D", "E", "F", "I", "O"}，那么我们就认为这个转换是有效的。

给你一个字符串num，它表示一个十进制数N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回"ERROR"。

示例1:

输入：num = "257"
输出："IOI"
解释：257的十六进制表示是101。

示例2:

输入：num = "3"
输出："ERROR"

提示:

1 <= N <= 10^12
给定字符串不会有前导0。
结果中的所有字母都应该是大写字母。
```

## 代码

- 语言：Java

```
class Solution {

    // 此方法错误，当num值大于整数范围时就会溢出，导致计算错误
    public String toHexspeak(String num) {
        // 思路：字符串转为十进制数字，十进制数字转为十六进制魔术数字字符，结果是倒叙的，再把倒叙的十六进制魔术数字字符转为顺序的字符串

        // 定义十进制数字，初始为0
        int decimal = 0;
        // 定义十进制的位，初始为10^0=1
        int e = 1;

        // 字符串转为十进制
        for (int i = num.length() - 1; i >= 0; --i) {
            // 每次等于当前数字乘以十进制的位
            decimal += (num.charAt(i) - 48) * e;
            // 每次十进制的位扩大十倍
            e *= 10;
        }

        // 定义栈，保存十六进制魔术数字字符
        Stack<Character> stack = new Stack<>();

        // 定义十六进制中10-16的大写字母表示
        char[] capitalLetters = {'A', 'B', 'C', 'D', 'E', 'F'};

        // 使用取余法，十进制数字转为十六进制魔术数字字符，保存字符到栈中，结果是倒叙的
        while (decimal > 0) {
            // 每次取余
            int rem = decimal % 16;
            if (rem >= 10) {
                // 若余数在10-16之间，转为大写字母表示
                stack.push(capitalLetters[rem - 10]);
            } else if (rem == 0) {
                // 若余数是0，转为魔术数字O
                stack.push('O');
            } else if (rem == 1) {
                // 若余数是1，转为魔术数字I
                stack.push('I');
            } else {
                // 若出现其他余数，那么就不符合题目中只包含魔术数字的要求了，马上返回ERROR
                return "ERROR";
            }
            // 每次除以16缩小，直到变成0
            decimal /= 16;
        }

        // 定义字符串集合，保存十六进制魔术数字字符
        StringBuilder sb = new StringBuilder();

        // 把栈中的倒叙字符转移到字符串集合中
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 字符串集合转为字符串
        return sb.toString();
    }

}
```