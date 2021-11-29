package org.pure.algorithm.kThSmallestPrimeFraction;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 11/29/21 12:47 PM
 * @description 第K个最小的素数分数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int[] result = kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 暴力法+自定义排序，先把所有素数分数放到列表中，然后进行自定义排序，用交叉相乘比较大小，若a/b < c/d，那么ad < bc

        // 定义列表，保存所有素数分数
        List<int[]> list = new ArrayList<>();

        // 遍历数组，获取第一个素数
        for (int i = 0; i < arr.length; ++i) {
            // 遍历数组，获取第二个素数
            for (int j = i + 1; j < arr.length; ++j) {
                // 把素数分数添加到列表中
                list.add(new int[]{arr[i], arr[j]});
            }
        }

        // 使用自定义排序，对列表进行排序
        list.sort((o1, o2) -> o1[0] * o2[1] - o1[1] * o2[0]);

        // 返回第k个元素，就是第k个最小的素数分数
        return list.get(k - 1);
    }

}
