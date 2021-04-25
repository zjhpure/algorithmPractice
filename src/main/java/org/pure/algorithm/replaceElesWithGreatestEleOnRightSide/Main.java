package org.pure.algorithm.replaceElesWithGreatestEleOnRightSide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-25 08:01
 * @description 将每个元素替换为右侧最大元素
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
        int[] result = replaceElements(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] replaceElements(int[] arr) {
        // 定义结果数组results
        int[] results = new int[arr.length];

        // 遍历数组arr
        for (int i = 0; i < arr.length; ++i) {
            // 定义元素右侧最大元素
            int max = -1;

            // 遍历元素右侧元素
            for (int j = i + 1; j < arr.length; ++j) {
                // 更新元素右侧最大元素
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            // 结果数组设置右侧最大元素
            results[i] = max;
        }

        return results;
    }

}
