## 源码路径

/src/main/java/org/pure/algorithm/integerToEnglishWords/Main.java

## 题目地址(整数转换英文表示)

https://leetcode-cn.com/problems/integer-to-english-words

## 题目描述

```
将非负整数num转换为其对应的英文表示。

示例1:

输入：num = 123
输出："One Hundred Twenty Three"

示例2:

输入：num = 12345
输出："Twelve Thousand Three Hundred Forty Five"

示例3:

输入：num = 1234567
输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

示例4:

输入：num = 1234567891
输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

提示：

0 <= num <= 2^31 - 1
```

## 代码

- 语言：Java

```
class Solution {

    public String numberToWords(int num) {
        // 栈辅助法，从后往前不断截取三位数，每三位数作一次处理，每次处理结果保存到栈中，处理完后，利用栈的先进后出特点，不断出栈，构成顺序读取的整数的英文表示

        if (num == 0) {
            // 若整数为0，直接返回Zero
            return "Zero";
        }

        // 定义栈，保存每个三位数的英文表示
        Stack<String> stack = new Stack<>();

        // 定义后缀计数变量，用来确定使用Thousand，Million，Billion中的哪个后缀，或者不需要后缀，当是0时，不需要后缀
        int suffixCount = 0;

        // 不断除以1000，把整数拆分成多个三位数，对每个三位数进行处理，保存结果到栈中
        while (num > 0) {
            // 获取三位数
            int rem = num % 1000;

            // 去掉后面的三位
            num /= 1000;

            if (rem > 0) {
                // 获取这个三位数的英文表示
                StringBuilder englishSb = getEnglishStringBuilder(rem);

                // 若后缀计数变量大于0，补充后缀
                if (suffixCount > 0) {
                    String[] suffixs = {" Thousand", " Million", " Billion"};
                    englishSb.append(suffixs[suffixCount - 1]);
                }

                // 把这个三位数的英文表示入栈
                stack.push(englishSb.toString());
            }

            // 后缀计数变量加1
            ++suffixCount;
        }

        // 定义计数变量，用来确定构造整数的英文表示哪里需要空格前缀，当是0时，需要空格前缀
        int count = 0;

        // 定义字符串集合，用来保存整数的英文表示
        StringBuilder sb = new StringBuilder();

        // 不断出栈，构造整数的英文表示
        while (!stack.isEmpty()) {
            if (count > 0) {
                // 当计数变量大于0时，添加空格前缀
                sb.append(" ");
            }

            // 出栈，把结果添加到字符串集合中
            sb.append(stack.pop());
            
            // 计数变量加1
            ++count;
        }

        // 字符串集合转为字符串，返回结果
        return sb.toString();
    }

    // 获取三位数的英文表示
    private StringBuilder getEnglishStringBuilder(int rem) {
        // 定义字符串集合，保存三位数的英文表示
        StringBuilder sb = new StringBuilder();

        // 定义1-19的整数的英文表示
        String[] smallNums = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        // 定义大于等于100时的百的英文表示
        String[] wholeHundreds = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        if (rem <= 19) {
            // 当整数为1-19时，直接就有固定对应的英文表示
            sb.append(smallNums[rem - 1]);
        } else if (rem <= 99){
            // 当整数为20-99，调用获取大于等于20的两位数的英文表示
            sb.append(getTwoBitNumEnglishStringBuilder(rem, smallNums));
        } else {
            // 当整数为100-999时，先构造百，即第1位数字的英文表示
            sb.append(wholeHundreds[rem / 100 - 1]);

            // 添加百的英文表示后缀
            sb.append(" Hundred");

            // 获取三位数中的后两位数
            int twoBitNum = rem % 100;

            if (twoBitNum >= 20) {
                // 当后两位数大于等于20时，补充空格，以及获取大于等于20的两位数的英文表示
                sb.append(" ");
                sb.append(getTwoBitNumEnglishStringBuilder(twoBitNum, smallNums));
            } else if (twoBitNum > 0){
                // 当后两位数小于等于19并且大于0时，补充空格，以及获取1-19的整数的英文表示
                sb.append(" ");
                sb.append(smallNums[twoBitNum - 1]);
            }
        }

        return sb;
    }

    // 获取大于等于20的两位数的英文表示
    private StringBuilder getTwoBitNumEnglishStringBuilder(int twoBitNum, String[] smallNums) {
        // 定义字符串集合，保存两位数的英文表示
        StringBuilder sb = new StringBuilder();

        // 定义大于等于20的两位数的十的英文表示
        String[] wholeTens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        // 先构造十，即第1位数字的英文表示
        sb.append(wholeTens[twoBitNum / 10 - 2]);

        // 获取两位数中的后一位数
        int bit = twoBitNum % 10;

        if (bit > 0) {
            // 当后一位数大于0时，补充空格，以及获取1-9的整数的英文表示
            sb.append(" ");
            sb.append(smallNums[bit - 1]);
        }

        return sb;
    }

}
```