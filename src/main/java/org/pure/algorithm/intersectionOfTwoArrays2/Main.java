package org.pure.algorithm.intersectionOfTwoArrays2;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-04-18 20:32
 * @description 两个数组的交集II
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs1 = str1.split("\\[")[1].split("]")[0].split(",");
        int size1 = strs1.length;
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; ++i) {
            nums1[i] = Integer.parseInt(strs1[i]);
        }

        // 处理输入结果
        String[] strs2 = str2.split("\\[")[1].split("]")[0].split(",");
        int size2 = strs2.length;
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }

        // 获取输出结果
        int[] results = intersect(nums1, nums2);
        System.out.println(Arrays.toString(results));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        // 定义集合map，保存交集数字，key为下标，value为数字
        Map<Integer, Integer> map = new HashMap<>();

        // 定义下标列表list，保存已找到的交集的下标
        List<Integer> indexList = new ArrayList<>();

        // 遍历数组nums1
        for (int i = 0; i < nums1.length; ++i) {
            int num1 = nums1[i];

            // 遍历数组nums2
            for (int j = 0; j < nums2.length; ++j) {
                int num2 = nums2[j];

                if (num1 == num2 && !map.containsKey(i) && !indexList.contains(j)) {
                    // 若两个数相等、数字不在集合map中、下标不在下标列表list中，则添加到集合map中
                    map.put(i, num1);

                    // 下标列表list添加下标
                    indexList.add(j);
                }
            }
        }

        // 定义数组nums，保存交集结果
        int[] nums = new int[map.size()];

        // 定义数组nums下标
        int n = 0;

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 把元素装进数组nums中
            nums[n] = entry.getValue();

            // 数组nums下标自增
            ++n;
        }

        return nums;
    }

}
