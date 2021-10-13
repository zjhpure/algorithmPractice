## 源码路径

/src/main/java/org/pure/algorithm/fizzBuzz/Main.java

## 题目地址(Fizz Buzz)

https://leetcode-cn.com/problems/fizz-buzz

## 题目描述

```
给你一个整数n，找出从1到n各个整数的Fizz Buzz表示，并用字符串数组answer(下标从1开始)返回结果，其中：

answer[i] == "FizzBuzz"，如果i同时是3和5的倍数。
answer[i] == "Fizz"，如果i是3的倍数。
answer[i] == "Buzz"，如果i是5的倍数。
answer[i] == i，如果上述条件全不满足。

示例1:

输入：n = 3
输出：["1","2","Fizz"]

示例2:

输入：n = 5
输出：["1","2","Fizz","4","Buzz"]

示例3:
输入：n = 15
输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

提示:

1 <= n <= 10^4
```

## 代码

- 语言：Java

```
class Solution {

    public List<String> fizzBuzz(int n) {
        // 直接模拟
        
        // 定义列表，保存结果
        List<String> list = new ArrayList<>();

        // 直接遍历构造构造列表即可
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                // 同时是3和5的倍数
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // 3的倍数
                list.add("Fizz");
            } else if (i % 5 == 0) {
                // 5的倍数
                list.add("Buzz");
            } else {
                // 3和5的倍数都不是
                list.add(i + "");
            }
        }

        // 返回列表结果
        return list;
    }

}
```