package org.pure.algorithm.luckyNumbersInAMatrix;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-05-15 21:17
 * @description 矩阵中的幸运数
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
        List<Integer> result = luckyNumbers(matrix);
        System.out.println(result);
    }

    private static List<Integer> luckyNumbers(int[][] matrix) {
        // 定义列表list，保存幸运数列表
        List<Integer> list = new ArrayList<>();

        // 定义集合map，保存每行找到的最小元素
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历矩阵
        for (int[] ints : matrix) {
            // 定义每行最小元素
            int min = ints[0];
            // 定义每行最小元素下标
            int minIndex = 0;

            // 遍历矩阵每行的元素
            for (int j = 1; j < ints.length; ++j) {
                // 更新每行最小元素和每行最小元素下标
                if (ints[j] < min) {
                    min = ints[j];
                    minIndex = j;
                }
            }

            if (map.containsKey(minIndex)) {
                // 若集合map已保存有此下标的元素，判断元素是否为最大
                if (min > map.get(minIndex)) {
                    // 若当前元素更大，更新元素保存到集合map中
                    map.put(minIndex, min);
                }
            } else {
                // 若集合map没保存有此下标的元素，保存到集合map中
                map.put(minIndex, min);
            }
        }

        // 遍历集合map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 定义判断是否最大的标志
            boolean isMax = true;

            // 遍历矩阵
            for (int[] ints : matrix) {
                // 比较矩阵每列的元素，判断当前元素是否是此列的最大元素
                if (ints[entry.getKey()] > entry.getValue()) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                // 若当前元素是此列的最大元素，保存到列表list中
                list.add(entry.getValue());
            }
        }

        return list;
    }

}
