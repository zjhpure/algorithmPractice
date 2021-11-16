package org.pure.algorithm.perfectRectangle;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-11-16 23:37
 * @description 完美矩形
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();
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
        int[][] matrix = new int[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<String> list = lists.get(i);
            int[] ints = new int[list.size()];
            for (int j = 0; j < list.size(); ++j) {
                ints[j] = Integer.parseInt(list.get(j));
            }
            matrix[i] = ints;
        }

        // 获取输出结果
        boolean result = isRectangleCover(matrix);
        System.out.println(result);
    }

    private static boolean isRectangleCover(int[][] rectangles) {
        // 条件1：计算小矩形面积之和，计算大矩形面积，判断小矩形面积之和是否等于大矩形面积
        // 条件2：最左下、最左上、最右下、最右上的四个点只出现一次，其他点成对出现，即只出现2次或者4次

        // 小矩形面积之和
        int sum = 0;

        // 最左下横坐标
        int minX = rectangles[0][0];
        // 最左下纵坐标
        int minY = rectangles[0][1];
        // 最右上横坐标
        int maxX = rectangles[0][2];
        // 最右上纵坐标
        int maxY = rectangles[0][3];

        // 遍历小矩形
        for (int[] rectangle : rectangles) {
            // 小矩形长度
            int length = rectangle[2] - rectangle[0];
            // 小矩形宽度
            int width = rectangle[3] - rectangle[1];

            // 累加计算小矩形面积之和
            sum += length * width;

            if (rectangle[0] <= minX && rectangle[1] <= minY) {
                // 更新最左下横坐标
                minX = rectangle[0];
                // 更新最左下纵坐标
                minY = rectangle[1];
            }

            if (rectangle[2] >= maxX && rectangle[3] >= maxY) {
                // 更新最右上横坐标
                maxX = rectangle[2];
                // 更新最右上纵坐标
                maxY = rectangle[3];
            }
        }

        // 计算大矩形面积
        int area = (maxX - minX) * (maxY - minY);

        if (sum == area) {
            // 若小矩形面积之和等于大矩形面积，判断最左下、最左上、最右下、最右上的四个点是否只出现一次

            // 最左下坐标数量
            int leftBottomCount = 0;
            // 最左上坐标数量
            int leftTopCount = 0;
            // 最右下坐标数量
            int rightBottomCount = 0;
            // 最右上坐标数量
            int rightTopCount = 0;

            // 定义集合，保存非最顶点坐标的数量
            Map<String, Integer> map = new HashMap<>();

            // 再次遍历小矩形
            for (int[] rectangle : rectangles) {
                if (rectangle[0] == minX && rectangle[1] == minY) {
                    // 最左下坐标数量加1
                    ++leftBottomCount;
                    if (leftBottomCount > 1) {
                        // 若最左下坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最左下坐标，更新集合中非最顶点坐标的数量
                    String lb = rectangle[0] + "-" + rectangle[1];
                    map.put(lb, map.getOrDefault(lb, 0) + 1);
                }

                if (rectangle[0] == minX && rectangle[3] == maxY) {
                    // 最左上坐标数量加1
                    ++leftTopCount;
                    if (leftTopCount > 1) {
                        // 若最左上坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最左上坐标，更新集合中非最顶点坐标的数量
                    String lt = rectangle[0] + "-" + rectangle[3];
                    map.put(lt, map.getOrDefault(lt, 0) + 1);
                }

                if (rectangle[2] == maxX && rectangle[1] == minY) {
                    // 最右下坐标数量加1
                    ++rightBottomCount;
                    if (rightBottomCount > 1) {
                        // 若最右下坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最右下坐标，更新集合中非最顶点坐标的数量
                    String rb = rectangle[2] + "-" + rectangle[1];
                    map.put(rb, map.getOrDefault(rb, 0) + 1);
                }

                if (rectangle[2] == maxX && rectangle[3] == maxY) {
                    // 最右上坐标数量加1
                    ++rightTopCount;
                    if (rightTopCount > 1) {
                        // 若最右上坐标数量大于1，直接返回false
                        return false;
                    }
                } else {
                    // 若不是最右上坐标，更新集合中非最顶点坐标的数量
                    String rt = rectangle[2] + "-" + rectangle[3];
                    map.put(rt, map.getOrDefault(rt, 0) + 1);
                }
            }

            // 遍历集合，判断非最顶点坐标的数量是否都是成对出现，即数量是否都为2或4
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 2 && entry.getValue() != 4) {
                    // 若有非最顶点坐标的数量不等于2或4，返回false
                    return false;
                }
            }

            // 若最左下、最左上、最右下、最右上的四个点只出现一次，返回true
            return leftBottomCount == 1 && leftTopCount == 1 && rightBottomCount == 1 && rightTopCount == 1;
        }

        // 若小矩形面积之和不等于大矩形面积，直接返回false
        return false;
    }

}
