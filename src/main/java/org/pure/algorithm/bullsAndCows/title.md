## 源码路径

/src/main/java/org/pure/algorithm/bullsAndCows/Main.java

## 题目地址(猜数字游戏)

https://leetcode-cn.com/problems/bulls-and-cows

## 题目描述

```
你在和朋友一起玩猜数字(Bulls and Cows)游戏，该游戏规则如下：

写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：

猜测数字中有多少位属于数字和确切位置都猜对了(称为"Bulls", 公牛)，
有多少位属于数字猜对了但是位置不对(称为"Cows"，奶牛)。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
给你一个秘密数字secret 和朋友猜测的数字guess，请你返回对朋友这次猜测的提示。

提示的格式为"xAyB"，x是公牛个数，y是奶牛个数，A表示公牛，B表示奶牛。

请注意秘密数字和朋友猜测的数字都可能含有重复数字。

示例1：

输入: secret = "1807", guess = "7810"
输出: "1A3B"
解释: 数字和位置都对(公牛)用'|'连接，数字猜对位置不对(l奶牛)的采用斜体加粗标识。
"1807"
  |
"7810"

示例2：

输入: secret = "1123", guess = "0111"
输出: "1A1B"
解释: 数字和位置都对(公牛)用'|'连接，数字猜对位置不对(奶牛)的采用斜体加粗标识。
"1123"        "1123"
  |      or     |
"0111"        "0111"
注意，两个不匹配的1中，只有一个会算作奶牛(数字猜对位置不对)。通过重新排列非公牛数字，其中仅有一个1可以成为公牛数字。

示例3：

输入：secret = "1", guess = "0"
输出："0A0B"

示例4：

输入：secret = "1", guess = "1"
输出："1A0B"

提示:

1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret和guess仅由数字组成
```

## 代码

- 语言：Java

```
class Solution {

    public String getHint(String secret, String guess) {
        // 模拟法
        
        // 定义公牛个数
        int bullsCount = 0;

        // 定义奶牛个数
        int cowsCount = 0;

        // 定义除去公牛元素的秘密数字列表
        List<Character> secretList = new ArrayList<>();

        // 定义除去公牛元素的猜测数字列表
        List<Character> guessList = new ArrayList<>();

        // 遍历猜测数字，找出公牛元素，记录除去公牛元素的秘密数字列表和猜测数字列表
        for (int i = 0; i < guess.length(); ++i) {
            if (guess.charAt(i) == secret.charAt(i)) {
                // 若数字和位置都猜对，记录为公牛，公牛个数加1
                ++bullsCount;
            } else {
                // 除去公牛元素的秘密数字列表添加元素
                secretList.add(secret.charAt(i));
                // 除去公牛元素的猜测数字列表添加元素
                guessList.add(guess.charAt(i));
            }
        }

        // 定义哈希集合，保存奶牛位置
        Set<Integer> set = new HashSet<>();

        // 遍历除去公牛元素的猜测数字列表
        for (char c : guessList) {
            // 遍历除去公牛元素的秘密数字列表
            for (int i = 0; i < secretList.size(); ++i) {
                // 若猜测数字在秘密数字中存在，并且之前没有被挑选过，那么符合奶牛条件
                if (!set.contains(i) && c == secretList.get(i)) {
                    // 数字猜对，位置不对，记录为奶牛，奶牛个数加1
                    ++cowsCount;
                    // 哈希集合记录秘密数字中的奶牛位置
                    set.add(i);
                    break;
                }
            }
        }

        // 返回结果，公牛个数加A，再加奶牛个数加B
        return bullsCount + "A" + cowsCount + "B";
    }
    
}
```