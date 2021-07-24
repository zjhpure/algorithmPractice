package org.pure.algorithm.circleRemainingNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-07-24 20:36
 * @description 圆圈中最后剩下的数字
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String m = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        int result = lastRemaining(Integer.parseInt(n), Integer.parseInt(m));
        System.out.println(result);
    }

    private static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            list.add(i);
        }

        int index = 0;

        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            --n;
        }

        return list.get(0);
    }

}
