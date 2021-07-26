package org.pure.algorithm.circleRemainingNum;

//import java.util.ArrayList;
//import java.util.List;

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

//    // 方法1，模拟法，运行低效，不建议使用，但是这种方法理解最直观，通过这种方法直观地理解计算的过程
//    private static int lastRemaining(int n, int m) {
//        // 这里使用模拟法，比较低效，不建议使用，建议使用递归法或数学法
//
//        // 定义列表list，保存从0到n-1的数字
//        List<Integer> list = new ArrayList<>();
//
//        // 从0遍历到n-1，保存到列表list中
//        for (int i = 0; i < n; ++i) {
//            list.add(i);
//        }
//
//        // 定义要删除的下标，初始为0
//        int index = 0;
//
//        // 循环，直到n个数字中只剩一个为止，结束循环
//        while (n > 1) {
//            // 计算出每次要删除的数字的下标
//            // 例如：0 1 2 3 4，
//
//            // 删除第3个数字，即2，变成：0 1 3 4
//            // 从下一个数字开始计数，即：3 4 0 1
//
//            // 删除第3个数字，即0，变成：3 4 1
//            // 从下一个数字开始计数，即：1 3 4
//
//            // 删除第3个数字，即4，变成：1 3
//            // 从下一个数字开始计数，即：1 3，因为是圆圈循环，补充后面的数字，即：1 3 1 3
//
//            // 删除第3个数字，即1，变成：3，只剩一个数字，结束
//
//            // 可以看到，开始计数后，要删除的下标向后移动m-1个位置，删除这个位置的数字后，后面的全部数字整体向前移动一位，因为是从下一个数字开始再计数的，所以初始下标就是当前下标，那么再向后移动m-1个位置，所以总结就是：要删除的下标每次都是向后移动m-1个位置
//
//            // 因为是圆圈循环，会移动到开头重新开始，但是我们可以把圆圈画面拉直看，我们就会发现，当下标移动到要删除的位置时，当前位置对当前所有数字的长度取余，刚好就是当前位置的下标
//            index = (index + m - 1) % n;
//
//            // 列表list移除此下标的元素
//            list.remove(index);
//
//            // 每次删除一个数字，n减1
//            --n;
//        }
//
//        // 当列表list中的数字只剩一个时，就是圆圈中最后剩下的数字，返回作为结果
//        return list.get(0);
//    }

    // 方法2：数学法，运行高效，建议使用
    private static int lastRemaining(int n, int m) {
        // 这里使用数学法，从后面往前反推

        // 定义剩下数字的下标，圆圈最后剩下1个数字，这个数字的下标是0
        int index = 0;

        // 圆圈在最后一次删除数字时剩下2个数字，从2开始反推
        for (int i = 2; i <= n; ++i) {
            // 计算前一次剩下数字的下标

            // 反推过程如下：

            // 第4轮：最后剩下3时，3的当前的下标是0，从图中可以发现，把当前的下标0放到上一轮中，当前下标0向前走m个位置，就会来到同样是3的位置上，这个位置再取余当前长度i，刚好就会得到3在上一轮中的下标1，即(0 + 3) % 2 = 1，3在第4轮中的下标是1。

            // 第3轮：向后移动m个位置，再对i取余，即(1 + 3) % 3 = 1，3在第3轮中的下标是1。

            // 第2轮：向后移动m个位置，再对i取余，即(1 + 3) % 4 = 0，3在第2轮中的下标是0。

            // 第1轮：向后移动m个位置，再对i取余，即(0 + 3) % 3 = 3，3在第1轮中的下标是3。
            index = (index + m) % i;
        }

        // 因为圆圈的数字从0开始到n-1，所以下标等于当前数字，返回剩下的数字
        return index;
    }

}
