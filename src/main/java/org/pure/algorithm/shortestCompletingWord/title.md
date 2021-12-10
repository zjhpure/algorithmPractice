## 源码路径

/src/main/java/org/pure/algorithm/shortestCompletingWord/Main.java

## 题目地址(最短补全词)

https://leetcode-cn.com/problems/shortest-completing-word

## 题目描述

```
给你一个字符串licensePlate和一个字符串数组words，请你找出并返回words中的最短补全词。

补全词是一个包含licensePlate中所有的字母的单词。在所有补全词中，最短的那个就是最短补全词。

在匹配licensePlate中的字母时：

忽略licensePlate中的数字和空格。
不区分大小写。
如果某个字母在licensePlate中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母'a'、'b'(忽略大写)和两个'c'。可能的补全词有"abccdef"、"caaacab"以及"cbca"。

请你找出并返回words中的最短补全词。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取words中最靠前的那个。

示例1：

输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
输出："steps"
解释：最短补全词应该包括"s"、"p"、"s"(忽略大小写)以及"t"。
"step"包含"t"、"p"，但只包含一个"s"，所以它不符合条件。
"steps"包含"t"、"p"和两个"s"。
"stripe"缺一个"s"。
"stepple"缺一个"s"。
因此，"steps"是唯一一个包含所有字母的单词，也是本例的答案。

示例2：

输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
输出："pest"
解释：licensePlate只包含字母"s"。所有的单词都包含字母"s"，其中"pest"、"stew"和"show"三者最短。答案是"pest"，因为它是三个单词中在words里最靠前的那个。

示例3：

输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
输出："husband"

示例4：

输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
输出："enough"

示例5：

输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
输出："simple"

提示：

1 <= licensePlate.length <= 7
licensePlate由数字、大小写字母或空格' '组成
1 <= words.length <= 1000
1 <= words[i].length <= 15
words[i]由小写英文字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 模拟法，计数法

        // 获取补全词的字符统计数组
        int[] count = getCount(licensePlate);

        // 定义最短补全词
        String maxShortestWord = null;

        // 循环，遍历字符串数组
        for (String word : words) {
            // 获取当前单词的字符统计数组
            int[] countTemp = getCount(word);

            // 定义是否符合补全词的标识
            boolean isConform = true;

            // 循环，从0遍历到25，比较补全词字符统计数组和当前单词统计数组
            for (int i = 0; i < 26; ++i) {
                if (count[i] > 0 && countTemp[i] < count[i]) {
                    // 只看补全词中存在的字符，若当前单词的字符数量小于补全词的字符数量，那么不符合补全词的标识，标识为false，结束循环
                    isConform = false;
                    break;
                }
            }

            if (isConform) {
                // 若符合补全词，那么更新当前最短补全词
                if (maxShortestWord == null) {
                    // 若当前最短补全词为空，证明找到的是第一个补全词，先更新最短补全词为第一个补全词
                    maxShortestWord = word;
                } else {
                    // 若当前最短补全词不为空，证明找到的不是第一个补全词，比较当前补全词和最短补全词的长度
                    if (word.length() < maxShortestWord.length()) {
                        // 若当前补全词的长度更短，那么更新最短补全词为当前补全词
                        maxShortestWord = word;
                    }
                }
            }
        }

        // 返回最短补全词
        return maxShortestWord;
    }

    // 统计一个单词中各个字符的个数，返回一个长度为26的统计数组
    private int[] getCount(String word) {
        // 定义长度为26的统计数组，保存每一个字母的个数，通过计数法统计
        int[] count = new int[26];

        // 遍历单词的字符，统计补全词中每一个字符的个数
        for (int i = 0; i < word.length(); ++i) {
            // 获取单词当前的字符
            char c = word.charAt(i);
            // 判断当前字符是否为字母
            if (Character.isLetter(c)) {
                // 若为字母，字母都转为小写字母，减去字母a的ASCII码，定位到统计数组的下标，数量加1
                ++count[Character.toLowerCase(c) - 'a'];
            }
        }

        // 返回统计数组
        return count;
    }

}
```