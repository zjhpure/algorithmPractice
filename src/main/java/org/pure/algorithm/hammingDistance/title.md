## 源码路径

/src/main/java/org/pure/algorithm/hammingDistance/Main.java

## 题目地址(汉明距离)

https://leetcode-cn.com/problems/hamming-distance

## 题目描述

```
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 2^31.

示例1:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
```

## 代码

- 语言：Java

```
class Solution {

    public int hammingDistance(int x, int y) {
        // 先对x和y进行异或操作，异或后如果同一个位的值不同，就会等于1，所以会获得表示汉明距离的二进制数，此数中所有1的位的数目就是汉明距离
        int xor = x ^ y;

        // 定义1的位的数目
        int num = 0;

        // 循环统计num的值，循环一次统计出一次1的位，但是这里循环次数是固定的，因为整数的位数固定
        while (xor != 0) {
            // 每次循环num的值加1
            ++num;
            
            // xor-1后，第一个最右边的1会变为0，从这个位置之后的右边的都会变为0，而位与&运算是只有两个位都为1时，才会得到1，所有结果就是原来的xor去掉最右边的1，每次去掉一个最右边的1，直到去掉完，最后变成0
            xor = xor & (xor - 1);
        }

        return num;
    }

}
```