package org.pure.algorithm.twoSum;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-17 02:38
 * @description 两数之和
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i != j && nums[i] + nums[j] == target) {
                    int[] results = {i, j};
                    return results;
                }
            }
        }
        return null;
    }

}
