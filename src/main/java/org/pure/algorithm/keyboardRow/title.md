## 源码路径

/src/main/java/org/pure/algorithm/keyboardRow/Main.java

## 题目地址(键盘行)

https://leetcode-cn.com/problems/keyboard-row

## 题目描述

```
给你一个字符串数组words，只返回可以使用在美式键盘同一行的字母打印出来的单词。键盘如下图所示。

美式键盘中：

第一行由字符"qwertyuiop"组成。
第二行由字符"asdfghjkl"组成。
第三行由字符"zxcvbnm"组成。

示例1：

输入：words = ["Hello","Alaska","Dad","Peace"]
输出：["Alaska","Dad"]

示例2：

输入：words = ["omk"]
输出：[]

示例3：

输入：words = ["adsdf","sfd"]
输出：["adsdf","sfd"]

提示：

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i]由英文字母(小写和大写字母)组成
```

## 代码

- 语言：Java

```
class Solution {

    public String[] findWords(String[] words) {
        // 模拟法
        
        // 定义列表，保存符合条件的字符串
        List<String> list = new ArrayList<>();

        // 遍历字符串数组
        for (String word : words) {
            // 把字符串转为小写
            String lowerWord = word.toLowerCase();

            // 定义字符串所在的行数，获取字符串第一个字符所在的行数
            int currentRow = getRow(lowerWord.charAt(0));

            // 循环，遍历字符串中的字符，从第二个到最后一个
            for (int i = 1; i < lowerWord.length(); ++i) {
                // 获取字符串中字符所在的行数
                if (currentRow != getRow(lowerWord.charAt(i))) {
                    // 若字符串中字符所在的行数和字符串第一个字符所在的行数不同，那么字符串中的字符不在同一行，字符串所在的行数标记为-1，结束循环
                    currentRow = -1;
                    break;
                }
            }

            if (currentRow != -1) {
                // 若字符串所在的行数不被标记为-1，那么字符串中的字符在同一行，符合条件，把此字符串推进列表中
                list.add(word);
            }
        }

        // 把列表转为字符串数组
        return list.toArray(new String[0]);
    }

    // 获取字符所在的行数
    private int getRow(char c) {
        if ("qwertyuiop".indexOf(c) >= 0) {
            // 第一行
            return 0;
        }

        if ("asdfghjkl".indexOf(c) >= 0) {
            // 第二行
            return 1;
        }

        if ("zxcvbnm".indexOf(c) >= 0) {
            // 第三行
            return 2;
        }

        return -1;
    }

}
```