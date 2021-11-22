## 源码路径

/src/main/java/org/pure/algorithm/shuffleAnArray/Main.java

## 题目地址(打乱数组)

https://leetcode-cn.com/problems/shuffle-an-array

## 题目描述

```
给你一个整数数组nums，设计算法来打乱一个没有重复元素的数组。

实现Solution class：

Solution(int[] nums)使用整数数组nums初始化对象
int[] reset()重设数组到它的初始状态并返回
int[] shuffle()返回数组随机打乱后的结果

示例：

输入：
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
输出：
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

解释：
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // 打乱数组[1,2,3]并返回结果。任何[1,2,3]的排列返回的概率应该相同。例如，返回[3, 1, 2]
solution.reset();      // 重设数组到它的初始状态[1, 2, 3]。返回[1, 2, 3]
solution.shuffle();    // 随机返回数组[1, 2, 3]打乱后的结果。例如，返回[1, 3, 2]

提示：

1 <= nums.length <= 200
-10^6 <= nums[i] <= 10^6
nums中的所有元素都是唯一的
最多可以调用5 * 10^4次reset和shuffle
```

## 代码

- 语言：Java

```
class Solution {
    // 暴力法

    // 定义返回的数组
    private int[] nums;

    // 定义原数组
    private int[] originals;

    public Solution(int[] nums) {
        // 初始化，把输入的数组赋给返回的数组
        this.nums = nums;

        // 原数组生成新对象(不要直接指向nums，因为这样操作，后面的随机打乱会影响到自身)
        originals = new int[nums.length];

        // 把返回的数组复制给原数组
        System.arraycopy(nums, 0, originals, 0, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        // 重设数组就是把原数组复制给返回的数组，这里的第5个参数要填nums.length，不能是originals.length，因为如果初始化之后就马上reset了，这时originals的长度还是0，
        System.arraycopy(originals, 0, nums, 0, nums.length);

        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // 定义随机打乱的数组，最后要把随机打乱的数组复制给返回的数组
        int[] shuffled = new int[nums.length];

        // 定义列表，先保存原返回的数组，利用列表的长度来获取随机数
        List<Integer> list = new ArrayList<>();

        // 遍历原返回的数组，把原返回的数组保存到列表
        for (int num : nums) {
            list.add(num);
        }

        // 定义随机数
        Random random = new Random();

        // 再次遍历原返回的数组，构造随机打乱的数组
        for (int i = 0; i < nums.length; ++i) {
            // 获取不超列表长度范围的随机下标
            int j = random.nextInt(list.size());

            // 从列表中移除随机下标的元素，把元素赋给随机打乱的数组
            shuffled[i] = list.remove(j);
        }

        // 把随机打乱的数组复制给返回的数组
        System.arraycopy(shuffled, 0, nums, 0, nums.length);

        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
```