## 源码路径

/src/main/java/org/pure/algorithm/plusOne/Main.java

## 题目地址(加一)

https://leetcode-cn.com/problems/plus-one

## 题目描述

```
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位，数组中每个元素只存储单个数字。

你可以假设除了整数0之外，这个整数不会以零开头。

示例1:

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字123。

示例2:

输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字4321。

示例3:

输入：digits = [0]
输出：[1]

提示：

1 <= digits.length <= 100
0 <= digits[i] <= 9
```

## 代码

- 语言：Java

```
class Solution {

    public int[] plusOne(int[] digits) {
        // 模拟过程法

        // 定义列表，保存加1后的结果，因为可能进位，结果可能比原数组多1，所以这里定义列表来保存结果
        List<Integer> list = new ArrayList<>();

        // 定义是否进位的标识
        boolean isCarry = false;

        // 遍历数组，从尾到头，模拟加1的过程
        for (int i = digits.length - 1; i >= 0; --i) {
            if (i == digits.length - 1) {
                // 若是最后一位，执行加1操作
                int digit = digits[i] + 1;
                if (digit >= 10) {
                    // 若加1后结果等于10，这一位变成0
                    list.add(0);
                    // 设置进位标识为true，表示后面需要进位
                    isCarry = true;
                } else {
                    // 若加1后结果小于10，直接添加到列表中，没有进位
                    list.add(digit);
                }
            } else {
                // 若不是最后一位，判断前面是否进位了，如果进位了那么加1
                if (isCarry) {
                    // 若前面进位了，加1
                    int digit = digits[i] + 1;
                    if (digit >= 10) {
                        // 若加1后结果等于10，这一位变成0
                        list.add(0);
                    } else {
                        // 若加1后结果小于10，直接添加到列表中
                        list.add(digit);
                        // 设置进位标识为false，表示后面不需要再进位了
                        isCarry = false;
                    }
                } else {
                    // 若前面没有进位，直接添加到列表中
                    list.add(digits[i]);
                }
            }
        }

        if (isCarry) {
            // 若第一位得到结果后刚好进位，那么会向前进一位，这一位就是1，所以添加1到列表中
            list.add(1);
        }

        // 定义结果数组，数组的长度就是列表的长度
        int[] results = new int[list.size()];

        // 定义结果数组的下标
        int n = 0;

        // 遍历列表，从尾到头，因为前面遍历数组时是从尾到头的，得到的数据刚好倒叙，所以这里再倒叙就得到顺序的数组
        for (int i = list.size() - 1; i >= 0; --i) {
            results[n] = list.get(i);
            ++n;
        }

        // 返回结果数组
        return results;
    }

}
```