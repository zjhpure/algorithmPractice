## 源码路径

/src/main/java/org/pure/algorithm/missingNumber/Main.java

## 题目地址(丢失的数字)

https://leetcode-cn.com/problems/missing-number

## 题目描述

```
给定一个包含[0, n]中n个数的数组nums，找出[0, n]这个范围内没有出现在数组中的那个数。

进阶：

你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

示例1：

输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有3个数字，所以所有的数字都在范围[0,3]内。2是丢失的数字，因为它没有出现在nums中。

示例2：

输入：nums = [0,1]
输出：2
解释：n = 2，因为有2个数字，所以所有的数字都在范围[0,2]内。2是丢失的数字，因为它没有出现在nums中。

示例3：

输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
解释：n = 9，因为有9个数字，所以所有的数字都在范围[0,9]内。8是丢失的数字，因为它没有出现在nums中。

示例4：

输入：nums = [0]
输出：1
解释：n = 1，因为有1个数字，所以所有的数字都在范围[0,1]内。1是丢失的数字，因为它没有出现在nums中。

提示：

n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
nums中的所有数字都独一无二
```

## 代码

- 语言：Java

```
class Solution {

    // 方法1，哈希集合法
    public int missingNumber(int[] nums) {
        // 哈希集合法

        // 定义哈希集合保存数组
        Set<Integer> set = new HashSet<>();

        // 遍历数组nums，把nums的元素保存进哈希集合set中
        for (int num : nums) {
            set.add(num);
        }

        // 遍历[0,n]范围的整数
        for (int i = 0; i <= nums.length; ++i) {
            if (!set.contains(i)) {
                // 若哈希集合set中不包含此元素，那么这个就是丢失的数字
                return i;
            }
        }

        return -1;
    }

}
```

```
class Solution {

    // 方法2，数学法
    public int missingNumber(int[] nums) {
        // 数学法

        // 获取数组的长度
        int n = nums.length;

        // 利用公式计算[0,n]范围整数的总和，total = (首项 + 末项) * 项数 / 2
        int total = n * (n + 1) / 2;

        // 计算数组的总和
        int sum = 0;

        // 遍历数组nums，通过累加计算数组的总和sum
        for (int num : nums) {
            sum += num;
        }

        // [0,n]范围整数的总和减去数组的总和，就是丢失的数字
        return total - sum;
    }

}
```

```
class Solution {

    // 方法3，位运算法
    public int missingNumber(int[] nums) {
        // 位运算法，利用异或的规律，x ^ x = 0，x ^ 0 = 0

        // 定义异或的结果
        int xor = 0;

        // 遍历数组nums，每个元素和xor进行异或计算
        for (int num : nums) {
            xor ^= num;
        }

        // 遍历[0,n]范围的整数，每个元素和xor进行异或计算
        for (int i = 0; i <= nums.length; ++i) {
            xor ^= i;
        }

        // 遍历两次，一次是数组nums，一次是[0,n]，刚好除了丢失的数字，其他数字都出现了两次，因为x ^ x = 0，所以其他两两出现的数字都成了0，只有丢失的数字只出现一次，定义丢失的数字为miss，所以最后就变成miss ^ 0，根据x ^ 0 = 0，即miss
        return xor;
    }

}
```