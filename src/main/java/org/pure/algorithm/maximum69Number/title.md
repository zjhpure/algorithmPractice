## 源码路径

/src/main/java/org/pure/algorithm/maximum69Number/Main.java

## 题目地址(6和9组成的最大数字)

https://leetcode-cn.com/problems/maximum-69-number

## 题目描述

```
给你一个仅由数字 6 和 9 组成的正整数 num。

你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。

请返回你可以得到的最大数字。

示例1:

输入：num = 9669
输出：9969
解释：
改变第一位数字可以得到 6669 。
改变第二位数字可以得到 9969 。
改变第三位数字可以得到 9699 。
改变第四位数字可以得到 9666 。
其中最大的数字是 9969 。

示例2:

输入：num = 9996
输出：9999
解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。

示例3:

输入：num = 9999
输出：9999
解释：无需改变就已经是最大的数字了。

提示：

1 <= num <= 10^4
num 每一位上的数字都是 6 或者 9 。
```

## 代码

- 语言：Java

```
class Solution {

    public int maximum69Number (int num) {
        // 定义列表list，保存所有可能的数字
        List<Integer> list = new ArrayList<>();

        // 列表list先添加整数num
        list.add(num);

        // 真实的尾部部分
        int trueTail = 0;

        // 翻转后的尾部部分
        int tail;

        // 幂
        int power = 1;

        // 循环获取位数的值
        while (num > 0) {
            // 整数num对10取余获取位数的值
            int res = num % 10;
            // 定义翻转后的值
            int replaceRes;
            // 获取翻转后的值，6变成9，9变成6
            if (res == 6) {
                replaceRes = 9;
            } else {
                replaceRes = 6;
            }
            // 先获取翻转后的尾部部分
            tail = trueTail + replaceRes * power;
            // 再获取真实的尾部部分
            trueTail += res * power;
            // 幂累乘
            power *= 10;
            // 整数num除以10减少一位
            num = num / 10;
            // 通过当前整数num*幂+翻转后的尾部部分得到翻转后的整数
            list.add((num * power) + tail);
        }

        // 初始化最大值
        int max = list.get(0);

        // 循环列表list，寻找出最大值
        for (int e : list) {
            if (e > max) {
                max = e;
            }
        }

        return max;
    }

}
```