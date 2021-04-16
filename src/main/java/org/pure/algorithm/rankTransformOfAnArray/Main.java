package org.pure.algorithm.rankTransformOfAnArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-04-16 07:54
 * @description 数组序号转换
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
        int[] result = arrayRankTransform(nums);
        System.out.println(Arrays.toString(result));
    }

    private static int[] arrayRankTransform(int[] arr) {
        // 定义结果数组result
        int[] result = new int[arr.length];

        // 定义排序后的数组sortedArr
        int[] sortedArr = new int[arr.length];

        // 把数组arr的复制到数组sortedArr
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);

        // 对数组sortedArr进行排序，用系统提供的sort排序，效率更高，如果用冒泡排序会超时
        Arrays.sort(sortedArr);

        // // 对数组sortedArr冒泡排序
        // for (int i = 0; i < sortedArr.length - 1; ++i) {
        //     for (int j = 0; j < sortedArr.length - 1 - i; ++j) {
        //         if (sortedArr[j] > sortedArr[j + 1]) {
        //             sortedArr[j] ^= sortedArr[j + 1];
        //             sortedArr[j + 1] ^= sortedArr[j];
        //             sortedArr[j] ^= sortedArr[j + 1];
        //         }
        //     }
        // }

        // 定义集合map，保存数组的序号
        Map<Integer, Integer> map = new HashMap<>();

        // 定义初始序号
        int sortNum = 0;

        // 遍历排序后的数组sortedArr
        for (int e : sortedArr) {
            if (!map.containsKey(e)) {
                // 若集合map中没有这个元素，才进行操作，保存元素对应的序号
                ++sortNum;
                map.put(e, sortNum);
            }
        }

        // 遍历原数组arr
        for (int i = 0; i < arr.length; ++i) {
            // 把序号赋值给结果数组result
            result[i] = map.get(arr[i]);
        }

        return result;
    }

}
