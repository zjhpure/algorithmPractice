package org.pure.algorithm.decompressRunLengthEncodedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-11 08:17
 * @description 解压缩编码列表
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
        int[] results = decompressRLElist(nums);
        System.out.println(Arrays.toString(results));
    }

    private static int[] decompressRLElist(int[] nums) {
        // 定义列表list，保存解压后的列表
        List<Integer> list = new ArrayList<>();

        // 遍历数组nums，只遍历奇数下标
        for (int i = 1; i < nums.length; i += 2) {
            // 奇数下标的前一个元素表示数量，遍历数量
            for (int j = 0; j < nums[i - 1]; ++j) {
                // 每次添加奇数下标的元素到列表list中
                list.add(nums[i]);
            }
        }

        // 定义结果数组
        int[] results = new int[list.size()];

        // 把解压后的列表转为结果数组
        for (int i = 0; i < list.size(); ++i) {
            results[i] = list.get(i);
        }

        return results;
    }

}
