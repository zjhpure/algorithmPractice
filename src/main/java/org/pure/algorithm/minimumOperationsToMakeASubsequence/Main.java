package org.pure.algorithm.minimumOperationsToMakeASubsequence;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-07-26 20:51
 * @description 得到子序列的最少操作次数
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
        int result = minOperations(nums1, nums2);
        System.out.println(result);
    }

    private static int minOperations(int[] target, int[] arr) {
        // 这道题的思路还不是很理解，先放着，日后还需要理解清楚

        // 数组target和数组arr的公共子序列越长，需要添加的元素个数也就越少
        // 所以最少添加的元素个数为：n - 两数组的最长公共子序列的长度

        // 定义集合map
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组target的元素，把数组target里的元素保存到集合map中
        for (int i = 0; i < target.length; ++i) {
            // 记录数组target中各个元素的下标
            map.put(target[i], i);
        }

        // 定义列表list，长度和数组arr相等
        List<Integer> list = new ArrayList<>(arr.length);

        // 遍历数组arr的元素，保存在集合map中有的元素到列表list中
        for (int value : arr) {
            if (map.containsKey(value)) {
                // 若在集合map中有此元素，保存元素在数组target中的下标到列表list中
                list.add(map.get(value));
            }
        }

        // 使用贪心+二分查找法，找到两数组的最长公共子序列的长度
        // 求原来两数组的最长公共子序列等价于求数组target的下标数组和列表list的最长公共子序列。

        // 定义两数组的公共子序列长度
        int res = 0;

        // 定义数组dp，长度为列表list的长度
        int[] dp = new int[list.size()];

        // 遍历列表list的元素
        for (int num : list) {
            // 定义头指针为0
            int start = 0;
            // 定义尾指针为当前两数组的公共子序列长度
            int end = res;

            // 当头指针小于尾指针时，循环；当头指针大于等于尾指针时，结束循环
            while (start < end) {
                // 中间指针 = 头指针 + (尾指针 -  头指针) / 2
                int mid = start + (end - start) / 2;

                if (dp[mid] < num) {
                    // 若数组dp的中间指针位置元素小于当前元素，头指针 = 中间指针 + 1
                    start = mid + 1;
                } else {
                    // 若数组dp的中间指针位置元素大于等于当前元素，尾指针 = 中间指针
                    end = mid;
                }
            }

            // 数组dp赋值为当前元素
            dp[start] = num;

            if (start == res) {
                // 若头指针等于当前两数组的公共子序列长度，两数组的公共子序列长度加1
                ++res;
            }
        }

        // 最少添加的元素个数为：n - 两数组的最长公共子序列的长度
        return target.length - res;
    }

}
