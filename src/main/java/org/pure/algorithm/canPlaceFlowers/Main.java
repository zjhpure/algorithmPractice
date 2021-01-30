package org.pure.algorithm.canPlaceFlowers;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-30 17:00
 * @description 种花问题
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String n = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] flowerbed = new int[size];
        for (int i = 0; i < size; ++i) {
            flowerbed[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        boolean result = canPlaceFlowers(flowerbed, Integer.parseInt(n));
        System.out.println(result);
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 定义种花数量
        int num = 0;

        // 花坛数组长度
        int size = flowerbed.length;

        // 遍历花坛数组
        for (int i = 0; i < size; ++i) {
            int flower = flowerbed[i];

            if (flower == 0) {
                // 若是0，判断能否种下花
                if (i == 0) {
                    // 第1个元素
                    if (size > 1 && flowerbed[i + 1] == 0) {
                        // 若后元素为0，那么这个元素可以种下花，把此元素改为1
                        flowerbed[i] = 1;
                        // 种花数量加1
                        ++num;
                    } else if (size <= 1) {
                        // 若花坛数组长度只有1，种花数量加1
                        ++num;
                    }
                } else if (i == size - 1) {
                    // 第2个元素
                    if (flowerbed[i - 1] == 0) {
                        // 若前元素为0，那么这个元素可以种下花，把此元素改为1
                        flowerbed[i] = 1;
                        // 种花数量加1
                        ++num;
                    }
                } else {
                    // 中间元素
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        // 若前后元素都为0，那么这个元素可以种下花，把此元素改为1
                        flowerbed[i] = 1;
                        // 种花数量加1
                        ++num;
                    }
                }

                if (num >= n) {
                    // 若种花数量达到了n值，那么就是可以种入n朵花，可以直接就返回true
                    return true;
                }
            }
        }

        // 若种花数量达到了n值，那么返回true
        // 若种花数量没有达到了n值，那么返回false
        return num >= n;
    }

}
