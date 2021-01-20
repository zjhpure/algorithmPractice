## 源码路径

/src/main/java/org/pure/algorithm/longestCommonPre/Main.java

## 题目地址(最长公共前缀)

https://leetcode-cn.com/problems/longest-common-prefix

## 题目描述

```
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例1:

输入：strs = ["flower","flow","flight"]
输出："fl"

示例2:

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public String longestCommonPrefix(String[] strs) {
        String result = "";

        if (strs.length > 0) {
            // 字符串数组长度大于0
            if (strs.length > 1) {
                // 字符串数组长度大于1，取出第一个字符串
                String start = strs[0];

                // 构建字符串集合
                StringBuilder sb = new StringBuilder();

                // 判断标识
                boolean isPre = true;

                for (int i = 0; i < start.length(); ++i) {
                    sb.append(start.charAt(i));

                    // 遍历第一个字符串之后的字符串
                    for (int j = 1; j < strs.length; ++j) {
                        // 判断字符串是否以sb开头
                        if (!strs[j].startsWith(sb.toString())) {
                            isPre = false;
                            break;
                        }
                    }

                    // 发现前缀匹配不上时，结束
                    if (!isPre) {
                        break;
                    }
                }

                if (isPre) {
                    // 全部通过，即第一个字符串的全部就是最长公共前缀
                    result = sb.toString();
                } else {
                    // 被中断，最长公共前缀是sb减去最后一个字符
                    result = sb.deleteCharAt(sb.length() - 1).toString();
                }
            } else {
                // 字符串数组长度为1，最长公共前缀就是第一个字符串
                result = strs[0];
            }
        }

        return result;
    }

}
```