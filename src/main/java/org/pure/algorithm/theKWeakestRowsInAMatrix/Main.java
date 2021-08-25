package org.pure.algorithm.theKWeakestRowsInAMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-08-25 00:46
 * @description 矩阵中战斗力最弱的K行
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        // 处理输入结果，切割字符串，遍历字符串数组，构造字符串列表
        String[] strings = items.split("\\[\\[")[1].split("]]")[0].split("],\\[");
        List<List<String>> lists = new ArrayList<>();
        for (String string : strings) {
            String[] strs = string.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(strs));
            lists.add(list);
        }

        // 处理输入结果，通过字符串列表构造二维整数数组
        int[][] mat = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            mat[i] = ints;
        }

        // 获取输出结果
        int[] result = kWeakestRows(mat, k);
        System.out.println(Arrays.toString(result));
    }

//    // 方法1，直接遍历矩阵来统计军人数目，使用列表来保存每行的信息，列表元素使用数组来保存每行的军人数目和行标，比较占时间和空间，不推荐，方法2进行优化
//    private static int[] kWeakestRows(int[][] mat, int k) {
//        // 思路：统计每行的军人数目，使用改造后的冒泡排序进行排序，取排序后的前k个
//
//        // 定义列表list，用数组int[]保存每个元素，数组int[]第一个元素保存行标，第二个元素保存这行的军人数目
//        List<int[]> list = new ArrayList<>();
//
//        // 遍历矩阵mat的行
//        for (int i = 0; i < mat.length; ++i) {
//            // 获取矩阵mat的行
//            int[] row = mat[i];
//
//            // 定义军人数目，初始为0
//            int count = 0;
//
//            // 遍历每行的列
//            for (int col : row) {
//                if (1 == col) {
//                    // 若元素是1，那么就是军人，军人数目加1
//                    ++count;
//                }
//            }
//
//            // 保存每行的军人数目到列表list，用数组表示，数组的第一个元素保存行标，第二个元素保存这行的军人数目
//            list.add(new int[]{i, count});
//        }
//
//        // 改造冒泡排序，平时冒泡排序用来对数组int[]进行排序，但这里用来对列表list进行排序，并且列表元素是数组，，平均时间复杂度O(n^2)，最好时间复杂度O(n)，最坏时间复杂度O(n^2)，空间复杂度O(1)
//
//        // 需要进行排序的趟数刚好为列表list的长度减1，每一趟排序找出当前的最大数，挪到对应的位置
//        for (int i = 0; i < list.size() - 1; ++i) {
//            // 判断列表list是否已经有序
//            boolean isFlag = true;
//
//            // 每一趟排序时，不断比较当前元素和下一个元素谁大，把大的元素往后挪
//            // 因为列表list的元素是数组int[]，数组的第二个元素保存的是军人数目，所以这里进行比较的元素是数组的第二个元素
//            for (int j = 0; j < list.size() - 1 - i; ++j) {
//                // 获取当前行标的军人数目
//                int before = list.get(j)[1];
//                // 获取下一行标的军人数目
//                int next = list.get(j + 1)[1];
//
//                if (before > next) {
//                    // 若当前军人数目大于下一军人数目，交换两者对应的列表list的元素
//                    int[] temp = list.get(j);
//                    list.set(j, list.get(j + 1));
//                    list.set(j + 1, temp);
//                    // 出现交换，那么列表list还不是有序
//                    isFlag = false;
//                }
//            }
//
//            if (isFlag) {
//                // 若列表list已经有序，结束循环
//                break;
//            }
//        }
//
//        // 定义结果数组nums，用来保存排序后的前k行军人数目
//        int[] nums = new int[k];
//
//        // 从0循环到k-1，构造结果数组nums
//        for (int i = 0; i < k; ++i) {
//            // 直接把排序后的列表list的行标赋值给结果数组nums
//            nums[i] = list.get(i)[0];
//        }
//
//        // 返回结果数组nums
//        return nums;
//    }

