## 源码路径

/src/main/java/org/pure/algorithm/fourDivisors/Main.java

## 题目地址(四因数)

https://leetcode-cn.com/problems/four-divisors

## 题目描述

```
给你一个整数数组nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。

如果数组中不存在满足题意的整数，则返回0。

示例:

输入：nums = [21,4,7]
输出：32
解释：
21有4个因数：1, 3, 7, 21
4有3个因数：1, 2, 4
7有2个因数：1, 7
答案仅为21的所有因数的和。

提示:

1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5
```

## 代码

- 语言：Java

```
class Solution {

    public int sumFourDivisors(int[] nums) {
        // 枚举法，遍历数组nums，逐个判断元素是否符合四因数的条件，符合条件的各因数相加，最后把它们的和再相加

        // 定义所有符合条件的整数的各因数之和
        int sumTotal = 0;

        // 遍历数组nums
        for (int num : nums) {
            // 定义单个整数的各因数之和
            int sumNum = 0;
            // 定义单个整数的各因数数量
            int countNum = 0;

            // 从1遍历到整数的开方，因为开方之后的因数都是和前面部分的因数成对出现的
            for (int i = 1; i * i <= num; ++i) {
                // 通过取余是否等于0判断是否是因数
                if (num % i == 0) {
                    // 取和这个因数匹对的另一个因数
                    int divide = num / i;

                    if (i == divide) {
                        // 若两个因数相等，那么因数数量只算作一个，各因数之和只累加一个因数，例如4 = 2 * 2
                        ++countNum;
                        sumNum += i;
                    } else {
                        // 若两个因数不相等，那么另一个因数在开方之后的那边，因数数量有两个，各因数之和也累加两个因数
                        countNum += 2;
                        sumNum += i;
                        sumNum += divide;
                    }

                    if (countNum > 4) {
                        // 若因数数量超过了4个，那么这个数肯定不符合四个因数的条件了，直接结束循环
                        break;
                    }
                }
            }

            if (countNum == 4) {
                // 只有刚好四个因数的数才是符合条件的，把单个整数的各因数之和累加到所有符合条件的整数的各因数之和
                sumTotal += sumNum;
            }
        }

        // 最后返回所有符合条件的整数的各因数之和
        return sumTotal;
    }

}
```