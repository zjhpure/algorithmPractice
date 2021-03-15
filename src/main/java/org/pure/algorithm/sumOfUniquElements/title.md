## 源码路径

/src/main/java/org/pure/algorithm/sumOfUniquElements/Main.java

## 题目地址(唯一元素的和)

https://leetcode-cn.com/problems/sum-of-unique-elements

## 题目描述

```
给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。

请你返回 nums 中唯一元素的 和 。

示例1:

输入：nums = [1,2,3,2]
输出：4
解释：唯一元素为 [1,3] ，和为 4 。

示例2:

输入：nums = [1,1,1,1,1]
输出：0
解释：没有唯一元素，和为 0 。

示例3:

输入：nums = [1,2,3,4,5]
输出：15
解释：唯一元素为 [1,2,3,4,5] ，和为 15 。

提示：

1 <= nums.length <= 100
1 <= nums[i] <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int sumOfUnique(int[] nums) {
        // 定义map集合
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组nums
        for (int num : nums) {
            // 获取数组元素
            if (map.containsKey(num)) {
                // 若map集合中已有数组元素，数目加1
                int count = map.get(num);
                map.put(num, ++count);
            } else {
                // 若map集合中没有数组元素，推进map集合
                map.put(num, 1);
            }
        }

        // 唯一元素总和
        int total = 0;

        // 遍历map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                // 若数组元素的数目为1，则为唯一元素，累加到总和里
                total += entry.getKey();
            }
        }

        return total;
    }

}
```