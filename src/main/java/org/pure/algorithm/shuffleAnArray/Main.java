package org.pure.algorithm.shuffleAnArray;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-11-22 22:10
 * @description 打乱数组
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = str1.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] methods = new String[size];
        for (int i = 0; i < size; ++i) {
            methods[i] = strings[i].split("\"")[1];
        }

        // 处理输入结果
        String[] numStrs = str2.split("\\[\\[\\[")[1].split("]]")[0].split(",");
        int[] nums = new int[numStrs.length];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        System.out.println("methods:" + Arrays.toString(methods));
        System.out.println("nums:" + Arrays.toString(nums));

        // 获取输出结果
        Integer[][] result = run(methods, nums);
        System.out.println(Arrays.deepToString(result));
    }

    private static Integer[][] run(String[] methods, int[] nums) {
        Solution solution = new Solution(nums);

        Integer[][] result = new Integer[methods.length][nums.length];

        result[0] = null;

        for (int i = 1; i < methods.length; ++i) {
            String method = methods[i];

            if ("shuffle".equals(method)) {
                int[] shuffled = solution.shuffle();
//                System.out.println("shuffled:" + Arrays.toString(shuffled));

                for (int j = 0; j < shuffled.length; ++j) {
                    result[i][j] = shuffled[j];
                }
            } else {
                int[] originals = solution.reset();
//                System.out.println("originals:" + Arrays.toString(originals));

                for (int j = 0; j < originals.length; ++j) {
                    result[i][j] = originals[j];
                }
            }
        }

        return result;
    }

}

class Solution {
    // 暴力法

    // 定义返回的数组
    private int[] nums;

    // 定义原数组
    private int[] originals;

    Solution(int[] nums) {
        // 初始化，把输入的数组赋给返回的数组
        this.nums = nums;

        // 原数组生成新对象(不要直接指向nums，因为这样操作，后面的随机打乱会影响到自身)
        originals = new int[nums.length];

        // 把返回的数组复制给原数组
        System.arraycopy(nums, 0, originals, 0, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    int[] reset() {
        // 重设数组就是把原数组复制给返回的数组，这里的第5个参数要填nums.length，不能是originals.length，因为如果初始化之后就马上reset了，这时originals的长度还是0，
        System.arraycopy(originals, 0, nums, 0, nums.length);

        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    int[] shuffle() {
        // 定义随机打乱的数组，最后要把随机打乱的数组复制给返回的数组
        int[] shuffled = new int[nums.length];

        // 定义列表，先保存原返回的数组，利用列表的长度来获取随机数
        List<Integer> list = new ArrayList<>();

        // 遍历原返回的数组，把原返回的数组保存到列表
        for (int num : nums) {
            list.add(num);
        }

        // 定义随机数
        Random random = new Random();

        // 再次遍历原返回的数组，构造随机打乱的数组
        for (int i = 0; i < nums.length; ++i) {
            // 获取不超列表长度范围的随机下标
            int j = random.nextInt(list.size());

            // 从列表中移除随机下标的元素，把元素赋给随机打乱的数组
            shuffled[i] = list.remove(j);
        }

        // 把随机打乱的数组复制给返回的数组
        System.arraycopy(shuffled, 0, nums, 0, nums.length);

        return nums;
    }
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
