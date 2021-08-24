## 源码路径

/src/main/java/org/pure/algorithm/getMaximumInGeneratedArray/Main.java

## 题目地址(获取生成数组中的最大值)

https://leetcode-cn.com/problems/get-maximum-in-generated-array

## 题目描述

```
给你一个整数n。按下述规则生成一个长度为n + 1的数组nums：

nums[0] = 0
nums[1] = 1
当2 <= 2 * i <= n时，nums[2 * i] = nums[i]
当2 <= 2 * i + 1 <= n时，nums[2 * i + 1] = nums[i] + nums[i + 1]

返回生成数组nums中的最大值。

示例1:

输入：n = 7
输出：3
解释：根据规则：
  nums[0] = 0
  nums[1] = 1
  nums[(1 * 2) = 2] = nums[1] = 1
  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
  nums[(2 * 2) = 4] = nums[2] = 1
  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
  nums[(3 * 2) = 6] = nums[3] = 2
  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
因此，nums = [0,1,1,2,1,3,2,3]，最大值3

示例2:

输入：n = 2
输出：1
解释：根据规则，nums[0]、nums[1]和nums[2]之中的最大值是1

示例3:

输入：n = 3
输出：2
解释：根据规则，nums[0]、nums[1]、nums[2]和nums[3]之中的最大值是2

提示:

0 <= n <= 100
```

## 代码

- 语言：Java

```
class Solution {

    public int getMaximumGenerated(int n) {
        // 定义数组nums，长度为n+1
        int[] nums = new int[n + 1];

        // 定义数组的最大值
        int max = 0;

        // 定义数组下标，初始为0
        int i = 0;

        // 循环遍历构造数组nums
        while (i <= n) {
            if (i == 0) {
                // 若数组下标为0，数组的值为0
                nums[i] = 0;
            } else if (i == 1) {
                // 若数组下标为1，数组的值为1
                nums[i] = 1;
            } else {
                // 数组下标从2开始，数组按照nums[2 * i] = nums[i]，nums[2 * i + 1] = nums[i] + nums[i + 1]的规则构造
                if (i % 2 == 0) {
                    // 当数组下标是偶数时，通过nums[2 * i] = nums[i]反推出nums[i] = nums[i / 2]
                    nums[i] = nums[i / 2];
                } else {
                    // 当数组下标是奇数时，通过nums[2 * i + 1] = nums[i] + nums[i + 1]反推出nums[i] = nums[i / 2] + nums[i / 2 + 1]
                    nums[i] = nums[i / 2] + nums[i / 2 + 1];
                }
            }
            
            if (nums[i] > max) {
                // 更新数组的最大值
                max = nums[i];
            }

            // 数组下标自加1
            ++i;
        }

        // 返回数组的最大值
        return max;
    }

}
```