## 源码路径

/src/main/java/org/pure/algorithm/majorityElement/Main.java

## 题目地址(多数元素)

https://leetcode-cn.com/problems/majority-element

## 题目描述

```
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1:

输入：[3,2,3]
输出：3

示例2:

输入：[2,2,1,1,1,2,2]
输出：2

进阶：

尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
```

## 代码

- 语言：Java

```
class Solution {

    // 此方法接近超时，不建议使用，因为用了两轮遍历才找出答案
    public int majorityElement(int[] nums) {
        if (nums.length <= 1) {
            // 若数组nums长度不大于1，那么多数元素就是数组nums的第一个元素
            return nums[0];
        }

        // 定义元素统计数量
        int count = 0;

        // 第一轮遍历数组nums，从第一个元素到倒数第二个元素
        for (int i = 0; i < nums.length - 1; ++i) {
            // 每次把元素统计数量重新设置为1
            count = 1;

            // 第二轮遍历数组nums，从上一轮元素的下一个元素到倒数第一个元素
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == nums[i]) {
                    // 若两个元素相等，元素统计数量加1
                    ++count;

                    if (count > nums.length / 2) {
                        // 如果此元素在数组中出现次数大于n/2，那么找到多数元素
                        return nums[i];
                    }
                }
            }
        }

        return count;
    }

}

class Solution {

    // 此方法不超时，用集合map保存数组元素的个数，一轮遍历找到答案
    public int majorityElement(int[] nums) {
        if (nums.length <= 1) {
            // 若数组nums长度不大于1，那么多数元素就是数组nums的第一个元素
            return nums[0];
        }

        // 构造集合map，保存不同数组元素的个数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组nums
        for (int num : nums) {
            if (map.containsKey(num)) {
                // 若集合map中存在元素num，那么元素个数加1
                int count = map.get(num) + 1;
                
                if (count > nums.length / 2) {
                    // 若元素个数大于数组长度的一半，那么找到了多数元素
                    return num;
                } else {
                    // 若元素个数不大于数组长度的一半，没有找到多数元素，把元素个数的加1后的结果保存到集合map中
                    map.put(num, count);
                }
            } else {
                // 若集合map中不存在元素num，那么把此元素保存到集合map中，元素个数记为1
                map.put(num, 1);
            }
        }

        return 0;
    }

}
```