## 源码路径

/src/main/java/org/pure/algorithm/checkIfWordEqualsSummationOfTwoWords/Main.java

## 题目地址(检查某单词是否等于两单词之和)

https://leetcode-cn.com/problems/check-if-word-equals-summation-of-two-words

## 题目描述

```
字母的 字母值 取决于字母在字母表中的位置，从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。

对某个由小写字母组成的字符串 s 而言，其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。

例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。
给你三个字符串 firstWord、secondWord 和 targetWord ，每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。

如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。

示例1:

输入：firstWord = "acb", secondWord = "cba", targetWord = "cdb"
输出：true
解释：
firstWord 的数值为 "acb" -> "021" -> 21
secondWord 的数值为 "cba" -> "210" -> 210
targetWord 的数值为 "cdb" -> "231" -> 231
由于 21 + 210 == 231 ，返回 true

示例2:

输入：firstWord = "aaa", secondWord = "a", targetWord = "aab"
输出：false
解释：
firstWord 的数值为 "aaa" -> "000" -> 0
secondWord 的数值为 "a" -> "0" -> 0
targetWord 的数值为 "aab" -> "001" -> 1
由于 0 + 0 != 1 ，返回 false

示例3:

输入：firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
输出：true
解释：
firstWord 的数值为 "aaa" -> "000" -> 0
secondWord 的数值为 "a" -> "0" -> 0
targetWord 的数值为 "aaaa" -> "0000" -> 0
由于 0 + 0 == 0 ，返回 true

提示:

1 <= firstWord.length, secondWord.length, targetWord.length <= 8
firstWord、secondWord 和 targetWord 仅由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。
```

## 代码

- 语言：Java

```
class Solution {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        // 定义10的n次幂，初始化为10的0次幂
        int e = 1;

        // 定义第一个字符串转换的整数
        int firstNum = 0;
        // 定义第二个字符串转换的整数
        int secondNum = 0;
        // 定义目标字符串转换的整数
        int targetNum = 0;

        // 遍历第一个字符串的字符，从尾到头遍历，每次都把得出的整数乘以10的n次幂，每进一位幂增加1
        for (int i = firstWord.length() - 1; i >= 0; --i) {
            firstNum += e * (firstWord.charAt(i) - 'a');
            e *= 10;
        }

        // 10的n次幂重置为10的0次幂
        e = 1;

        // 遍历第二个字符串的字符，从尾到头遍历，每次都把得出的整数乘以10的n次幂，每进一位幂增加1
        for (int i = secondWord.length() - 1; i >= 0; --i) {
            secondNum += e * (secondWord.charAt(i) - 'a');
            e *= 10;
        }

        // 10的n次幂重置为10的0次幂
        e = 1;

        // 遍历目标字符串的字符，从尾到头遍历，每次都把得出的整数乘以10的n次幂，每进一位幂增加1
        for (int i = targetWord.length() - 1; i >= 0; --i) {
            targetNum += e * (targetWord.charAt(i) - 'a');
            e *= 10;
        }

        // 最后判断第一个字符串转换的整数加第二个字符串转换的整数是否等于目标字符串转换的整数，若等于返回true，否则返回false
        return firstNum + secondNum == targetNum;
    }

}
```