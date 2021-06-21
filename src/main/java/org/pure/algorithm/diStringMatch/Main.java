package org.pure.algorithm.diStringMatch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-21 22:25
 * @description 增减字符串匹配
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int[] result = diStringMatch(str);
        System.out.println(Arrays.toString(result));
    }

    private static int[] diStringMatch(String s) {
        // 注意：这里不用重复使用数字，使用的数字范围是0-S.length()

        // 定义数组nums，长度为字符串s的长度加1
        int[] nums = new int[s.length() + 1];

        // 定义最小值min，初始值为0
        int min = 0;

        // 定义最大值max，初始值为字符串长度
        int max = s.length();

        // 遍历字符串s的字符，构造数组nums的前n-1个字符
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'I') {
                // 若是增大，那就是后一个数即将要增大，那么这个位置就要取当前最小的数，因为只有取了当前最小的数，在下一个位置才能保证可以增大
                nums[i] = min;
                // 赋值完，马上使当前最小值加1，因为数字不能重复使用
                ++min;
            } else {
                // 若是减小，那就是后一个数即将要减小，那么这个位置就要取当前最大的数，因为只有取了当前最大的数，在下一个位置才能保证可以减小
                nums[i] = max;
                // 赋值完，马上使当前最大值减1，因为数字不能重复使用
                --max;
            }
        }

        // 构造数组nums的第n个字符，这里赋值为min或max都可以，因为经过遍历后，min自增，max自减，到最后都是剩下刚好没有用到的那个数字
        nums[s.length()] = min;

        return nums;
    }

}
