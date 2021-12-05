## 源码路径

/src/main/java/org/pure/algorithm/superPow/Main.java

## 题目地址(超级次方)

https://leetcode-cn.com/problems/super-pow

## 题目描述

```
你的任务是计算ab对1337取模，a是一个正整数，b是一个非常大的正整数且会以数组形式给出。

示例1：

输入：a = 2, b = [3]
输出：8

示例2：

输入：a = 2, b = [1,0]
输出：1024

示例3：

输入：a = 1, b = [4,3,3,8,5,2]
输出：1

示例4：

输入：a = 2147483647, b = [2,0,0]
输出：1198

提示：

1 <= a <= 2^31 - 1
1 <= b.length <= 2000
0 <= b[i] <= 9
b不含前导0
```

## 代码

- 语言：Java

```
class Solution {

    // 倒叙遍历，乘法取模分配律，待理解原理

    // (a * b) % m=[(a % m)⋅(b % m)] % m

    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;

        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }

        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;

        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }

        return res;
    }

}
```