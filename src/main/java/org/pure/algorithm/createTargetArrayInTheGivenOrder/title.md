## 源码路径

/src/main/java/org/pure/algorithm/createTargetArrayInTheGivenOrder/Main.java

## 题目地址(按既定顺序创建目标数组)

https://leetcode-cn.com/problems/create-target-array-in-the-given-order

## 题目描述

```
给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：

目标数组 target 最初为空。
按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
重复上一步，直到在 nums 和 index 中都没有要读取的元素。
请你返回目标数组。

题目保证数字插入位置总是存在。

示例1:

输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
输出：[0,4,1,3,2]
解释：
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]

示例2:

输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
输出：[0,1,2,3,4]
解释：
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]

示例3:

输入：nums = [1], index = [0]
输出：[1]

提示:

1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i
```

## 代码

- 语言：Java

```
class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        // 定义列表list
        List<Integer> list = new ArrayList<>();

        // 遍历下标数组index
        for (int i = 0; i < index.length; ++i) {
            // 列表往对应的下标添加对应的元素，利用ArrayList的特性，往指定位置插入元素，后面的元素会全部后移
            list.add(index[i], nums[i]);
        }

        // 定义数组results
        int[] results = new int[list.size()];

        // 遍历列表list，构造数组results
        for (int i = 0; i < list.size(); ++i) {
            // 赋值给数组results
            results[i] = list.get(i);
        }

        return results;
    }

}
```