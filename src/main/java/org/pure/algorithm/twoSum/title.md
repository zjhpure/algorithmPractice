## 源码路径

/src/main/java/org/pure/algorithm/twoSum/Main.java

## 题目地址(两数之和)

https://leetcode-cn.com/problems/two-sum

## 题目描述

```
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

示例1:

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例2:

输入：nums = [3,2,4], target = 6
输出：[1,2]

示例3:

输入：nums = [3,3], target = 6
输出：[0,1]

提示：

2 <= nums.length <= 10^3
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
只会存在一个有效答案
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，暴力法，时间复杂度O(n^2)，空间复杂度O(1)
    public int[] twoSum(int[] nums, int target) {
        // 第一层轮询
        for (int i = 0; i < nums.length; ++i) {
            // 第二层轮询
            for (int j = i + 1; j < nums.length; ++j) {
                // 判断两数相加是否等于target
                if (nums[i] + nums[j] == target) {
                    // 返回数组中两个元素的下标
                    return new int[]{i, j};  
                }
            }
        }

        return new int[0];
    }

}
```

```
class Solution {

    // 方法2，哈希表法，时间复杂度O(n)，空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        // 定义集合，保存数组中每种整数的最新下标
        Map<Integer, Integer> map = new HashMap<>(); 

        // 一层轮询即可
        for (int i = 0; i < nums.length; ++i) {
            // 因为两数相加等于目标值，所以反过来目标值减去其中一个数就等于另一个数，利用集合的containsKey方法判断是否存在key值，containsKey方法是O(1)常数级别的时间复杂度的，如果发现存在，那么找到了答案
            if (map.containsKey(target - nums[i])) {
                // 从集合中找出key值对应的value值，就是对应值的数组下标，再加上当前数组下标，两个数组下标就是答案
                return new int[]{map.get(target - nums[i]), i};
            }
            
            // 把数组中当前下标的整数、当前下标保存到集合中
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
```