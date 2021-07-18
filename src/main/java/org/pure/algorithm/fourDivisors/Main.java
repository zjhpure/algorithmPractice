package org.pure.algorithm.fourDivisors;

import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-18 16:19
 * @description 四因数
 */
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
        int result = sumFourDivisors(nums);
        System.out.println(result);
    }

    private static int sumFourDivisors(int[] nums) {
        // 枚举法，遍历数组nums，逐个判断元素是否符合四因数的条件，符合条件的各因数相加，最后把它们的和再相加

        // 定义所有符合条件的整数的各因数之和
        int sumTotal = 0;

        // 定义数组nums
        for (int num : nums) {
            // 定义单个整数的各因数之和
            int sumNum = 0;
            // 定义单个整数的各因数数量
            int countNum = 0;

            // 从1遍历到整数的开方，因为开方之后的因数都是和前面部分的因数成对出现的
            for (int i = 1; i * i <= num; ++i) {
                // 通过取余是否等于0判断是否是因数
                if (num % i == 0) {
                    // 取和这个因数匹对的另一个因数
                    int divide = num / i;

                    if (i == divide) {
                        // 若两个因数相等，那么因数数量只算作一个，各因数之和只累加一个因数，例如4 = 2 * 2
                        ++countNum;
                        sumNum += i;
                    } else {
                        // 若两个因数不相等，那么另一个因数在开方之后的那边，因数数量有两个，各因数之和也累加两个因数
                        countNum += 2;
                        sumNum += i;
                        sumNum += divide;
                    }

                    if (countNum > 4) {
                        // 若因数数量超过了4个，那么这个数肯定不符合四个因数的条件了，直接结束循环
                        break;
                    }
                }
            }

            if (countNum == 4) {
                // 只有刚好四个因数的数才是符合条件的，把单个整数的各因数之和累加到所有符合条件的整数的各因数之和
                sumTotal += sumNum;
            }
        }

        // 最后返回所有符合条件的整数的各因数之和
        return sumTotal;
    }

}
