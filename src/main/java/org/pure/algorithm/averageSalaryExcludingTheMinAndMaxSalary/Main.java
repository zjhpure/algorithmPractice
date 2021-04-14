package org.pure.algorithm.averageSalaryExcludingTheMinAndMaxSalary;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-15 07:50
 * @description 去掉最低工资和最高工资后的工资平均值
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        double result = average(nums);
        System.out.println(result);
    }

    private static double average(int[] salary) {
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
