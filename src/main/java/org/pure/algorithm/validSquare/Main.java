package org.pure.algorithm.validSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-28 20:20
 * @description 有效的正方形
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        String str4 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strs1 = str1.split("\\[")[1].split("]")[0].split(",");
        int size1 = strs1.length;
        int[] nums1 = new int[size1];
        for (int i = 0; i < size1; ++i) {
            nums1[i] = Integer.parseInt(strs1[i]);
        }

        // 处理输入结果
        String[] strs2 = str2.split("\\[")[1].split("]")[0].split(",");
        int size2 = strs2.length;
        int[] nums2 = new int[size2];
        for (int i = 0; i < size2; ++i) {
            nums2[i] = Integer.parseInt(strs2[i]);
        }

        // 处理输入结果
        String[] strs3 = str3.split("\\[")[1].split("]")[0].split(",");
        int size3 = strs3.length;
        int[] nums3 = new int[size3];
        for (int i = 0; i < size3; ++i) {
            nums3[i] = Integer.parseInt(strs3[i]);
        }

        // 处理输入结果
        String[] strs4 = str4.split("\\[")[1].split("]")[0].split(",");
        int size4 = strs4.length;
        int[] nums4 = new int[size4];
        for (int i = 0; i < size4; ++i) {
            nums4[i] = Integer.parseInt(strs4[i]);
        }

        double[] aa = {1, 2, 3};

        // 获取输出结果
        boolean result = validSquare(nums1, nums2, nums3, nums4);
        System.out.println(result);
    }

    // 方法1，正确，求出每两个点的距离，如果不出现0并且只有两种距离，那么就是正方形
    private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 这里只计算距离的平方即可，不用开根号多此一举

        // p1和p2之间的距离的平方，根据公式，a点和b点的距离 = (a^2 + b^2)的开根号
        double p12 = Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);

        // p1和p3之间的距离的平方
        double p13 = Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2);

        // p1和p4之间的距离的平方
        double p14 = Math.pow((p1[0] - p4[0]), 2) + Math.pow((p1[1] - p4[1]), 2);

        // p2和p3之间的距离的平方
        double p23 = Math.pow((p2[0] - p3[0]), 2) + Math.pow((p2[1] - p3[1]), 2);

        // p2和p4之间的距离的平方
        double p24 = Math.pow((p2[0] - p4[0]), 2) + Math.pow((p2[1] - p4[1]), 2);

        // p3和p4之间的距离的平方
        double p34 = Math.pow((p3[0] - p4[0]), 2) + Math.pow((p3[1] - p4[1]), 2);

        // 把6个距离的平方保存成数组
        double[] distances = {p12, p13, p14, p23, p24, p34};

        // 定义列表list，保存距离的平方
        List<Double> list = new ArrayList<>();

        // 遍历距离的平方数组
        for (double distance : distances) {
            if (distance == 0) {
                // 如果距离的平方有出现0的，那么这两个点重合，肯定不能构成正方形，返回false
                return false;
            }

            if (!list.contains(distance)) {
                // 如果列表list中没有包含此距离的平方，添加到列表list中
                list.add(distance);
            }
        }

        // 最后，如果列表list中的长度只有2，那么距离的平方只有两种，只有正方形才会出现距离的平方只有两种
        return list.size() == 2;
    }

    // 方法2，错误，通过判断一个点和其他三个点的距离是否能构成三角形，但是这里进行了开根号，开根号后精度丢失，不可能出现相等
    private static boolean validSquare2(int[] p1, int[] p2, int[] p3, int[] p4) {
        // p1和p2之间的距离，根据公式，a点和b点的距离 = (a^2 + b^2)的开根号
        double p12 = Math.sqrt(Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2));

        // p1和p3之间的距离
        double p13 = Math.sqrt(Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2));

        // p1和p4之间的距离
        double p14 = Math.sqrt(Math.pow((p1[0] - p4[0]), 2) + Math.pow((p1[1] - p4[1]), 2));

        // 若四个点能构成正方形，那么三个点就能构成三角形，根据勾股定理，如果p12^2 + p13^2 = p23^2，那么这三点就能构成三角形，如果是正方形，那么交叉线相等，所以p14 = p23，所以p12^2 + p13^2 = p14^2，所以这里只需要判断p12^2 + p13^2 = p14^2是否成立即可，如果成立，那么四个点能构成正方形，否则不能(注意：这里的顺序可能会不同，所以要判断三种情况，有一种情况满足即可)
        return Math.pow(p12, 2) + Math.pow(p13, 2) == Math.pow(p14, 2) || Math.pow(p12, 2) + Math.pow(p14, 2) == Math.pow(p13, 2) || Math.pow(p13, 2) + Math.pow(p14, 2) == Math.pow(p12, 2);
    }

    // 方法3，错误，和方法2的思路一样，但是改进了方法2，不开根号，精度不丢失，判断了两点不能重复，但是还是错误的，因为没有考虑另外一种情况，当三个点在一条直线上，例如：[1,1],[1,2],[0,2],[0,0]
    public boolean validSquare3(int[] p1, int[] p2, int[] p3, int[] p4) {
        // p1和p2之间的距离的平方，根据公式，a点和b点的距离 = (a^2 + b^2)的开根号
        double p12 = Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);

        if (p12 == 0) {
            // // 点p1和点p2不能重复，若有两个点的距离的平方等于0，那么两个点的距离等于0，那么两个点重合，有两个点重合就可能构成正方形
            return false;
        }

        // p1和p3之间的距离的平方
        double p13 = Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2);

        if (p13 == 0) {
            // 点p1和点p3不能重复
            return false;
        }

        // p1和p4之间的距离的平方
        double p14 = Math.pow((p1[0] - p4[0]), 2) + Math.pow((p1[1] - p4[1]), 2);

        if (p14 == 0) {
            // 点p1和点p4不能重复
            return false;
        }

        // 若四个点能构成正方形，那么三个点就能构成三角形，根据勾股定理，如果p12^2 + p13^2 = p23^2，那么这三点就能构成三角形，如果是正方形，那么交叉线相等，所以p14 = p23，所以p12^2 + p13^2 = p14^2，所以这里只需要判断p12^2 + p13^2 = p14^2是否成立即可，如果成立，那么四个点能构成正方形，否则不能(注意：这里的顺序可能会不同，所以要判断三种情况，有一种情况满足即可)

        // 这里前面不开根号，直接保留平方，这里判断的时候直接使用上面计算好的平方来判断
        // 前面不能开根号，因为开根号后精度会丢失，开根号后这里再平方一次，已经不是原来的值了
        return (p12 == p13 && p12 + p13 == p14) || (p12 == p14 && p12 + p14 == p13) || (p13 == p14 && p13 + p14 == p12);
    }

}
