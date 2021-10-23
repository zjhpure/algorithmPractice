package org.pure.algorithm.constructTheRectangle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-10-23 10:49
 * @description 构造矩形
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        int area = scanner.nextInt();
        scanner.close();

        // 获取输出结果
        int[] result = constructRectangle(area);
        System.out.println(Arrays.toString(result));
    }

    private static int[] constructRectangle(int area) {
        // 定义最小差，长度和宽度的差，初始时长度为area，宽度为1
        int minDiff = area - 1;

        // 定义长度和宽度的数组，初始时长度为area，宽度为1
        int[] results = {area, 1};

        // 从1遍历到area的开方，i作为当前的宽度
        for (int i = 1; i * i <= area; ++i) {
            // 若面积除以当前宽度能除尽，那么作为构造方案之一
            if (area % i == 0) {
                // 计算当前长度
                int j = area / i;
                // 计算当前差，即当前长度和宽度的差
                int diff = j - i;
                // 若当前差小于最小差，那么更新最小差，更新长度和宽度的数组，注意j更长作为长度，i更短作为宽度
                if (diff < minDiff) {
                    minDiff = diff;
                    results[0] = j;
                    results[1] = i;
                }
            }
        }

        // 返回长度和宽度的数组
        return results;
    }

}
