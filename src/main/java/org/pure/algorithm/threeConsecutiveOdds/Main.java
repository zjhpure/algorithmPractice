package org.pure.algorithm.threeConsecutiveOdds;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-04 22:17
 * @description 存在连续三个奇数的数组
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
        boolean result = threeConsecutiveOdds(nums);
        System.out.println(result);
    }

    private static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length >= 3) {
            // 若数组arr长度大于等于3，遍历数组arr
            for (int i = 2; i < arr.length; ++i) {
                // 获取前2个元素和当前元素，一共就是3个元素
                int first = arr[i - 2];
                int second = arr[i - 1];
                int third = arr[i];

                // 判断这3个元素是否都是奇数
                if (first % 2 == 1 && second % 2 == 1 && third % 2 == 1) {
                    return true;
                }
            }

            return false;
        } else {
            // 若数组arr长度小于3，那么肯定不符合连续三个元素都是奇数的情况
            return false;
        }
    }

}
