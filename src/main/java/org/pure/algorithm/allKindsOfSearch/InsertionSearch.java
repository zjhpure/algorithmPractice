package org.pure.algorithm.allKindsOfSearch;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-11 19:29
 * @description 插值查找
 */
public class InsertionSearch {

    // 插值查找的序列必须是有序序列
    // 插值查找基于二分查找，是二分查找的改进版，将查找点的选择改进为自适应选择，以提高查找效率
    // 插值查找适合表长较大，关键字分布比较均匀的查找表
    // 例如，在英文字典里面查“apple”，我们翻开字典会从前面开始翻起；要在取值范围1 ~ 10000之间100个元素从小到大均匀分布的数组中查找5，我们会从数组下标较小的开始查找
    // 把mid = left + (right - left) / 2改为mid = left + (target - arr[left]) / (arr[right] - arr[left]) * (right - left)
    // 也就是把比例参数1/2改进为自适应，根据关键字在整个有序表中所处的位置，让mid值的变化更靠近关键字target，这样也就间接地减少了比较次数

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
        int result = insertionSearch(arr, target);
        System.out.println(result);
    }

    // 插值查找，有序查找，时间复杂度O(logn)
    private static int insertionSearch(int[] arr, int target) {
        // 定义左指针
        int left = 0;

        // 定义右指针
        int right = arr.length - 1;

        // 进行插值查找，利用二分查找的原理，只是中间指针的选择有不同
        while (left <= right) {
            // 定义中间指针，唯一和二分查找不同的地方，把比例参数1/2改进为自适应，而不是mid = left + (right - left) / 2，原理就是把1/2换成(target - arr[left]) / (arr[right] - arr[left])
            int mid = left + (target - arr[left]) / (arr[right] - arr[left]) * (right - left);

            if (target == arr[mid]) {
                // 若目标值等于数组的元素，那么找到了目标值，返回下标
                return mid;
            } else if (target < arr[mid]) {
                // 若目标值小于数组的元素，那么目标值落在数组的前半部分，把右指针更新为中间指针减1
                right = mid - 1;
            } else {
                // 若目标值大于数组的元素，那么目标值落在数组的后半部分，把左指针更新为中间指针加1
                left = mid + 1;
            }
        }

        // 若没有找到目标值，返回-1
        return -1;
    }

}
