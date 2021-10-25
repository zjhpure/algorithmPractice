## 源码路径

/src/main/java/org/pure/algorithm/longestPalindromicSubstring/Main.java

## 题目地址(最长回文子串)

https://leetcode-cn.com/problems/longest-palindromic-substring

## 题目描述

```
给你一个字符串s，找到s中最长的回文子串。

示例1:

输入：s = "babad"
输出："bab"
解释："aba"同样是符合题意的答案。

示例2:

输入：s = "cbbd"
输出："bb"

示例3:

输入：s = "a"
输出："a"

示例4:

输入：s = "ac"
输出："a"

提示：

1 <= s.length <= 1000
s仅由数字和英文字母(大写和/或小写)组成
```

## 代码

- 语言：Java

```
class Solution {

    public String longestPalindrome(String s) {
        // 动态规划法，用i和j分别表示子串的起始下标和结束下标，两边都是闭合区间，那么状态转移方程：dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j - 1])，即如果要判断一个子串是回文子串，那么就等同于判断起始下标i的字符是否等于结束下标j的字符，以及判断起始下标i和结束下标j相减的差是否小于3或者这个子串前后各自往回一个的字符串是否为回文子串，这里关键就是可以通过较短的子串来判断较长的子串是否为回文子串，即可以用前面的结果来判断后面的结果
        // 可以想象成一个boolean类型的二维数组，长和宽都是字符串s的长度，宽用i，代表回文子串的起始下标，长用j，代表回文子串的结束下标，这个二维数组的对角线，即起始下标的字符和结束下标的字符相等，肯定是回文子串，所以i==j的地方可以先填上true，再通过状态转移方程：dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i + 1][j - 1])，可以推导出其他位置的值，其实二维数组只需要填入一半即可，对角线往一个方向的数据填上即可，因为另一个方向的数据是一样的，例如：[1,3]和[3,1]是一样的，严格来说[3,1]不合法，因为结束下标必须大于等于起始下标，所以实际上二维数组只需要填上一半的数据

        // 获取字符串s的长度
        int len = s.length();

        if (len < 2) {
            // 若字符串s的长度小于2，那么自身就是最长回文子串
            return s;
        }

        // 定义最长回文子串的长度，初始为1
        int maxLen = 1;
        // 定义最长回文子串的起始下标，初始为0
        int begin = 0;

        // dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 初始化二维数组，把能马上判断出来都先填上，所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            // 所有对角线的数据都是回文串
            dp[i][i] = true;
        }

        // 把字符串s转为字符数组
        char[] charArray = s.toCharArray();

        // 递推开始，一列一列来，先枚举结束下标j，从1开始，因为[0,0]在前面已经确定了下来
        for (int j = 1; j < len; ++j) {
            // 再枚举起始下标i，起始下标小于结束下标
            for (int i = 0; i < j; ++i) {
                if (charArray[i] != charArray[j]) {
                    // 若起始下标i的字符不等于结束下标j的字符，那么这个子串不是回文子串
                    dp[i][j] = false;
                } else {
                    // 若起始下标i的字符等于结束下标j的字符，进行进一步的判断
                    if (j - i < 3) {
                        // 若起始下标i和结束下标j相减的差小于3，即他们相隔小于2，即他们之间只有一个字符或者没有字符，那么这个子串是回文子串
                        dp[i][j] = true;
                    } else {
                        // 若起始下标i和结束下标j相减的差大于等于3，那么这个子串是否为回文子串就由这个子串前后各自往回一个的字符串是否为回文子串决定，若各自往回一个的字符串是回文子串，那么这个子串也是回文子串，否则这个子串就不是回文子串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j]为true，就表示子串s[i..j]是回文子串，更新回文子串的起始下标和长度
                if (dp[i][j] && j - i + 1 > maxLen) {
                    // 更新回文子串的长度
                    begin = i;
                    // 更新回文子串的长度
                    maxLen = j - i + 1;
                }
            }
        }

        // 字符串s从起始下标开始，截取最大长度maxLen，就是最长回文子串
        return s.substring(begin, begin + maxLen);
    }

}
```