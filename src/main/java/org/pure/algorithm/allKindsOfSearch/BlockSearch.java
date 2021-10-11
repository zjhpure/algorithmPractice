package org.pure.algorithm.allKindsOfSearch;

import java.util.ArrayList;
//import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:31
 * @description 分块查找
 */
public class BlockSearch {

    // 原理尚未搞清，待解决

    // 分块查找是顺序查找的一种改进方法，也叫索引顺序查找，性能介于顺序查找和二分查找之间
    // 分块查找将n个数据元素"按块有序"划分为m块(m ≤ n)，每一块中的结点不必有序，但块与块之间必须"按块有序"，第i块中的每个元素一定比第i-1块中的任意元素大(小)

    public static void main(String[] args) {
//        // 获取输入结果
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        int target = scanner.nextInt();
//        scanner.close();
//
//        // 处理输入结果
//        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
//        int size = strs.length;
//        int[] arr = new int[size];
//        for (int i = 0; i < size; ++i) {
//            arr[i] = Integer.parseInt(strs[i]);
//        }
//
//        // 获取输出结果
//        int result = blockSearch(arr, target);
//        System.out.println(result);

        // 索引表
        int[] index = new int[]{10, 20, 30};

        BlockSearch blockSearch = new BlockSearch(index);

        blockSearch.insert(-1);
        blockSearch.insert(10);
        blockSearch.insert(25);

        // 查找
        blockSearch.search(0);
        blockSearch.search(-1);
        blockSearch.search(10);
        blockSearch.search(25);
    }

    private int[] index;

    private ArrayList<ArrayList<Integer>> list;

    // 创建索引表
    private BlockSearch(int[] index) {
        if (index != null && index.length != 0) {
            this.index = index;

            list = new ArrayList<>();

            for (int i = 0; i < index.length; i++) {
                list.add(new ArrayList<>());
            }
        } else {
            throw new Error("index cannot be null or empty.");
        }
    }

    // 对插入数据进行分区
    private void insert(int data) {
        int i = binarySearch(data);
        list.get(i).add(data);
    }

    // 结合二分查找
    private void search(int data) {
        int i = binarySearch(data);

        for (int j = 0; j < list.get(i).size(); j++) {
            if (data == list.get(i).get(j)) {
                System.out.println(String.format("'%d' Position: [%d,%d]", data, i, j));
                return;
            }
        }

        System.out.println(String.format("'%d' Position: Not found", data));
    }

    // 二分查找
    private int binarySearch(int data) {
        if (data > index[index.length - 1]) {
            throw new Error("out of block range");
        }

        int start = 0;

        int end = index.length - 1;

        int mid;

        while (start < end) {
            mid = (start + end) / 2;

            if (index[mid] > data) {
                end = mid - 1;
            } else {
                // 如果相等，也插入后面<=index[start]
                start = mid + 1;
            }
        }

        return start;
    }

//    // 分块查找
//    private static int blockSearch(int[] arr, int target) {
//        // 若没有找到目标值，返回-1
//        return -1;
//    }

}
