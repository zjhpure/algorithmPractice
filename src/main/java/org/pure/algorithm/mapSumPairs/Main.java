package org.pure.algorithm.mapSumPairs;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021-11-14 14:44
 * @description 键值映射
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        // 处理输入结果
        String[] strings = str1.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] methods = new String[size];
        for (int i = 0; i < size; ++i) {
            methods[i] = strings[i].split("\"")[1];
        }

        // 处理输入结果
        String newStr = str2.substring(1, str2.length() - 1);
        String[] strs = newStr.split(",\\[");
        int length = strs.length;
        String[][] contents = new String[length][];
        for (int i = 0; i < length; ++i) {
            String[] content = new String[0];
            String str = strs[i];
            if (!"[]".equals(str)) {
                if (str.contains(",")) {
                    String[] mapStr = str.split(",");
                    content = new String[2];
                    content[0] = mapStr[0].split("\"")[1];
                    content[1] = mapStr[1].split("]")[0];
                } else {
                    content = new String[1];
                    content[0] = str.split("\"")[1];
                }
            }
            contents[i] = content;
        }

        System.out.println("methods:" + Arrays.toString(methods));
        System.out.println("contents:" + Arrays.deepToString(contents));

        // 获取输出结果
        Integer[] result = run(methods, contents);
        System.out.println(Arrays.toString(result));
    }

    private static Integer[] run(String[] methods, String[][] contents) {
        MapSum obj = new MapSum();

        Integer[] result = new Integer[methods.length];

        result[0] = null;

        for (int i = 1; i < methods.length; ++i) {
            String method = methods[i];
            String[] content = contents[i];

//            System.out.println("method:" + method);
//            System.out.println("content:" + Arrays.toString(content));

            if ("insert".equals(method)) {
                obj.insert(content[0], Integer.parseInt(content[1]));
                result[i] = null;
            } else {
                result[i] = obj.sum(content[0]);
            }
        }

        return result;
    }

}

class MapSum {
    // 暴力法

    // 定义map集合
    private Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    MapSum() {
        // map初始化
        map = new HashMap<>();
    }

    void insert(String key, int val) {
        // 直接保存到map集合中
        map.put(key, val);
    }

    public int sum(String prefix) {
        // 定义前缀总和
        int sum = 0;

        // 遍历map集合的键
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                // 若键以prefix开头，那么累加键对应的值到前缀总和中
                sum += map.get(key);
            }
        }

        // 返回前缀总和
        return sum;
    }
}

/*
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
