## 源码路径

/src/main/java/org/pure/algorithm/addBinary/Main.java

## 题目地址(二进制求和)

https://leetcode-cn.com/problems/add-binary

## 题目描述

```
给你两个二进制字符串，返回它们的和(用二进制表示)。

输入为非空字符串且只包含数字1和0。

示例1:

输入: a = "11", b = "1"
输出: "100"

示例2:

输入: a = "1010", b = "1011"
输出: "10101"

提示:

每个字符串仅由字符'0'或'1'组成。
1 <= a.length, b.length <= 10^4
字符串如果不是"0"，就都不含前导零。
```

## 代码

- 语言：Java

```
class Solution {

    public String addBinary(String a, String b) {
        // 思路：模拟竖式计算，从字符串的结尾遍历到字符串的开头，满2进1位

        // 定义字符串集合sb，用来保存二进制求和后的结果
        StringBuilder sb = new StringBuilder();

        // 取字符串a和字符串b中较长的长度
        int length = Math.max(a.length(), b.length());

        // 定义进位，初始为0
        int carry = 0;

        // 从0遍历到字符串中的最大下标，取字符时从字符串结尾开始取
        for (int i = 0; i < length; ++i) {
            if (i < a.length()) {
                // 若当前下标还在字符串a中，取字符串a倒数第i+1个字符，通过减去0的ASCII码得到当前数字，当前数字只会是0或1，把当前数字累加到进位carry里
                carry += a.charAt(a.length() - 1 - i) - '0';
            }

            if (i < b.length()) {
                // 若当前下标还在字符串b中，取字符串b倒数第i+1个字符，通过减去0的ASCII码得到当前数字，当前数字只会是0或1，把当前数字累加到进位carry里
                carry += b.charAt(b.length() - 1 - i) - '0';
            }

            // 获取进位carry除以2的余数，再把数字加上0的ASCII得到余数的ASCII码，再强转为char类型，这里得到结果只会是0或1，因为carry是两个字符串同一个位上相加的结果，只可能是0、1、2、3其中一个，对于二进制取余就是对2取余，对于十进制取余就是对10取余，例如11取余就是1，向前进1位，对于二进制，例如2取余就是0，向前进1位
            sb.append((char)(carry % 2 + '0'));

            // 进位除以2，得到进位的数，此数在下一对竖式相加时会用到，正好模拟了竖式计算中的进位计算
            carry /= 2;
        }

        if (carry > 0) {
            // 如果前面还有进位的数，那么需要补充1，例如：11 + 10 = 101，前面的for循环只计算了出了01的反转10，但是在计算最后的位时是1+1=2，向前进1位，carry除以2等于1，得到进位的数，这时还需要补充一个1来填补进位，得到101，反转后就是101
            sb.append('1');
        }

        // 因为是从字符串的末尾开始计算的，所以得到的字符串集合sb是反转过来的，这里把sb再反转一次，得到原来的结果
        sb.reverse();

        // 字符串集合sb转为字符串返回
        return sb.toString();
    }

}
```