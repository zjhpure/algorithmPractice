## 源码路径

/src/main/java/org/pure/algorithm/singleNumber2/Main.java

## 题目地址(只出现一次的数字II)

https://leetcode-cn.com/problems/single-number-ii

## 题目描述

```
给你一个整数数组nums，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。

示例1:

输入：nums = [2,2,3,2]
输出：3

示例2:

输入：nums = [0,1,0,1,0,1,99]
输出：99

提示：

1 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
nums中，除某个元素仅出现一次外，其余每个元素都恰出现三次

进阶：
你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？
```

## 代码

- 语言：Java

```
class Solution {

    public int singleNumber(int[] nums) {
        // 定义集合map，保存每个整数出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历整数数组nums
        for (int num : nums) {
            // 整数作为集合map的key，次数作为集合map的value，初始value是0，每次找到相同key时value加1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 若找到集合中value为1的整数，返回整数
                return entry.getKey();
            }
        }

        return 0;
    }

}
```