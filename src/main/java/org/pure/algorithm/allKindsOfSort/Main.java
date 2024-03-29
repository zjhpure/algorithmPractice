package org.pure.algorithm.allKindsOfSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-12 19:09
 * @description 各类排序
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
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        // 调用各类排序
        useSort(arr);
    }

    // 生成新数组
    private static int[] getNewArr(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    // 调用各类排序
    private static void useSort(int[] arr) {
        // 冒泡排序(交换排序)前数组
        System.out.println("冒泡排序(交换排序)前数组：" + Arrays.toString(arr));
        // 生成冒泡排序(交换排序)新数组
        int[] bubbleSortArr = getNewArr(arr);
        // 冒泡排序(交换排序)后数组
        System.out.println("冒泡排序(交换排序)后数组：" + Arrays.toString(bubbleSort(bubbleSortArr)));

        // 冒泡排序改进(交换排序)前数组
        System.out.println("冒泡排序改进(交换排序)前数组：" + Arrays.toString(arr));
        // 生成冒泡排序改进(交换排序)新数组
        int[] bubbleSortArr2 = getNewArr(arr);
        // 冒泡排序改进(交换排序)后数组
        System.out.println("冒泡排序改进(交换排序)后数组：" + Arrays.toString(bubbleSort2(bubbleSortArr2)));

        // 快速排序(交换排序，挖坑填数分区法)前数组
        System.out.println("快速排序(交换排序，挖坑填数分区法)前数组：" + Arrays.toString(arr));
        // 生成快速排序(交换排序，挖坑填数分区法)新数组
        int[] quickSortArr = getNewArr(arr);
        // 快速排序(交换排序，挖坑填数分区法)后数组
        System.out.println("快速排序(交换排序，挖坑填数分区法)后数组：" + Arrays.toString(quickSort(quickSortArr, 0, quickSortArr.length - 1)));

        // 快速排序(交换排序，交换分区法，最简单的分区算法)前数组
        System.out.println("快速排序(交换排序，交换分区法，最简单的分区算法)前数组：" + Arrays.toString(arr));
        // 生成快速排序(交换排序，交换分区法，最简单的分区算法)新数组
        int[] quickSortArr2 = getNewArr(arr);
        // 快速排序2(交换排序，交换分区法，最简单的分区算法)后数组
        System.out.println("快速排序(交换排序，交换分区法，最简单的分区算法)后数组：" + Arrays.toString(quickSort2(quickSortArr2)));

        // 快速排序(交换排序，双指针分区法)前数组
        System.out.println("快速排序(交换排序，双指针分区法)前数组：" + Arrays.toString(arr));
        // 生成快速排序(交换排序，双指针分区法)新数组
        int[] quickSortArr3 = getNewArr(arr);
        // 快速排序(交换排序，双指针分区法)后数组
        System.out.println("快速排序(交换排序，双指针分区法)后数组：" + Arrays.toString(quickSort3(quickSortArr3)));

        // 直接插入排序(插入排序，交换法)前数组
        System.out.println("直接插入排序(插入排序，交换法)前数组：" + Arrays.toString(arr));
        // 生成直接插入排序(插入排序，交换法)新数组
        int[] directlyInsertSortArr = getNewArr(arr);
        // 直接插入排序(插入排序，交换法)后数组
        System.out.println("直接插入排序(插入排序，交换法)后数组：" + Arrays.toString(directlyInsertSort(directlyInsertSortArr)));

        // 直接插入排序(插入排序，移动法)前数组
        System.out.println("直接插入排序(插入排序，移动法)前数组：" + Arrays.toString(arr));
        // 生成直接插入排序(插入排序，移动法)新数组
        int[] directlyInsertSortArr2 = getNewArr(arr);
        // 直接插入排序(插入排序，移动法)后数组
        System.out.println("直接插入排序(插入排序，移动法)后数组：" + Arrays.toString(directlyInsertSort2(directlyInsertSortArr2)));

        // 希尔排序(插入排序，希尔增量序列法)前数组
        System.out.println("希尔排序(插入排序，希尔增量序列法)前数组：" + Arrays.toString(arr));
        // 生成希尔排序(插入排序，希尔增量序列法)新数组
        int[] shellSortArr = getNewArr(arr);
        // 希尔排序(插入排序，希尔增量序列法)后数组
        System.out.println("希尔排序(插入排序，希尔增量序列法)后数组：" + Arrays.toString(shellSort(shellSortArr)));

        // 希尔排序(插入排序，Knuth增量序列法)前数组
        System.out.println("希尔排序(插入排序，Knuth增量序列法)前数组：" + Arrays.toString(arr));
        // 生成希尔排序(插入排序，Knuth增量序列法)新数组
        int[] shellSortArr2 = getNewArr(arr);
        // 希尔排序(插入排序，Knuth增量序列法)后数组
        System.out.println("希尔排序(插入排序，Knuth增量序列法)后数组：" + Arrays.toString(shellSort2(shellSortArr2)));

        // 直接选择排序(选择排序)前数组
        System.out.println("直接选择排序(选择排序)前数组：" + Arrays.toString(arr));
        // 生成直接选择排序(选择排序)新数组
        int[] directlySelectSortArr = getNewArr(arr);
        // 直接选择排序(选择排序)后数组
        System.out.println("直接选择排序(选择排序)后数组：" + Arrays.toString(directlySelectSort(directlySelectSortArr)));

        // 堆排序(选择排序，写法1)前数组
        System.out.println("堆排序(选择排序，写法1)前数组：" + Arrays.toString(arr));
        // 生成堆排序(选择排序，写法1)新数组
        int[] heapSortArr = getNewArr(arr);
        // 堆排序(选择排序，写法1)后数组
        System.out.println("堆排序(选择排序，写法1)后数组：" + Arrays.toString(heapSort(heapSortArr)));

        // 堆排序(选择排序，写法2)前数组
        System.out.println("堆排序(选择排序，写法2)前数组：" + Arrays.toString(arr));
        // 生成堆排序(选择排序，写法2)新数组
        int[] heapSortArr2 = getNewArr(arr);
        // 堆排序(选择排序，写法2)后数组
        System.out.println("堆排序(选择排序，写法2)后数组：" + Arrays.toString(heapSort2(heapSortArr2)));

        // 归并排序前数组
        System.out.println("归并排序(写法1，在递归过程中，开辟了很多临时空间，不推荐)前数组：" + Arrays.toString(arr));
        // 生成归并排序新数组
        int[] mergeSortArr = getNewArr(arr);
        // 归并排序后数组
        System.out.println("归并排序(写法1，在递归过程中，开辟了很多临时空间，不推荐)后数组：" + Arrays.toString(mergeSort(mergeSortArr)));

        // 归并排序(写法2，减少临时空间的开辟，在归并排序之前，先开辟出一个临时空间，推荐)前数组
        System.out.println("归并排序(写法2，减少临时空间的开辟，在归并排序之前，先开辟出一个临时空间，推荐)前数组：" + Arrays.toString(arr));
        // 生成归并排序(写法2，减少临时空间的开辟，在归并排序之前，先开辟出一个临时空间，推荐)新数组
        int[] mergeSortArr2 = getNewArr(arr);
        // 归并排序(写法2，减少临时空间的开辟，在归并排序之前，先开辟出一个临时空间，推荐)后数组
        System.out.println("归并排序(写法2，减少临时空间的开辟，在归并排序之前，先开辟出一个临时空间，推荐)后数组：" + Arrays.toString(mergeSort2(mergeSortArr2)));

        // 计数排序(顺序遍历法，初版)前数组
        System.out.println("计数排序(顺序遍历法，初版)前数组：" + Arrays.toString(arr));
        // 生成计数排序(顺序遍历法，初版)新数组
        int[] countingSortArr = getNewArr(arr);
        // 计数排序(顺序遍历法，初版)后数组
        System.out.println("计数排序(顺序遍历法，初版)后数组：" + Arrays.toString(countingSort(countingSortArr)));

        // 计数排序(顺序遍历法，完善版)前数组
        System.out.println("计数排序(顺序遍历法，完善版)前数组：" + Arrays.toString(arr));
        // 生成计数排序(顺序遍历法，完善版)新数组
        int[] countingSortArr2 = getNewArr(arr);
        // 计数排序(顺序遍历法，完善版)后数组
        System.out.println("计数排序(顺序遍历法，完善版)后数组：" + Arrays.toString(countingSort2(countingSortArr2)));

        // 计数排序(倒序遍历法，注意不是倒序排，而是遍历数组时倒序遍历，仍然是顺序排的结果)前数组
        System.out.println("计数排序(倒序遍历法，注意不是倒序排，而是遍历数组时倒序遍历，仍然是顺序排的结果)前数组：" + Arrays.toString(arr));
        // 生成计数排序(倒序遍历法，注意不是倒序排，而是遍历数组时倒序遍历，仍然是顺序排的结果)新数组
        int[] countingSortArr3 = getNewArr(arr);
        // 计数排序(倒序遍历法，注意不是倒序排，而是遍历数组时倒序遍历，仍然是顺序排的结果)后数组
        System.out.println("计数排序(倒序遍历法，注意不是倒序排，而是遍历数组时倒序遍历，仍然是顺序排的结果)后数组：" + Arrays.toString(countingSort3(countingSortArr3)));

        // 基数排序(LSD，即最低位优先法，写法1)前数组
        System.out.println("基数排序(LSD，即最低位优先法，写法1)前数组：" + Arrays.toString(arr));
        // 生成基数排序(LSD，即最低位优先法，写法1)新数组
        int[] radixSortArr = getNewArr(arr);
        // 基数排序(LSD，即最低位优先法，写法1)后数组
        System.out.println("基数排序(LSD，即最低位优先法，写法1)后数组：" + Arrays.toString(radixSort(radixSortArr)));

        // 基数排序(LSD，即最低位优先法，写法2)前数组
        System.out.println("基数排序(LSD，即最低位优先法，写法2)前数组：" + Arrays.toString(arr));
        // 生成基数排序(LSD，即最低位优先法，写法2)新数组
        int[] radixSortArr2 = getNewArr(arr);
        // 基数排序(LSD，即最低位优先法，写法2)后数组
        System.out.println("基数排序(LSD，即最低位优先法，写法2)后数组：" + Arrays.toString(radixSort2(radixSortArr2)));

        // 基数排序(MSD，即最高位优先法)前数组
        System.out.println("基数排序(MSD，即最高位优先法)前数组：" + Arrays.toString(arr));
        // 生成基数排序(MSD，即最高位优先法)新数组
        int[] radixSortArr3 = getNewArr(arr);
        // 基数排序(MSD，即最高位优先法)后数组
        System.out.println("基数排序(MSD，即最高位优先法)后数组：" + Arrays.toString(radixSort3(radixSortArr3)));
    }

    // 冒泡排序(交换排序)，稳定算法，时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] bubbleSort(int[] arr) {
        // 需要进行排序的趟数刚好为数组arr的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
        for (int i = 0; i < arr.length - 1; ++i) {
            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    // 若当前元素大于下一个元素，交换两个元素
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
        }

        return arr;
    }

    // 冒泡排序改进(交换排序)，稳定算法，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] bubbleSort2(int[] arr) {
        // 需要进行排序的趟数刚好为数组arr的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
        for (int i = 0; i < arr.length - 1; ++i) {
            // 判断数组是否已经有序
            boolean flag = true;

            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    // 若当前元素大于下一个元素，交换两个元素
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    // 出现交换，那么数组还不是有序
                    flag = false;
                }
            }

            if (flag) {
                // 若数组已经有序，结束循环
                break;
            }
        }

        return arr;
    }

    // 快速排序(交换排序，挖坑填数分区法)，不稳定算法，平均时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(n^2)，空间复杂度O(logn) ~ O(n)，平均空间复杂度O(logn)
    private static int[] quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 0) {
            return arr;
        }

        if (low >= high) {
            return arr;
        }

        int left = low;
        int right = high;

        // 挖坑1：保存基准的值
        int temp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                --right;
            }

            // 坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            arr[left] = arr[right];

            while (left < right && arr[left] <= temp) {
                ++left;
            }

            // 坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            arr[right] = arr[left];
        }

        // 基准值填补到坑3中，准备分治递归快排
        arr[left] = temp;

        System.out.println("quickSort:" + Arrays.toString(arr));

        quickSort(arr, low, left - 1);

        quickSort(arr, left + 1, high);

        return arr;
    }

    // 快速排序(交换排序，交换分区法，最简单的分区算法)，不稳定算法，平均时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(n^2)，空间复杂度O(logn) ~ O(n)，平均空间复杂度O(logn)
    private static int[] quickSort2(int[] arr) {
        quickSort2(arr, 0, arr.length - 1);
        return arr;
    }

    // 快速排序处理
    private static void quickSort2(int[] arr, int start, int end) {
        if (start >= end) {
            // 如果区域内的数字少于2个，结束递归
            return;
        }

        // 对数组分区，并获得中间值的下标
        int middle = partition2(arr, start, end);

        System.out.println("quickSort2:" + Arrays.toString(arr));

        // 对左边区域快速排序
        quickSort2(arr, start, middle - 1);

        // 对右边区域快速排序
        quickSort2(arr, middle + 1, end);
    }

    // 将arr从start到end分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    private static int partition2(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];

        // 从第二个数开始分区
        int left = start + 1;

        // 右边界
        int right = end;

        // left、right相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) {
                ++left;
            }

            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left != right) {
                exchange2(arr, left, right);
                --right;
            }
        }

        // 如果left和right相等，单独比较arr[right]和pivot
        if (left == right && arr[right] > pivot) {
            --right;
        }

        // 将基数和中间数交换
        if (right != start) {
            exchange2(arr, start, right);
        }

        // 返回中间值的下标
        return right;
    }

    // 交换两个数
    private static void exchange2(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    // 快速排序(交换排序，双指针分区法)，不稳定算法，平均时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(n^2)，空间复杂度O(logn) ~ O(n)，平均空间复杂度O(logn)
    private static int[] quickSort3(int[] arr) {
        quickSort3(arr, 0, arr.length - 1);
        return arr;
    }

    // 快速排序处理
    private static void quickSort3(int[] arr, int start, int end) {
        if (start >= end) {
            // 如果区域内的数字少于2个，结束递归
            return;
        }

        // 对数组分区，并获得中间值的下标
        int middle = partition3(arr, start, end);

        System.out.println("quickSort3:" + Arrays.toString(arr));

        // 对左边区域快速排序
        quickSort3(arr, start, middle - 1);

        // 对右边区域快速排序
        quickSort3(arr, middle + 1, end);
    }

    // 将arr从start到end分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    private static int partition3(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];

        // 从第二个数开始分区
        int left = start + 1;

        // 右边界
        int right = end;

        // left、right相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) {
                ++left;
            }

            // 找到第一个小于基数的位置
            while (left < right && arr[right] >= pivot) {
                --right;
            }

            if (left < right) {
                // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
                exchange3(arr, left, right);
                ++left;
                --right;
            }
        }

        // 如果left和right相等，单独比较arr[right]和pivot
        if (left == right && arr[right] > pivot) {
            --right;
        }

        // 将基数和中间数交换
        if (right != start) {
            exchange3(arr, start, right);
        }

        // 返回中间值的下标
        return right;
    }

    // 交换两个数
    private static void exchange3(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    // 直接插入排序(插入排序)，稳定算法，交换法，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] directlyInsertSort(int[] arr) {
        // 从第2个数开始，确定要操作的数，对要操作的数找到要插入的位置
        for (int i = 1; i < arr.length; ++i) {
            // 获取当前数字的下标
            int j = i;

            // 一路往前对比，若当前数字比前一个数字小，那么交换两个数字，通过不断的交换找到这个数合适的位置插入
            while (j >= 1 && arr[j] < arr[j - 1]) {
                // 交换两个数字
                arr[j - 1] ^= arr[j];
                arr[j] ^= arr[j - 1];
                arr[j - 1] ^= arr[j];

                // 下标往前移动
                --j;
            }
        }

        // 返回有序的数组
        return arr;
    }

    // 直接插入排序(插入排序)，稳定算法，移动法，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] directlyInsertSort2(int[] arr) {
        // 从第2个数开始，确定要操作的数，对要操作的数找到要插入的位置
        for (int i = 1; i < arr.length; ++i) {
            // 先把当前要插入的数字保存起来
            int temp = arr[i];

            // 获取当前要插入的数字的前一个下标
            int j = i - 1;

            // 一路往前，和当前要插入的数字比较，若大于当前要插入的数字，那么后移，直到不大于当前要插入的数字或者到了第一个下标，结束循环
            while (j >= 0 && arr[j] > temp) {
                // 后移数字
                arr[j + 1] = arr[j];

                // 下标往前移动
                --j;
            }

            // 找到插入的位置，把当前要插入的数字赋值到这里
            arr[j + 1] = temp;
        }

        // 返回有序的数组
        return arr;
    }

    // 希尔排序(插入排序，希尔增量序列法)，不稳定算法，时间复杂度O(n) ~ O(n^2)，平均时间复杂度O(n^1.3)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] shellSort(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从gap开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; ++i) {
                // currentNumber站起来，开始找位置
                int currentNumber = arr[i];

                // 该组前一个数字的索引
                int preIndex = i - gap;

                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }

                // currentNumber找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }

        return arr;
    }

    // 希尔排序(插入排序，Knuth增量序列法)，不稳定算法，时间复杂度O(n) ~ O(n^2)，平均时间复杂度O(n^1.3)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] shellSort2(int[] arr) {
        // 找到当前数组需要用到的Knuth序列中的最大值
        int maxKnuthNumber = 1;

        while (maxKnuthNumber <= arr.length / 3) {
            maxKnuthNumber = maxKnuthNumber * 3 + 1;
        }

        // 增量按照Knuth序列规则依次递减
        for (int gap = maxKnuthNumber; gap > 0; gap = (gap - 1) / 3) {
            // 从gap开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; ++i) {
                // currentNumber站起来，开始找位置
                int currentNumber = arr[i];

                // 该组前一个数字的索引
                int preIndex = i - gap;

                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }

                // currentNumber找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }

        return arr;
    }

    // 直接选择排序(选择排序)，不稳定算法，平均时间复杂度O(n^2)，最好时间复杂度O(n^2)，最坏时间复杂度O(n^2)，空间复杂度O(1)
    private static int[] directlySelectSort(int[] arr) {
        // 获取数组的长度
        int n = arr.length;

        // 走n-1趟，每趟确定当前的最小值
        for (int i = 0; i < n - 1; ++i) {
            // 定义当前的最小值下标
            int minIndex = i;

            // 最小值下标的值和后面的值逐个比较，找出这里的最小值下标
            for (int j = i + 1; j < n; ++j) {
                // 若当前下标的值比最小值下标的值还小，那么最小值下标设置为当前下标
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // 若后面能找到比最小值下标的值更小的值，那么交换两个元素，否则最小值下标的值就是当前的最小值，无需交换元素
                arr[i] ^= arr[minIndex];
                arr[minIndex] ^= arr[i];
                arr[i] ^= arr[minIndex];
            }
        }

        // 返回排序好的数组
        return arr;
    }

    // 堆排序(选择排序，写法1)，不稳定算法，初始化建堆的时间复杂度为O(n)，重建堆的时间复杂度为O(nlogn)，总时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(nlogn)，空间复杂度O(1)
    private static int[] heapSort(int[] arr) {
        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; --j) {
            // 将堆顶元素与末尾元素进行交换
            swap(arr, j);
            // 重新对堆进行调整
            adjustHeap(arr, 0, j);
        }

        return arr;
    }

    // 调整大顶堆(仅是调整过程，建立在大顶堆已构建的基础上)
    private static void adjustHeap(int[] arr, int i, int length) {
        // 先取出当前元素i
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 如果左子结点小于右子结点，k指向右子结点
                ++k;
            }

            if (arr[k] > temp) {
                // 如果子节点大于父节点，将子节点值赋给父节点(不用进行交换)
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        // 将temp值放到最终的位置
        arr[i] = temp;
    }

    // 交换元素
    private static void swap(int[] arr, int b) {
        int temp = arr[0];
        arr[0] = arr[b];
        arr[b] = temp;
    }

    // 堆排序(选择排序，写法2)，不稳定算法，初始化建堆的时间复杂度为O(n)，重建堆的时间复杂度为O(nlogn)，总时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(nlogn)，空间复杂度O(1)
    private static int[] heapSort2(int[] arr) {
        // 构建初始大顶堆
        buildMaxHeap2(arr);

        for (int i = arr.length - 1; i > 0; --i) {
            // 将最大值交换到数组最后
            swap2(arr, 0, i);

            // 调整剩余数组，使其满足大顶堆
            maxHeapify2(arr, 0, i);
        }

        return arr;
    }

    // 构建初始大顶堆
    private static void buildMaxHeap2(int[] arr) {
        // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是arr.length / 2 - 1
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            maxHeapify2(arr, i, arr.length);
        }
    }

    // 调整大顶堆，第三个参数表示剩余未排序的数字的数量，也就是剩余堆的大小
    private static void maxHeapify2(int[] arr, int i, int heapSize) {
        // 左子结点下标
        int left = 2 * i + 1;

        // 右子结点下标
        int right = left + 1;

        // 记录根结点、左子树结点、右子树结点三者中的最大值下标
        int largest = i;

        // 与左子树结点比较
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // 与右子树结点比较
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            // 将最大值交换为根结点
            swap2(arr, i, largest);

            // 再次调整交换数字后的大顶堆
            maxHeapify2(arr, largest, heapSize);
        }
    }

    // 交换元素
    private static void swap2(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 归并排序(写法1，在递归过程中，开辟了很多临时空间，不推荐)，稳定算法，平均时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(nlogn)，空间复杂度O(n)
    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            // 若数组长度小于等于1，直接返回，无需再拆分
            return arr;
        }

        // 除以2取中间值
        int num = arr.length >> 1;

        // 拆分数组，从开头到中间值
        int[] left = Arrays.copyOfRange(arr, 0, num);

        // 拆分数组，从中间值加1到结尾
        int[] right = Arrays.copyOfRange(arr, num, arr.length);

        // 进行归并第二步排序
        return mergeTwoArray(mergeSort(left), mergeSort(right));
    }

    // 归并第二步排序
    private static int[] mergeTwoArray(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;

        // 申请额外空间保存归并之后数据
        int[] result = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            // 选取两个序列中的较小值放入新数组
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            // 序列a中多余的元素移入新数组
            result[k++] = a[i++];
        }

        while (j < b.length) {
            // 序列b中多余的元素移入新数组
            result[k++] = b[j++];
        }

        return result;
    }

    // 归并排序(写法2，减少临时空间的开辟，在归并排序之前，先开辟出一个临时空间，推荐)，稳定算法，平均时间复杂度O(nlogn)，最好时间复杂度O(nlogn)，最坏时间复杂度O(nlogn)，空间复杂度O(n)
    private static int[] mergeSort2(int[] arr) {
        if (arr.length == 0) {
            // 若数组长度等于0，直接返回
            return arr;
        }

        // 先申请开辟一个临时空间，通过参数传递进去，后面归并排序的方法里就不再需要再申请开辟临时空间
        int[] result = new int[arr.length];

        // 进行归并排序
        mergeSort2(arr, 0, arr.length - 1, result);

        return arr;
    }

    // 对arr的[start, end]区间归并排序
    private static void mergeSort2(int[] arr, int start, int end, int[] result) {
        // 只剩下一个数字，停止拆分
        if (start == end) {
            return;
        }

        // 除以2取中间值
        int middle = (start + end) / 2;

        // 拆分左边区域，并将归并排序的结果保存到result的[start, middle]区间
        mergeSort2(arr, start, middle, result);

        // 拆分右边区域，并将归并排序的结果保存到result的[middle + 1, end]区间
        mergeSort2(arr, middle + 1, end, result);

        // 合并左右区域到result的[start, end]区间
        merge2(arr, start, end, result);
    }

    // 将result的[start, middle]和[middle + 1, end]区间合并
    private static void merge2(int[] arr, int start, int end, int[] result) {
        // 中间位置
        int end1 = (start + end) / 2;

        // 中间位置加1
        int start2 = end1 + 1;

        // 数组1的起始指针，从开始位置开始
        int index1 = start;

        // 数组2的起始指针，从中间位置加1开始
        int index2 = start2;

        // 把数组拆分成数组1和数组2，先构造数组1和数组2位置相同的元素
        // 这里把原来的两个有序的列表合并成一个有序的列表，改造成在一个数组中的[start, end]区间内进行，但是在[start, end]区间内进行逻辑上的拆分
        while (index1 <= end1 && index2 <= end) {
            if (arr[index1] <= arr[index2]) {
                result[index1 + index2 - start2] = arr[index1++];
            } else {
                result[index1 + index2 - start2] = arr[index2++];
            }
        }

        // 若数组1比数组2长，将剩余的元素补充好到result数组
        while (index1 <= end1) {
            result[index1 + index2 - start2] = arr[index1++];
        }

        // 若数组2比数组1长，将剩余的元素补充好到result数组
        while (index2 <= end) {
            result[index1 + index2 - start2] = arr[index2++];
        }

        // 将result操作区间的数字拷贝到arr数组中，以便下次比较
        while (start <= end) {
            arr[start] = result[start++];
        }
    }

    // 计数排序(顺序遍历法，初版)，稳定算法，时间复杂度O(n+k)(k表示数据的范围大小)，空间复杂度O(n+k)(k表示数据的范围大小)
    private static int[] countingSort(int[] arr) {
        // 建立长度为9的数组，下标0~8对应数字1~9
        int[] counting = new int[9];

        // 遍历arr中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置
            counting[element - 1]++;
        }

        // 记录前面比自己小的数字的总数
        int preCounts = 0;

        // 把原来counting保存每个整数出现的次数变成保存每个整数的起始下标
        for (int i = 0; i < counting.length; ++i) {
            // 获取当前整数出现的次数
            int temp = counting[i];

            // 将counting计算成当前数字在结果中的起始下标位置，位置=前面比自己小的数字的总数
            counting[i] = preCounts;

            // 当前的数字比下一个数字小，累计到preCounts中
            preCounts += temp;
        }

        // 开辟一个数组来保存结果
        int[] result = new int[arr.length];

        for (int element : arr) {
            // counting[element - 1]表示此元素在结果数组中的下标
            int index = counting[element - 1];

            // 赋值给数组
            result[index] = element;

            // 更新counting[element - 1]，指向此元素的下一个下标
            counting[element - 1]++;
        }

        // 将结果赋值回arr
        System.arraycopy(result, 0, arr, 0, arr.length);

        return arr;
    }

    // 计数排序(顺序遍历法，完善版)，稳定算法，时间复杂度O(n+k)(k表示数据的范围大小)，空间复杂度O(n+k)(k表示数据的范围大小)
    private static int[] countingSort2(int[] arr) {
        // 判空及防止数组越界
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 找到最大值，最小值
        int max = arr[0];

        int min = arr[0];

        // 寻找最大值和最小值
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 确定计数范围
        int range = max - min + 1;

        // 建立长度为range的数组，下标0~range-1对应数字min~max
        int[] counting = new int[range];

        // 遍历arr中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去min，才能映射到0～range-1范围内
            counting[element - min]++;
        }

        // 记录前面比自己小的数字的总数
        int preCounts = 0;

        for (int i = 0; i < range; ++i) {
            // 当前的数字比下一个数字小，累计到preCounts中
            preCounts += counting[i];

            // 将counting计算成当前数字在结果中的起始下标位置，位置=前面比自己小的数字的总数
            counting[i] = preCounts - counting[i];
        }

        int[] result = new int[arr.length];

        for (int element : arr) {
            // counting[element - min]表示此元素在结果数组中的下标
            result[counting[element - min]] = element;

            // 更新counting[element - min]，指向此元素的下一个下标
            counting[element - min]++;
        }

        // 将结果赋值回arr
        System.arraycopy(result, 0, arr, 0, arr.length);

        return arr;
    }

    // 计数排序(倒序遍历法，注意不是倒序排，而是遍历数组时倒序遍历，仍然是顺序排的结果)，稳定算法，时间复杂度O(n+k)(k表示数据的范围大小)，空间复杂度O(n+k)(k表示数据的范围大小)
    private static int[] countingSort3(int[] arr) {
        // 防止数组越界
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];

        // 寻找最大值和最小值
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 确定计数范围
        int range = max - min + 1;

        // 建立长度为range的数组，下标0~range-1对应数字min~max
        int[] counting = new int[range];

        // 遍历arr中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去min，才能映射到0～range-1范围内
            counting[element - min]++;
        }

        // 每个元素在结果数组中的最后一个下标位置 = 前面比自己小的数字的总数 + 自己的数量 - 1，我们将counting[0]先减去1，后续counting直接累加即可
        --counting[0];

        for (int i = 1; i < range; ++i) {
            // 将counting计算成当前数字在结果中的最后一个下标位置，位置=前面比自己小的数字的总数 + 自己的数量 - 1
            // 由于counting[0]已经减了1，所以后续的减1可以省略。
            counting[i] += counting[i - 1];
        }

        int[] result = new int[arr.length];

        // 从后往前遍历数组，通过counting中记录的下标位置，将arr中的元素放到result数组中
        for (int i = arr.length - 1; i >= 0; --i) {
            // counting[arr[i] - min]表示此元素在结果数组中的下标
            result[counting[arr[i] - min]] = arr[i];
            // 更新counting[arr[i] - min]，指向此元素的前一个下标
            counting[arr[i] - min]--;
        }

        // 将结果赋值回arr
        System.arraycopy(result, 0, arr, 0, arr.length);

        return arr;
    }

    // 基数排序(LSD，即最低位优先法，写法1)，稳定算法，时间复杂度O(d(n+k))(d表示最长数字的位数，k表示每个基数可能的取值范围大小)，空间复杂度O(n+k)(k表示每个基数可能的取值范围大小)
    private static int[] radixSort(int[] arr) {
        int max = arr[0];

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println("radixSort max:" + max);

        int maxDigitLength = 0;

        while (max != 0) {
            max = max / 10;
            maxDigitLength++;
        }

        System.out.println("radixSort maxDigitLength:" + maxDigitLength);

        int[][] buckets = new int[10][arr.length];
        int base = 10;

        // 从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigitLength; ++i) {
            // 存储各个桶中存储元素的数量
            int[] bucketLen = new int[10];

            // 收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            for (int value : arr) {
                int whichBucket = (value % base) / (base / 10);
                buckets[whichBucket][bucketLen[whichBucket]] = value;
                bucketLen[whichBucket]++;
            }

            int k = 0;

            // 收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            for (int l = 0; l < buckets.length; ++l) {
                for (int m = 0; m < bucketLen[l]; ++m) {
                    arr[k++] = buckets[l][m];
                }
            }

            base *= 10;

            System.out.println("radixSort:" + Arrays.toString(arr));
        }

        return arr;
    }

    // 基数排序(LSD，即最低位优先法，写法2)，稳定算法，时间复杂度O(d(n+k))(d表示最长数字的位数，k表示每个基数可能的取值范围大小)，空间复杂度O(n+k)(k表示每个基数可能的取值范围大小)
    private static int[] radixSort2(int[] arr) {
        if (arr == null) {
            return null;
        }

        // 找出最大值
        int max = 0;

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println("radixSort max:" + max);

        // 计算最大数字的长度
        int maxDigitLength = 0;

        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }

        System.out.println("radixSort maxDigitLength:" + maxDigitLength);

        // 使用计数排序算法对基数进行排序
        int[] counting = new int[10];

        int[] result = new int[arr.length];

        int dev = 1;

        for (int i = 0; i < maxDigitLength; ++i) {
            for (int value : arr) {
                int radix = value / dev % 10;
                counting[radix]++;
            }

            for (int j = 1; j < counting.length; ++j) {
                counting[j] += counting[j - 1];
            }

            // 使用倒序遍历的方式完成计数排序
            for (int j = arr.length - 1; j >= 0; --j) {
                int radix = arr[j] / dev % 10;
                result[--counting[radix]] = arr[j];
            }

            // 计数排序完成后，将结果拷贝回arr数组
            System.arraycopy(result, 0, arr, 0, arr.length);

            // 将计数数组重置为0
            Arrays.fill(counting, 0);
            dev *= 10;

            System.out.println("radixSort:" + Arrays.toString(arr));
        }

        return arr;
    }

    // 基数排序(MSD，即最高位优先法)，稳定算法，时间复杂度O(d(n+k))(d表示最长数字的位数，k表示每个基数可能的取值范围大小)，空间复杂度O(n+k)(k表示每个基数可能的取值范围大小)
    private static int[] radixSort3(int[] arr) {
        if (arr == null) {
            return null;
        }

        // 找到最大值
        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }

        // 计算最大长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }

        radixSort3(arr, 0, arr.length - 1, maxDigitLength);

        return arr;
    }

    // 对arr数组中的[start, end]区间进行基数排序
    private static void radixSort3(int[] arr, int start, int end, int position) {
        if (start == end || position == 0) {
            return;
        }

        // 使用计数排序对基数进行排序
        int[] counting = new int[19];

        int[] result = new int[end - start + 1];

        int dev = (int) Math.pow(10, position - 1);

        for (int i = start; i <= end; ++i) {
            // MSD, 从最高位开始
            int radix = arr[i] / dev % 10 + 9;
            counting[radix]++;
        }

        for (int j = 1; j < counting.length; ++j) {
            counting[j] += counting[j - 1];
        }

        // 拷贝counting，用于待会的递归
        int[] countingCopy = new int[counting.length];

        System.arraycopy(counting, 0, countingCopy, 0, counting.length);

        for (int i = end; i >= start; --i) {
            int radix = arr[i] / dev % 10 + 9;
            result[--counting[radix]] = arr[i];
        }

        // 计数排序完成后，将结果拷贝回arr数组
        System.arraycopy(result, 0, arr, start, result.length);

        // 对[start, end]区间内的每一位基数进行递归排序
        for (int i = 0; i < counting.length; ++i) {
            radixSort3(arr, i == 0 ? start : start + countingCopy[i - 1], start + countingCopy[i] - 1, position - 1);
        }
    }

}
