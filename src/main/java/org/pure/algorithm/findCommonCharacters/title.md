## 源码路径

/src/main/java/org/pure/algorithm/findCommonCharacters/Main.java

## 题目地址(查找常用字符)

https://leetcode-cn.com/problems/find-common-characters

## 题目描述

```
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

示例1:

输入：["bella","label","roller"]
输出：["e","l","l"]

示例2:

输入：["cool","lock","cook"]
输出：["c","o"]

提示:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母
```

## 代码

- 语言：Java

```
class Solution {

    public List<String> commonChars(String[] A) {
        // 定义字符串列表list
        List<String> list = new ArrayList<>();

        // 遍历字符串数组A的第一个字符串的字符
        for (int i = 0; i < A[0].length(); ++i) {
            // 取第一个字符串的字符
            char c = A[0].charAt(i);
            // 定义是否在后面的字符串找到此字符的标志
            boolean isFind = true;

            // 遍历字符串数组A第二个字符串到最后一个字符串
            for (int j = 1; j < A.length; ++j) {
                if (A[j].indexOf(c) <= -1) {
                    // 如果字符串中没有包含字符，那么标志为没有找到，结束循环
                    isFind = false;
                    break;
                } else {
                    // 如果字符串中包含字符，那么就是找到了，找到后把找到的字符替换为空，因为有可能会出现重复字符
                    A[j] = A[j].replaceFirst(String.valueOf(c), "");
                }
            }

            if (isFind) {
                // 如果标志为找到，那么把找到的字符转为字符串保存到字符串列表list中
                list.add(String.valueOf(c));
            }
        }

        return list;
    }

}
```