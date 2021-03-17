## 源码路径

/src/main/java/org/pure/algorithm/findNumsWithEvenNumOfDigits/Main.java

## 题目地址(统计位数为偶数的数字)

https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits

## 题目描述

```
给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。

示例1:

输入：nums = [12,345,2,6,7896]
输出：2
解释：
12 是 2 位数字（位数为偶数） 
345 是 3 位数字（位数为奇数）  
2 是 1 位数字（位数为奇数） 
6 是 1 位数字 位数为奇数） 
7896 是 4 位数字（位数为偶数）  
因此只有 12 和 7896 是位数为偶数的数字

示例2:

输入：nums = [555,901,482,1771]
输出：1 
解释： 
只有 1771 是位数为偶数的数字。

提示:

1 <= nums.length <= 500
1 <= nums[i] <= 10^5
```

## 代码

- 语言：Java

```
class Solution {

    public int findNumbers(int[] nums) {
        // 定义位数为偶数的数字个数
        int time = 0;

        // 遍历数组nums
        for (int num : nums) {
            // 定义位数
            int count = 0;

            // 计算数组元素的位数，通过循环除10直到0算出位数
            while (num > 0) {
                num = num / 10;
                ++count;
            }

            // 除2等于0的是偶数
            if (count % 2 == 0) {
                ++time;
            }
        }

        return time;
    }

}
```