package org.pure.algorithm.superPow;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 12/5/21 10:04 PM
 * @description 超级次方
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs = str2.split("\\[")[1].split("]")[0].split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; ++i) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        // 获取输出结果
        int result = superPow(Integer.parseInt(str1), nums);
        System.out.println(result);
    }

    private static final int MOD = 1337;

    private static int superPow(int a, int[] b) {
        // 倒叙遍历，乘法取模分配律，待理解原理

        int ans = 1;

        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }

        return ans;
    }

    private static int pow(int x, int n) {
        int res = 1;

        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }

        return res;
    }

}
