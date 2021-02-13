## 源码路径

/src/main/java/org/pure/algorithm/findDisappearedNumbers/Main.java

## 题目地址(找到所有数组中消失的数字)

https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array

## 题目描述

```
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例1:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```

## 代码

- 语言：Java

```
class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 定义消失数字列表
        List<Integer> list = new ArrayList<>();

        // 负值标记法
        // 从0索引遍历到n-1索引，把nums数组中的值作为索引，把索引对应的nums数组值变为负数
        for (int i = 0; i < nums.length; ++i) {
            int index = nums[i];

            if (index > 0) {
                // 若值为正数，直接减1即可
                index = index - 1;
            } else {
                // 若值为负数，先变回正数再减1
                index = -index - 1;
            }

            if (nums[index] > 0) {
                // 把数组值变为负数
                nums[index] = -nums[index];
            }
        }

        // nums数组中不是负数的值，它的索引+1就是消失的数字
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

}
```