//    // 方法2，对方法1进行优化，改为使用数组保存每行的信息，通过计算换算实现一个数字保存军人数目和行标，然后直接调用系统类排序方法进行排序，大大减少运行时间，但是还是不推荐，方法3继续进行优化
//    private static int[] kWeakestRows(int[][] mat, int k) {
//        // 思路：使用数组统计每行的军人数目和行标，通过计算换算实现一个数字保存军人数目和行标，直接调用系统类排序方法进行排序，取排序后的前k个
//
//        // 定义战斗力数组res，长度为矩阵的行数
//        int[] res = new int[mat.length];
//
//        // 遍历矩阵mat的行
//        for (int i = 0; i < mat.length; ++i) {
//            // 获取矩阵mat的行
//            int[] row = mat[i];
//
//            // 定义军人数目，初始为0
//            int count = 0;
//
//            // 遍历每行的列
//            for (int col : row) {
//                if (1 == col) {
//                    // 若元素是1，那么就是军人，军人数目加1
//                    ++count;
//                }
//            }
//
//            // 军人数目 * 100 + 行号，赋值到战斗力数组res中
//            res[i] = count * 100 + i;
//        }
//
//        // 对战斗力数组res进行排序
//        Arrays.sort(res);
//
//        // 定义结果数组nums，用来保存排序后的前k行军人数目
//        int[] nums = new int[k];
//
//        // 从0循环到k-1，构造结果数组nums
//        for (int i = 0; i < k; ++i) {
//            // 战斗力数组res的元素对100取余，赋值给结果数组nums的元素
//            nums[i] = res[i] % 100;
//        }
//
//        // 返回结果数组nums
//        return nums;
//    }

    // 方法3，对方法2进行优化，在统计每行军人数目时，改为使用二分查找法，后面的相同，推荐
    private static int[] kWeakestRows(int[][] mat, int k) {
        // 思路：使用数组统计每行的军人数目和行标，统计时使用二分查找法，通过计算换算实现一个数字保存军人数目和行标，直接调用系统类排序方法进行排序，取排序后的前k个

        // 定义战斗力数组res，长度为矩阵的行数
        int[] res = new int[mat.length];

        // 遍历矩阵mat的行
        for (int i = 0; i < mat.length; ++i) {
            // 获取矩阵mat的行
            int[] row = mat[i];

            // 定义左指针，初始为0
            int left = 0;
            // 定义右指针，初始为矩阵行的最后列标
            int right = row.length - 1;
            // 定义中间指针
            int center;

            // 定义军人数目是否为0的标记
            boolean isZero = true;

            // 二分查找法，不过具体细节有点不同，不仅仅是查找等于某个值的元素，还要加上判断这个元素后面是否还有1，如果这个元素后面没有1了，那么就是找到了对应的元素，这个元素就是最后的1，它的列标加1就是这行1的个数
            while (left <= right) {
                // 计算中间指针
                center = (left + right) / 2;

                if (1 == row[center]) {
                    // 若中间指针对应的元素等于1，判断它是否为最后的1
                    if (center == row.length - 1) {
                        // 若中间指针已经是最后行标了，那么它对应的元素是最后的1
                        // 军人数目 * 100 + 行号，赋值到战斗力数组res中
                        res[i] = (center + 1) * 100 + i;
                        // 军人数目不为0，标记设置为false
                        isZero = false;
                        break;
                    }

                    if (0 == row[center + 1]) {
                        // 若中间指针下一个行标的元素是0，那么它对应的元素也是最后的1
                        // 军人数目 * 100 + 行号，赋值到战斗力数组res中
                        res[i] = (center + 1) * 100 + i;
                        // 军人数目不为0，标记设置为false
                        isZero = false;
                        break;
                    }

                    // 它不是最后的1，二分数组，向右缩小查找，中间指针加1赋值给左指针
                    left = center + 1;
                } else {
                    // 若中间指针对应的元素不等于1，直接二分数组，向左缩小查找，中间指针减1赋值给右指针
                    right = center - 1;
                }
            }

            if (isZero) {
                // 若军人数目为0，那么军人数目 * 100 + 行号 = 行号，赋值到战斗力数组res中
                res[i] = i;
            }
        }

        // 对战斗力数组res进行排序
        Arrays.sort(res);

        // 定义结果数组nums，用来保存排序后的前k行军人数目
        int[] nums = new int[k];

        // 从0循环到k-1，构造结果数组nums
        for (int i = 0; i < k; ++i) {
            // 战斗力数组res的元素对100取余，赋值给结果数组nums的元素
            nums[i] = res[i] % 100;
        }

        // 返回结果数组nums
        return nums;
    }

}
