## 源码路径

/src/main/java/org/pure/algorithm/canPlaceFlowers/Main.java

## 题目地址(种花问题)

https://leetcode-cn.com/problems/can-place-flowers

## 题目描述

```
假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。

示例1:

输入：flowerbed = [1,0,0,0,1], n = 1
输出：true

示例2:

输入：flowerbed = [1,0,0,0,1], n = 2
输出：false

提示:

1 <= flowerbed.length <= 2 * 10^4
flowerbed[i] 为 0 或 1
flowerbed 中不存在相邻的两朵花
0 <= n <= flowerbed.length
```

## 代码

- 语言：Java

```
class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 定义种花数量
        int num = 0;

        // 花坛数组长度
        int size = flowerbed.length;

        // 遍历花坛数组
        for (int i = 0; i < size; ++i) {
            int flower = flowerbed[i];

            if (flower == 0) {
                // 若是0，判断能否种下花
                if (i == 0) {
                    // 第1个元素
                    if (size > 1 && flowerbed[i + 1] == 0) {
                        // 若后元素为0，那么这个元素可以种下花，把此元素改为1
                        flowerbed[i] = 1;
                        // 种花数量加1
                        ++num;
                    } else if (size <= 1) {
                        // 若花坛数组长度只有1，种花数量加1
                        ++num;
                    }
                } else if (i == size - 1) {
                    // 第2个元素
                    if (flowerbed[i - 1] == 0) {
                        // 若前元素为0，那么这个元素可以种下花，把此元素改为1
                        flowerbed[i] = 1;
                        // 种花数量加1
                        ++num;
                    }
                } else {
                    // 中间元素
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        // 若前后元素都为0，那么这个元素可以种下花，把此元素改为1
                        flowerbed[i] = 1;
                        // 种花数量加1
                        ++num;
                    }
                }

                if (num >= n) {
                    // 若种花数量达到了n值，那么就是可以种入n朵花，可以直接就返回true
                    return true;
                }
            }
        }

        // 若种花数量达到了n值，那么返回true
        // 若种花数量没有达到了n值，那么返回false
        return num >= n;
    }

}
```