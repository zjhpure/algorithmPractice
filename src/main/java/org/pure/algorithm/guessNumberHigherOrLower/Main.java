package org.pure.algorithm.guessNumberHigherOrLower;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-14 15:57
 * @description 猜数字大小
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String pick = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = guessNumber(Integer.parseInt(n), Integer.parseInt(pick));
        System.out.println(result);
    }

    private static int guessNumber(int n, int pick) {
        // 定义左右指标，左指标初始为1，右指标初始为n
        int left = 1, right = n;

        // 计算中间指标，不用center = (left + right) / 2来计算，防止计算时溢出
        int center = left + (right - left) / 2;

        // 计算猜测结果
        int result = guess(pick, center);

        // 循环直至guess的结果为0
        while (result != 0) {
            if (result > 0) {
                // 若是大于0，那么pick > num，选出的数字大于猜测的数字，所以选出的数字在区间[mid + 1, right]中
                left = center + 1;
            } else {
                // 若是小于0，那么pick < num，选出的数字小于猜测的数字，所以选出的数字在区间[left, mid - 1]中
                right = center - 1;
            }

            // 计算中间指标，不用center = (left + right) / 2来计算，防止计算时溢出
            center = left + (right - left) / 2;

            // 计算猜测结果
            result = guess(pick, center);
        }

        // 当猜测结果为0时，即为二分查找到的数字
        return center;
    }

    private static int guessNumber2(int n, int pick) {
        // 定义左右指标，左指标初始为1，右指标初始为n
        int left = 1, right = n;

        // 循环直至区间左右端点相同
        while (left < right) {
            // 计算中间指标，不用mid = (left + right) / 2来计算，防止计算时溢出
            int mid = left + (right - left) / 2;

            if (guess(pick, mid) <= 0) {
                // 若是小于等于0，那么pick <= num，选出的数字小于等于猜测的数字，所以选出的数字在区间[left, mid]中
                right = mid;
            } else {
                // 若是大于0，那么pick > num，选出的数字大于猜测的数字，所以选出的数字在区间[mid + 1, right]中
                left = mid + 1;
            }
        }

        // 当left == right时，区间缩为一个点，即为二分查找到的数字
        return left;
    }

    // 比较猜测的数字和选出的数字的关系，注意：这里题目刚好弄反了
    private static int guess(int pick, int num) {
        return Integer.compare(pick, num);
    }

}
