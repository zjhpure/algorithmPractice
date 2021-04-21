## 源码路径

/src/main/java/org/pure/algorithm/checkIfSentenceIsPangram/Main.java

## 题目地址(判断句子是否为全字母句)

https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram

## 题目描述

```
全字母句 指包含英语字母表中每个字母至少一次的句子。

给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。

如果是，返回 true ；否则，返回 false 。

示例1:

输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
输出：true
解释：sentence 包含英语字母表中每个字母至少一次。

示例2:

输入：sentence = "leetcode"
输出：false

提示:

1 <= sentence.length <= 1000
sentence 由小写英语字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public boolean checkIfPangram(String sentence) {
        // 定义列表list，保存找到的不重复小写字母
        List<Character> list = new ArrayList<>();

        // 遍历字符串sentence的字符
        for (int i = 0; i < sentence.length(); ++i) {
            if (!list.contains(sentence.charAt(i))) {
                // 若列表list中没有找到字符，则添加字符到列表list中
                list.add(sentence.charAt(i));

                if (list.size() >= 26) {
                    // 若列表list的长度大于等于26，则表示已经找全26个字母
                    return true;
                }
            }
        }

        return false;
    }

}
```