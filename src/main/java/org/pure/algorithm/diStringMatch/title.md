## 源码路径

/src/main/java/org/pure/algorithm/diStringMatch/Main.java

## 题目地址(增减字符串匹配)

https://leetcode-cn.com/problems/di-string-match

## 题目描述

```
给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]

示例1:

输入："IDID"
输出：[0,4,1,3,2]

示例2:

输入："III"
输出：[0,1,2,3]

示例3:

输入："DDI"
输出：[3,2,0,1]

提示:

1 <= S.length <= 10000
S 只包含字符 "I" 或 "D"。
```

## 代码

- 语言：Java

```
class Solution {

    public int[] diStringMatch(String s) {
        // 注意：这里不用重复使用数字，使用的数字范围是0-S.length()

        // 定义数组nums，长度为字符串s的长度加1
        int[] nums = new int[s.length() + 1];

        // 定义最小值min，初始值为0
        int min = 0;

        // 定义最大值max，初始值为字符串长度
        int max = s.length();

        // 遍历字符串s的字符，构造数组nums的前n-1个字符
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'I') {
                // 若是增大，那就是后一个数即将要增大，那么这个位置就要取当前最小的数，因为只有取了当前最小的数，在下一个位置才能保证可以增大
                nums[i] = min;
                // 赋值完，马上使当前最小值加1，因为数字不能重复使用
                ++min;
            } else {
                // 若是减小，那就是后一个数即将要减小，那么这个位置就要取当前最大的数，因为只有取了当前最大的数，在下一个位置才能保证可以减小
                nums[i] = max;
                // 赋值完，马上使当前最大值减1，因为数字不能重复使用
                --max;
            }
        }

        // 构造数组nums的第n个字符，这里赋值为min或max都可以，因为经过遍历后，min自增，max自减，到最后都是剩下刚好没有用到的那个数字
        nums[s.length()] = min;

        return nums;
    }

}
```