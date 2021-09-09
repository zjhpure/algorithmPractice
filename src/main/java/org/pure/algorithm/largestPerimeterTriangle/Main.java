package org.pure.algorithm.largestPerimeterTriangle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-09-09 23:32
 * @description 三角形的最大周长
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
        int result = largestPerimeter(nums);
        System.out.println(result);
    }

    private static int largestPerimeter(int[] nums) {
        // 在一个三角形中，任意两边之和大于第三边，或者任意两边之差小于第三边，通过这个规则来判断是三个数是否可以构成三角形

        // 排序
        Arrays.sort(nums);

        // 遍历排序后的数组，从尾到头，这样能从大的数开始判断，只要符合条件就是最大周长的三角形
        for (int i = nums.length - 1; i >= 2; --i) {
            // 若符合任意两边之和大于第三边，那么构成三角形，因为是从大的数一侧开始判断，所以这里就是最大周长的三角形，而且不会存在三角形的前两边在前面，因为数组已经排序好，这里是在最后去判断是否符合三角形的，往前即使符合也不是最大周长的三角形
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                // 找到构成最大周长的三角形，返回三条边相加的和
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }

        // 如果任意三个数都不能构成三角形，那么返回0
        return 0;
    }

}
