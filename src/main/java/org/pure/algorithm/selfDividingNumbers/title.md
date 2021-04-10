## 源码路径

/src/main/java/org/pure/algorithm/selfDividingNumbers/Main.java

## 题目地址(自除数)

https://leetcode-cn.com/problems/self-dividing-numbers

## 题目描述

```
自除数 是指可以被它包含的每一位数除尽的数。

例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

还有，自除数不允许包含 0 。

给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

示例1:

输入： 
上边界left = 1, 下边界right = 22
输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

注意:

每个输入参数的边界满足 1 <= left <= right <= 10000。
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        // 定义列表list，保存自除数列表
        List<Integer> list = new ArrayList<>();

        // 从left遍历到right
        for (int i = left; i <= right; ++i) {
            if (isSelfDividingNumber(i)) {
                // 若判断这个数是自除数，添加这个数到列表list
                list.add(i);
            }
        }

        // 返回列表list
        return list;
    }

    // 判断某个数是否是自除数
    private boolean isSelfDividingNumber(int num) {
        int divideNum = num;

        while (num > 0) {
            // 通过对10取余，获取位数的数
            int res = num % 10;

            if (res == 0) {
                // 若位数的数有0，直接判断不是自除数
                return false;
            } else {
                // 若位数的数没有0，判断是否能除尽
                if (divideNum % res != 0) {
                    // 若不能除尽，直接判断不是自除数
                    return false;
                }
            }

            // 通过除10去掉数字最后一位
            num = num / 10;
        }

        return true;
    }

}
```