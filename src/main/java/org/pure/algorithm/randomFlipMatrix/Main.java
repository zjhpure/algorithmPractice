package org.pure.algorithm.randomFlipMatrix;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 11/27/21 8:43 PM
 * @description 随机翻转矩阵
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = str1.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] methods = new String[size];
        for (int i = 0; i < size; ++i) {
            methods[i] = strings[i].split("\"")[1];
        }

        // 处理输入结果
        String[] numStrs = str2.split("\\[\\[\\[")[1].split("]]")[0].split(",");
        int[] nums = new int[numStrs.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        System.out.println("methods:" + Arrays.toString(methods));
        System.out.println("nums:" + Arrays.toString(nums));

//        // 获取输出结果
//        Integer[][] result = run(methods, nums);
//        System.out.println(Arrays.deepToString(result));
    }

}

class Solution {

    // map集合映射法

    // 定义集合map
    private Map<Integer, Integer> map = new HashMap<>();

    // 定义长、宽、总和
    private int m, n, total;

    // 定义随机数种子
    private Random rand = new Random();

    Solution(int n_rows, int n_cols) {
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

    void reset() {
        // 计算总和
        total = m * n;

        // 集合map清空
        map.clear();
    }

}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */