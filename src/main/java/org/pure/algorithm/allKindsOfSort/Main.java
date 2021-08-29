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

        // 快速排序(交换排序)前数组
        System.out.println("快速排序(交换排序)前数组：" + Arrays.toString(arr));
        // 生成快速排序(交换排序)新数组
        int[] quickSortArr = getNewArr(arr);
        // 快速排序(交换排序)后数组
        System.out.println("快速排序(交换排序)后数组：" + Arrays.toString(quickSort(quickSortArr, 0, quickSortArr.length - 1)));

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

        // 希尔排序(插入排序)前数组
        System.out.println("希尔排序(插入排序)前数组：" + Arrays.toString(arr));
        // 生成希尔排序(插入排序)新数组
        int[] shellSortArr = getNewArr(arr);
        // 希尔排序(插入排序)后数组
        System.out.println("希尔排序(插入排序)后数组：" + Arrays.toString(shellSort(shellSortArr)));

        // 直接选择排序(选择排序)前数组
        System.out.println("直接选择排序(选择排序)前数组：" + Arrays.toString(arr));
        // 生成直接选择排序(选择排序)新数组
        int[] directlySelectSortArr = getNewArr(arr);
        // 直接选择排序(选择排序)后数组
        System.out.println("直接选择排序(选择排序)后数组：" + Arrays.toString(directlySelectSort(directlySelectSortArr)));

        // 堆排序(选择排序)前数组
        System.out.println("堆排序(选择排序)前数组：" + Arrays.toString(arr));
        // 生成堆排序(选择排序)新数组
        int[] heapSortArr = getNewArr(arr);
        // 堆排序(选择排序)后数组
        System.out.println("堆排序(选择排序)后数组：" + Arrays.toString(heapSort(heapSortArr)));

        // 归并排序前数组
        System.out.println("归并排序前数组：" + Arrays.toString(arr));
        // 生成归并排序新数组
        int[] mergeSortArr = getNewArr(arr);
        // 归并排序后数组
        System.out.println("归并排序后数组：" + Arrays.toString(mergeSort(mergeSortArr)));

        // 基数排序前数组
        System.out.println("基数排序前数组：" + Arrays.toString(arr));
        // 生成基数排序新数组
        int[] radixSortArr = getNewArr(arr);
        // 基数排序后数组
        System.out.println("基数排序后数组：" + Arrays.toString(radixSort(radixSortArr)));
    }

    // 冒泡排序(交换排序)，时间复杂度O(n^2)，空间复杂度O(1)
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

    // 冒泡排序改进(交换排序)，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
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

    // 快速排序(交换排序)
    private static int[] quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length <= 0) {
            return arr;
        }

        if (low >= high) {
            return arr;
        }

        int left = low;
        int right = high;
        int temp = arr[left]; // 挖坑1：保存基准的值

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }

            arr[left] = arr[right]; // 坑2：从后向前找到比基准小的元素，插入到基准位置坑1中

            while (left < right && arr[left] <= temp) {
                left++;
            }

            arr[right] = arr[left]; // 坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
        }

        arr[left] = temp; // 基准值填补到坑3中，准备分治递归快排

        System.out.println("quickSort:" + Arrays.toString(arr));

        quickSort(arr, low, left - 1);

        quickSort(arr, left + 1, high);

        return arr;
    }

    // 直接插入排序(插入排序)，交换法，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
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

    // 直接插入排序(插入排序)，移动法，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
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

    // 希尔排序(插入排序)
    private static int[] shellSort(int[] arr) {
        int gap = arr.length / 2;

        for (; gap > 0; gap = gap / 2) {
            for (int j = 0; (j + gap) < arr.length; ++j) {
                // 不断缩小gap，直到1为止
                for (int k = 0; (k + gap) < arr.length; k += gap) {
                    // 使用当前gap进行组内插入排序
                    if (arr[k] > arr[k + gap]) {
                        // 交换操作
                        arr[k] = arr[k] + arr[k + gap];
                        arr[k + gap] = arr[k] - arr[k + gap];
                        arr[k] = arr[k] - arr[k + gap];
//                        System.out.println("shellSort:" + Arrays.toString(arr));
                    }
                }
            }
        }

        return arr;
    }

    // 直接选择排序(选择排序)，平均时间复杂度O(n^2)，最好时间复杂度O(n^2)，最坏时间复杂度O(n^2)，空间复杂度O(1)
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

    // 堆排序(选择排序)
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
                k++;
            }

            if (arr[k] > temp) {
                // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
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

    // 归并排序
    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int num = arr.length >> 1;

        int[] left = Arrays.copyOfRange(arr, 0, num);

        int[] right = Arrays.copyOfRange(arr, num, arr.length);

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

    // 基数排序
    private static int[] radixSort(int[] arr) {
        int max = arr[0];

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

//        System.out.println("max:" + max);

        int maxDigit = 0;

        while (max != 0) {
            max = max / 10;
            maxDigit++;
        }

//        System.out.println("maxDigit:" + maxDigit);

        int[][] buckets = new int[10][arr.length];
        int base = 10;

        // 从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; ++i) {
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

//            System.out.println("radixSort:" + Arrays.toString(arr));
        }

        return arr;
    }

}
