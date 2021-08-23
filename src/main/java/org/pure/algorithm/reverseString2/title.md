## 源码路径

/src/main/java/org/pure/algorithm/reverseString2/Main.java

## 题目地址(反转字符串II)

https://leetcode-cn.com/problems/reverse-string-ii

## 题目描述

```
给定一个字符串s和一个整数k，从字符串开头算起，每2k个字符反转前k个字符。

如果剩余字符少于k个，则将剩余字符全部反转。
如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样。

示例1:

输入：s = "abcdefg", k = 2
输出："bacdfeg"

示例2:

输入：s = "abcd", k = 2
输出："bacd"

提示：

1 <= s.length <= 10^4
s 仅由小写英文组成
1 <= k <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public String reverseStr(String s, int k) {
        // 理解题意：每反转k个隔k个，末尾不够k个时全部反转

        // 把字符串转为字符数组
        char[] arr = s.toCharArray();

        // 字符串长度除以2k，获取2k的初步个数
        int n = s.length() / (2 * k);
        
        if (s.length() % (2 * k) > 0) {
            // 对2k取余，若余数大于0，那么字符串最后的一段不够2k，2k的个数加1得到修正后的个数，因为前面的除以2k是不算上最后不够2k的那段的
            ++n;
        }

        // 从0开始遍历到2k的个数减1，每次遍历进行一段字符的反转
        for (int i = 0; i < n; ++i) {
            // 左指针是2k的i倍
            int left = i * 2 * k;

            // 右指针是左指针加k减1，如果已经超出字符串边界，那么就是字符串最右侧的下标
            int right = left + k < s.length() ? left + k - 1 : s.length() - 1;

            // 使用双指针实现字符的反转，循环，当左指针大于等于右指针时，结束循环
            while (left < right) {
                // 若左指针小于右指针时，交换左右指针下标的两个字符
                swap(arr, left, right);
                // 左指针加1
                ++left;
                // 右指针减1
                --right;
            }
        }

        // 把字符数组转为字符串，返回结果
        return new String(arr);
    }

    // 交换字符数组中的两个字符
    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
```