## 源码路径

/src/main/java/org/pure/algorithm/averageSalaryExcludingTheMinAndMaxSalary/Main.java

## 题目地址(去掉最低工资和最高工资后的工资平均值)

https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

## 题目描述

```
给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。

请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。

示例1:

输入：salary = [4000,3000,1000,2000]
输出：2500.00000
解释：最低工资和最高工资分别是 1000 和 4000 。
去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500

示例2:

输入：salary = [1000,2000,3000]
输出：2000.00000
解释：最低工资和最高工资分别是 1000 和 3000 。
去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000

示例3:

输入：salary = [6000,5000,4000,3000,2000,1000]
输出：3500.00000

示例4:

输入：salary = [8000,9000,2000,3000,6000,1000]
输出：4750.00000

提示:

3 <= salary.length <= 100
10^3 <= salary[i] <= 10^6
salary[i] 是唯一的。
与真实值误差在 10^-5 以内的结果都将视为正确答案。
```

## 代码

- 语言：Java

```
class Solution {

    public double average(int[] salary) {
        // 对数组salary进行冒泡排序
        // 需要进行排序的趟数刚好为数组salary的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
        for (int i = 0; i < salary.length - 1; ++i) {
            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
            for (int j = 0; j < salary.length - 1 - i; ++j) {
                if (salary[j] > salary[j + 1]) {
                    // 若当前元素大于下一个元素，交换两个元素，用位方法进行交换更高效
                    salary[j] ^= salary[j + 1];
                    salary[j + 1] ^= salary[j];
                    salary[j] ^= salary[j + 1];
                }
            }
        }

        // 定义去掉最低和最高后的总和
        double sum = 0;

        // 遍历排序后的数组salary，从第2个元素开始到倒数第2个元素，也就是去掉最低和最高
        for (int i = 1; i < salary.length - 1; ++i) {
            sum += salary[i];
        }

        // 总和除以数量等于平均值
        return sum / (salary.length - 2);
    }

}
```