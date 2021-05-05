package org.pure.algorithm.createTargetArrayInTheGivenOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-05 20:23
 * @description 按既定顺序创建目标数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs1 = str1.split("\\[")[1].split("]")[0].split(",");
        int size1 = strs1.length;
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; ++i) {
            nums1[i] = Integer.parseInt(strs1[i]);
        }

        // 处理输入结果
        String[] strs2 = str2.split("\\[")[1].split("]")[0].split(",");
        int size2 = strs2.length;
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }

        // 获取输出结果
        int[] result = createTargetArray(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static int[] createTargetArray(int[] nums, int[] index) {
        // 定义列表list
        List<Integer> list = new ArrayList<>();

        // 遍历下标数组index
        for (int i = 0; i < index.length; ++i) {
            // 列表往对应的下标添加对应的元素，利用ArrayList的特性，往指定位置插入元素，后面的元素会全部后移
            list.add(index[i], nums[i]);
        }

        // 定义数组results
        int[] results = new int[list.size()];

        // 遍历列表list，构造数组results
        for (int i = 0; i < list.size(); ++i) {
            // 赋值给数组results
            results[i] = list.get(i);
        }

        return results;
    }

}
