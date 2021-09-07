package org.pure.algorithm.sparseArraySearch;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-07 16:58
 * @description 稀疏数组搜索
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] words = new String[size];
        for (int i = 0; i < size; ++i) {
            if ("\"\"".equals(strings[i])) {
                words[i] = "";
            } else {
                words[i] = strings[i].split("\"")[1];
            }
        }

        // 获取输出结果
        int result = findString(words, s);
        System.out.println(result);
    }

    private static int findString(String[] words, String s) {
        // 因为字符串数组是有序的，可以通过修改二分查找法来解决
        // 遇到空字符串，中间指针往左移动，直到不为空字符串或者大于左指针，结束循环；或者中间指针往右移动，直到不为空字符串或者小于右指针，结束循环

        // 定义中间指针
        int center;
        // 定义左指针
        int left = 0;
        // 定义右指针
        int right = words.length - 1;

        // 二分查找，进行循环，直到左指针大于右指针，结束循环
        while (left <= right) {
            // 计算获取中间指针，可以用位运算向右移动1位来代替除以2
            center = (left + right) >> 1;

            // 当遇到了特殊值导致正常的二分无法继续时，就临时退化为线性遍历
            // 当遇到空字符串，中间指针向左移动，直到不为空字符串或者大于左指针，结束循环(这里和二分查找法不同，其他地方一模一样)
            while (center > left && "".equals(words[center])) {
                --center;
            }

            if (s.equals(words[center])) {
                // 若给定字符串等于字符串数组中间指针的元素，那么找到了目标值，返回中间指针
                return center;
            } else if (s.compareTo(words[center]) < 0) {
                // 字符串的compareTo()方法用于两个字符串的比较，按字典顺序比较两个字符串
                // 若给定字符串小于字符串数组中间指针的元素，那么目标值落在字符串数组的前半部分，把右指针更新为中间指针减1
                right = center - 1;
            } else {
                // 若给定字符串大于字符串数组中间指针的元素，那么目标值落在字符串数组的后半部分，把左指针更新为中间指针加1
                left = center + 1;
            }
        }

        // 若没有找到给定字符串，返回-1
        return -1;
    }

}
