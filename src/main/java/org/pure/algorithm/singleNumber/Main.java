package org.pure.algorithm.singleNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-02-06 22:57
 * @description 只出现一次的数字
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
//        int result = singleNumber(nums);
        int result = singleNumber2(nums);
        System.out.println(result);
    }

    // 集合法，但需要额外使用O(n)的空间，不建议使用
    private static int singleNumber(int[] nums) {
        // 定义列表
        List<Integer> list = new ArrayList<>();

        // 遍历nums数组
        for (Integer num : nums) {
            if (list.contains(num)) {
                // 若列表中已存在元素，移除
                list.remove(num);
            } else {
                // 若列表中不存在元素，添加进去
                list.add(num);
            }
        }

        // 因为数组是非空整数数组，而且某个元素之出现一次，其他每个元素都出现两次，所以最后遍历完，列表就会只剩一个元素

        // 最后返回列表的第一个元素
        return list.get(0);
    }

    // 位计算法，不需要额外空间，高效，建议使用
    private static int singleNumber2(int[] nums) {
        int res = 0;

        // 把全部数进行异或运算，最后结果就是只出现一次的元素
        // 因为两个相同数异或为0，0和任何数异或是任何数本身，这里刚好一个元素只出现一次的元素，其他元素都是出现两次
        // 而异或运算符合交换律和结合律，所以等于把所以两两出现的元素刚好抵消成0，最后剩下0异或只出现一次的元素，就是这个元素本身
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

}
