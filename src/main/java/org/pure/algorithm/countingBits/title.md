## 源码路径

/src/main/java/org/pure/algorithm/countingBits/Main.java

## 题目地址(比特位计数)

https://leetcode-cn.com/problems/counting-bits

## 题目描述

```
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例1:

输入: 2
输出: [0,1,1]

示例2:

输入: 5
输出: [0,1,1,2,1,2]

进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
```

## 代码

- 语言：Java

```
class Solution {

    public int[] countBits(int num) {
        // 定义数组arrays，长度为num加1，因为包括0
        int[] arrays = new int[num + 1];

        // 从0遍历到num
        for (int i = 0; i <= num; ++i) {
            // 定义二进制数为1的统计数目，初始为0
            int count = 0;

            // 先把数字赋给另外一个变量
            int n = i;

            // 通过逐位移动法，即布赖恩·克尼根算法，统计出这个数中比特位为1的数目
            while (n != 0) {
                // 每次循环统计数目加1
                ++count;

                // n-1后，第一个最右边的1会变为0，从这个位置之后的右边的都会变为0，而位与&运算是只有两个位都为1时，才会得到1，所以结果就是原来的n去掉最右边的1，每次去掉一个最右边的1，直到去掉完，最后变成0
                n = n & (n - 1);
            }

            arrays[i] = count;
        }

        return arrays;
    }

}
```