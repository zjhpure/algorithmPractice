## 源码路径

/src/main/java/org/pure/algorithm/goalParserInterpretation/Main.java

## 题目地址(设计Goal解析器)

https://leetcode-cn.com/problems/goal-parser-interpretation

## 题目描述

```
请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。

给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。

示例1:

输入：command = "G()(al)"
输出："Goal"
解释：Goal 解析器解释命令的步骤如下所示：
G -> G
() -> o
(al) -> al
最后连接得到的结果是 "Goal"

示例2:

输入：command = "G()()()()(al)"
输出："Gooooal"

示例3:

输入：command = "(al)G(al)()()G"
输出："alGalooG"

提示:

1 <= command.length <= 100
command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
```

## 代码

- 语言：Java

```
class Solution {

    public String interpret(String command) {
        // 定义字符串集合
        StringBuilder sb = new StringBuilder();

        // 遍历字符串command
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == 'G') {
                // 若是G，直接解释为G
                sb.append("G");
            } else if (command.charAt(i) == '(') {
                // 若是(开头，判断属于后两种的哪一种
                if (i < command.length() - 1) {
                    // 若字符不在字符串command的最后
                    if (command.charAt(i + 1) == ')') {
                        // 若是()，解释为o
                        sb.append("o");
                    } else if (command.charAt(i + 1) == 'a') {
                        // 若是a，排除第二种可能
                        if (i < command.length() - 3) {
                            // 若字符a后面还有两个字符
                            if (command.charAt(i + 2) == 'l' && command.charAt(i + 3) == ')') {
                                // 若是(al)，解释为al
                                sb.append("al");
                            }
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

}
```