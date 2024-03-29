package org.pure.algorithm.allKindsOfSearch;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:30
 * @description 斐波那契查找
 */
public class FibonacciSearch {

    // 斐波那契查找的序列必须是有序序列
    // 斐波那契查找是二分查找的一种提升算法，通过运用黄金比例的概念在数列中选择查找点进行查找，以提高查找效率
    // 随着斐波那契数列的递增，前后两个数的比值会越来越接近0.618，也就是黄金分割比例
    // 如果数组长度达到没有斐波那契的要求，那么我们扩大数组来满足要求

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int target = scanner.nextInt();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = fibonacciSearch(arr, arr.length, target);
        System.out.println(result);
    }

    // 构造斐波那契数列，递归法
    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // 斐波那契查找，有序查找，时间复杂度O(logn)
    private static int fibonacciSearch(int[] arr, int n, int target) {
        // 定义左指针，初始为1
        int low = 1;

        // 定义右指针，high不用等于fib(k)-1，效果相同
        int high = n;

        // 定义中间指针
        int mid;

        // 定义斐波那契数列的长度
        int k = 0;

        // 构建斐波那契数列，在构建过程中，计算斐波那契数列的长度
        while (n > fib(k) - 1) {
            // 获取k值
            ++k;
        }

        // 因为无法直接对原数组arr[]增加长度，所以定义一个新的数组，构建一个长度为斐波那契数列的长度的数组
        int[] temp = new int[fib(k)];

        // 采用System.arraycopy()进行数组间的赋值，把原数组复制到新数组上
        System.arraycopy(arr, 0, temp, 0, arr.length);

        // 对数组中新增的位置进行赋值，如果数组长度达到没有斐波那契的要求，那么我们扩大数组来满足要求，但是后面新增的元素的值都等于原数组的最大值
        for (int i = n + 1; i <= fib(k) - 1; ++i) {
            temp[i] = temp[n];
        }

        // 进行二分查找
        while (low <= high) {
            // 计算中间指针
            mid = low + fib(k - 1) - 1;

            if (target < temp[mid]) {
                high = mid - 1;
                // 对应上图中的左端，长度fib[k-1]-1
                k = k - 1;
            } else if (target > temp[mid]) {
                low = mid + 1;
                // 对应上图中的右端，长度fib[k-2]-1
                k = k - 2;
            } else {
                // 当mid位于新增的数组中时，返回n
                return Math.min(mid, n);
            }
        }

        // 若没有找到目标值，返回-1
        return -1;
    }

}
