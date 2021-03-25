package org.pure.algorithm.monotonicArray;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-25 23:39
 * @description 单调数列
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
        boolean result = isMonotonic(nums);
        System.out.println(result);
    }

    private static boolean isMonotonic(int[] A) {
        if (A.length > 2) {
            // 数组长度大于2的才进行判断，长度小于等于2的都是单调数列
            // 定义另一个数组B，保存数组A中相隔的两数的差列表
            int[] B = new int[A.length - 1];

            // 遍历数组A，从第2个元素开始，到最后1个元素结束
            for (int i = 1; i < A.length; ++i) {
                B[i - 1] = A[i] - A[i - 1];
            }

            // 是否要递增判断
            boolean isAdd = false;

            // 遍历数组B
            for (int value : B) {
                if (value > 0) {
                    // 若有大于0的差，那么进行递增的判断
                    isAdd = true;
                    break;
                }
            }

            // 再次遍历数组B
            for (int value : B) {
                if (isAdd) {
                    // 若是递增判断
                    if (value < 0) {
                        // 若递增判断中出现负数差，那么就不是单调数列了
                        return false;
                    }
                } else {
                    // 若是递减判断
                    if (value > 0) {
                        // 若递减判断中出现正数差，那么就不是单调数列了
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
