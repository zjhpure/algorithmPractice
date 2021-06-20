## 源码路径

/src/main/java/org/pure/algorithm/findWordsThatCanBeFormedByCharacters/Main.java

## 题目地址(拼写单词)

https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters

## 题目描述

```
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的长度之和。

示例1:

输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释： 
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。

示例2:

输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。

提示:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
所有字符串中都仅包含小写英文字母
```

## 代码

- 语言：Java

```
class Solution {

    public int countCharacters(String[] words, String chars) {
        // 定义长度之和
        int count = 0;

        // 定义集合map，保存字符串chars每个字符的数量
        Map<Character, Integer> map = new HashMap<>();

        // 遍历字符串chars的每个字符，统计每个字符的数量
        for (int i = 0; i < chars.length(); ++i) {
            char c = chars.charAt(i);

            if (map.containsKey(c)) {
                // 若集合map中存在此字符，数量加1
                map.put(c, map.get(c) + 1);
            } else {
                // 若集合map中没有此字符，保存为数量1
                map.put(c, 1);
            }
        }

        // 遍历字符串数组words
        for (String word : words) {
            // 定义是否掌握这个单词的标识
            boolean isFind = true;

            // 定义集合mapTemp，每次判断是否掌握单词时，先把原来构建好的集合map赋值进来，因为每次判断是否掌握单词都要重复再使用集合map
            Map<Character, Integer> mapTemp = new HashMap<>(map);

            // 遍历字符串word的字符
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);

                if (mapTemp.containsKey(ch) && mapTemp.get(ch) > 0) {
                    // 若集合mapTemp存在这个字符，并且这个字符的数量大于0，那么字符够用，继续遍历，数量减1
                    mapTemp.put(ch, mapTemp.get(ch) - 1);
                } else {
                    // 若集合mapTemp不存在这个字符，或者这个字符的数量为0，那么字符不够用，结束遍历，标记这个单词不掌握
                    isFind = false;
                    break;
                }
            }

            if (isFind) {
                // 若这个单词已掌握，那么长度之和count加上字符串word的长度
                count += word.length();
            }
        }
        
        return count;
    }

}
```