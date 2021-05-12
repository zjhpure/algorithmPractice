## 源码路径

/src/main/java/org/pure/algorithm/countItemsMatchingARule/Main.java

## 题目地址(统计匹配检索规则的物品数量)

https://leetcode-cn.com/problems/count-items-matching-a-rule

## 题目描述

```
给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。

另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。

如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：

ruleKey == "type" 且 ruleValue == typei 。
ruleKey == "color" 且 ruleValue == colori 。
ruleKey == "name" 且 ruleValue == namei 。
统计并返回 匹配检索规则的物品数量 。

示例1:

输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
输出：1
解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。

示例2:

输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
输出：2
解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。

提示:

1 <= items.length <= 104
1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey 等于 "type"、"color" 或 "name"
所有字符串仅由小写字母组成
```

## 代码

- 语言：Java

```
class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // 定义匹配数量
        int nums = 0;

        // 遍历列表items
        for (List<String> item : items) {
            // 判断匹配类型
            if ("type".equals(ruleKey)) {
                // 若匹配类型是类型
                if (item.get(0).equals(ruleValue)) {
                    // 若类型值相等，匹配成功，匹配数量加1
                    ++nums;
                }
            } else if ("color".equals(ruleKey)) {
                // 若匹配类型是颜色
                if (item.get(1).equals(ruleValue)) {
                    // 若颜色值相等，匹配成功，匹配数量加1
                    ++nums;
                }
            } else if ("name".equals(ruleKey)) {
                // 若匹配类型是名称
                if (item.get(2).equals(ruleValue)) {
                    // 若名称值相等，匹配成功，匹配数量加1
                    ++nums;
                }
            }
        }

        return nums;
    }

}
```