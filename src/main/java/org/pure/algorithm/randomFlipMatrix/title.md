## 源码路径

/src/main/java/org/pure/algorithm/randomFlipMatrix/Main.java

## 题目地址(随机翻转矩阵)

https://leetcode-cn.com/problems/random-flip-matrix

## 题目描述

```
给你一个m x n的二元矩阵matrix，且所有值被初始化为0。请你设计一个算法，随机选取一个满足matrix[i][j] == 0的下标(i, j)，并将它的值变为1。所有满足 matrix[i][j] == 0的下标(i, j)被选取的概率应当均等。

尽量最少调用内置的随机函数，并且优化时间和空间复杂度。

实现Solution类：

Solution(int m, int n)使用二元矩阵的大小m和n初始化该对象
int[] flip()返回一个满足matrix[i][j] == 0的随机下标[i, j]，并将其对应格子中的值变为1
void reset()将矩阵中所有的值重置为0

示例：

输入：
["Solution", "flip", "flip", "flip", "reset", "flip"]
[[3, 1], [], [], [], [], []]
输出：
[null, [1, 0], [2, 0], [0, 0], null, [2, 0]]

解释：
Solution solution = new Solution(3, 1);
solution.flip();  // 返回[1, 0]，此时返回[0,0]、[1,0]和[2,0]的概率应当相同
solution.flip();  // 返回[2, 0]，因为[1,0]已经返回过了，此时返回[2,0]和[0,0]的概率应当相同
solution.flip();  // 返回[0, 0]，根据前面已经返回过的下标，此时只能返回[0,0]
solution.reset(); // 所有值都重置为0，并可以再次选择下标返回
solution.flip();  // 返回[2, 0]，此时返回[0,0]、[1,0]和[2,0]的概率应当相同

提示：

1 <= m, n <= 104
每次调用flip时，矩阵中至少存在一个值为0的格子。
最多调用1000次flip和reset方法。
```

## 代码

- 语言：Java

```
class Solution {

    // map集合映射法

    // 定义集合map
    Map<Integer, Integer> map = new HashMap<>();

    // 定义长、宽、总和
    int m, n, total;
    
    // 定义随机数种子
    Random rand = new Random();

    public Solution(int n_rows, int n_cols) {
        // 初始化长，等于输入的二元矩阵的行数
        this.m = n_rows;

        // 初始化宽，等于输入的二元矩阵的列数
        this.n = n_cols;

        // 计算总和，等于长乘以宽
        this.total = m * n;
    }
    
    public int[] flip() {
        // 随机数
        int x = rand.nextInt(total);

        // 加1，计算总和
        --total;

        // 查找位置x对应的映射
        int idx = map.getOrDefault(x, x);

        // 将位置x对应的映射设置为位置total对应的映射
        map.put(x, map.getOrDefault(total, total));

        // 返回数组
        return new int[]{idx / n, idx % n};
    }
    
    public void reset() {
        // 计算总和
        total = m * n;

        // 集合map清空
        map.clear();
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
```