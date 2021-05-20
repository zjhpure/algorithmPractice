## 源码路径

/src/main/java/org/pure/algorithm/flippingAnImage/Main.java

## 题目地址(翻转图像)

https://leetcode-cn.com/problems/flipping-an-image

## 题目描述

```
给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

示例1:

输入：[[1,1,0],[1,0,1],[0,0,0]]
输出：[[1,0,0],[0,1,0],[1,1,1]]
解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

示例2:

输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

提示:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
```

## 代码

- 语言：Java

```
class Solution {

    public int[][] flipAndInvertImage(int[][] image) {
        // 定义二维数组results
        int[][] results = new int[image.length][];

        // 遍历矩阵A的每行
        for (int i = 0; i < image.length; ++i) {
            // 定义下标
            int n = 0;

            // 定义一维数组result
            int[] result = new int[image[i].length];

            // 遍历矩阵A每行的每列，从尾遍历到头，进行水平翻转
            for (int j = image[i].length - 1; j >= 0; --j) {
                // 赋值给一维数组result
                result[n] = image[i][j];
                // 下标加1
                ++n;
            }

            // 遍历一维数组result，进行反转
            for (int j = 0; j < result.length; ++j) {
                // 0替换成1，1替换成0
                result[j] = result[j] == 1 ? 0 : 1;
            }

            // 二维数组results的一行处理好
            results[i] = result;
        }

        return results;
    }

}
```