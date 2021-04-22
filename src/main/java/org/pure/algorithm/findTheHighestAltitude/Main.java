package org.pure.algorithm.findTheHighestAltitude;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-22 08:08
 * @description 找到最高海拔
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
        int result = largestAltitude(nums);
        System.out.println(result);
    }

    private static int largestAltitude(int[] gain) {
        // 定义最高点的海拔
        int max = 0;
        // 定义当前点海拔值
        int num = 0;

        // 遍历数组gain
        for (int e : gain) {
            // 获取当前点海拔值
            num += e;

            // 比较最高点的海拔和当前点海拔值，更新最高点的海拔
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

}
