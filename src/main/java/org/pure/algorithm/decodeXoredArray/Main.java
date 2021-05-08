package org.pure.algorithm.decodeXoredArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-08 08:18
 * @description 解码异或后的数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int[] results = decode(nums, n);
        System.out.println(Arrays.toString(results));
    }

    private static int[] decode(int[] encoded, int first) {
        // 定义结果数组arr
        int[] arr = new int[encoded.length + 1];

        // 结果数组arr第一个元素是first
        arr[0] = first;

        // 遍历数组encoded，计算出结果数组arr第一个之后的元素
        for (int i = 0; i < encoded.length; ++i) {
            // 因为encoded[i] = arr[i] XOR arr[i + 1]，所以arr[i + 1] = encoded[i] XOR arr[i]
            // 因为a^b=c，a^b^b=a，所以c^a=a^b^a=a^a^b=b，即c^a=b
            arr[i + 1] = encoded[i] ^ arr[i];
        }

        return arr;
    }

}
