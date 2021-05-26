package org.pure.algorithm.shuffleString;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-05-26 19:33
 * @description 重新排列字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
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
        String result = restoreString(s, nums);
        System.out.println(result);
    }

    private static String restoreString(String s, int[] indices) {
        // 定义字符数组，长度和数组indices的长度相等，用来保存重新排列后的字符串的每一个字符
        char[] chars = new char[indices.length];

        // 遍历数组indices
        for (int i = 0; i < indices.length; ++i) {
            // 数组indices的元素就是字符数组的下标，字符数组下标对应的元素就是字符串s第i个字符
            chars[indices[i]] = s.charAt(i);
        }

        // 最后字符数组转为字符串
        return new String(chars);
    }

}
