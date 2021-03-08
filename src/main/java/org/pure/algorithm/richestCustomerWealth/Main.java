package org.pure.algorithm.richestCustomerWealth;

//import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-03-08 20:47
 * @description 最富有客户的资产总量
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        // 获取有多少个一维数组
        int size = 0;
        // 只遍历到倒数第二个字符，因为最后一个字符肯定是]，前面有多少个]字符，那么就有多少个一维数组
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == ']') {
                ++size;
            }
        }

        // 二维数组字符串先把所有括号[]去掉，再通过逗号切割，得到全部元素的字符串数组
        String[] strs = str.replace("[", "").replace("]", "").split(",");

        // 定义每个一维数组的长度
        int everyLength = strs.length / size;

        // 定义二维数组
        int[][] accounts = new int[size][everyLength];

        // 遍历字符串数组
        for (int i = 0; i < strs.length; ++i) {
            // 给二维数组赋值
            accounts[i / everyLength][i % everyLength] = Integer.parseInt(strs[i]);
        }

//        // 打印二维数组
//        System.out.println("accounts:" + Arrays.deepToString(accounts));

        // 获取输出结果
        int result = maximumWealth(accounts);
        System.out.println(result);
    }

    private static int maximumWealth(int[][] accounts) {
        // 总和
        int total = 0;

        // 遍历二维数组
        for (int[] account : accounts) {
            // 一维数组总和
            int sum = 0;

            // 遍历一维数组
            for (int i : account) {
                sum += i;
            }

            // 更新最大的一维数组总和
            if (sum > total) {
                total = sum;
            }
        }

        return total;
    }

}
