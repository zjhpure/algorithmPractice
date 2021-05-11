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
@SuppressWarnings("unused")
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

    // 方法1，推荐。先计算出结果数组长度，再直接把元素添加到结果数组中
    private static int[] decompressRLElist(int[] nums) {
        // 定义结果数组长度
        int count = 0;

        // 遍历数组nums，只遍历偶数下标
        for (int i = 0; i < nums.length; i += 2) {
            // 累加计算结果数组长度
            count += nums[i];
        }

        // 定义结果数组
        int[] results = new int[count];

        // 定义结果数组下标值
        int n = 0;

        // 遍历数组nums，只遍历奇数下标
        for (int i = 1; i < nums.length; i += 2) {
            // 奇数下标的前一个元素表示数量，遍历数量
            for (int j = 0; j < nums[i - 1]; ++j) {
                // 每次添加奇数下标的元素到结果数组中
                results[n] = nums[i];
                // 结果数组下标值加1
                ++n;
            }
        }

        return results;
    }

    // 方法2，不推荐。先用列表list保存元素，再把元素从列表list中转移到结果数组中
    // 因为列表list底层是用数组构成的，长度可变，每一次添加元素如果最小容量不够了就会扩容，扩容会复制产生一个新的长度更大的数组，这里会造成时间和空间的开销
    // 并且列表list的数组长度总是比实际存储数据用到的数组长度要大，这里会造成空间浪费
    // 所以能用数组的尽量用数组，因为数组是固定长度，不会有多余的空间浪费，但是前提是你要先知道数组的长度
    private static int[] decompressRLElist2(int[] nums) {
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
