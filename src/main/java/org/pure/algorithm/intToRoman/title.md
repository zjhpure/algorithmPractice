## 源码路径

/src/main/java/org/pure/algorithm/intToRoman/Main.java

## 题目地址(整数转罗马数字)

https://leetcode-cn.com/problems/integer-to-roman

## 题目描述

```
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例1:

输入: 3
输出: "III"

示例2:

输入: 4
输出: "IV"

示例3:

输入: 9
输出: "IX"

示例4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.

示例5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```

## 代码

- 语言：Java

```
class Solution {

    public String intToRoman(int num) {
        // 结果
        StringBuilder sb = new StringBuilder();

        // 用map保存数字对应的字符串
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        // 定义列表保存每一位数字
        List<Integer> list = new ArrayList<>();

        // 10的n次方迭代值
        int m = 1;

        // 不断取余除10
        while (num > 0) {
            // 获取除10的余数
            int rem = num % 10;

            // 特殊罗马数字组合情况
            if (rem == 4 || rem == 9) {
                // 添加4或9到列表
                list.add(rem * m);
            } else {
                if (rem >= 5) {
                    // 获取除5的余数
                    rem = rem % 5;

                    // 添加rem-1个1到列表
                    for (int j = 0; j < rem; ++j) {
                        // 添加1到列表
                        list.add(m);
                    }

                    // 添加5到列表
                    list.add(5 * m);
                } else {
                    // 添加rem-1个1到列表
                    for (int j = 0; j < rem; ++j) {
                        // 添加1到列表
                        list.add(m);
                    }
                }
            }

            // 迭代值变化
            m = m * 10;

            // 除10
            num = num / 10;
        }

        // 索引最大值
        int index = list.size() - 1;

        // 从尾到头遍历列表
        for (int i = index; i >= 0; --i) {
            int n = list.get(i);

            // 从map中取值获取罗马数字对应的字符串，再叠加字符串
            sb.append(map.get(n));
        }

        return sb.toString();
    }

}
```