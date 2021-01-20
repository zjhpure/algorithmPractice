package org.pure.algorithm.romanToInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-01-21 02:34
 * @description 罗马数字转整数
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        // 获取输出结果
        int result = romanToInt(str);
        System.out.println(result);
    }

    private static int romanToInt(String s) {
        // 用map保存字符对应的数字
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // 结果
        int result = 0;

        // 罗马数字长度
        int size = s.length();

        // 遍历罗马数字字符
        for (int i = 0; i < size; ++i) {
            char c = s.charAt(i);

            // 若是否还有下一个字符
            if (i + 1 <= size - 1) {
                // 获取下一个字符
                char nextC = s.charAt(i + 1);

                // 判断是否需要跳过一个索引
                boolean isLeap = false;

                // 判断和下一个字符组合是否符合特殊规则
                switch (c) {
                    case 'I':
                        if (nextC == 'V') {
                            result += 4;
                            isLeap = true;
                        } else if (nextC == 'X') {
                            result += 9;
                            isLeap = true;
                        } else {
                            result += map.get(c);
                        }
                        break;
                    case 'X':
                        if (nextC == 'L') {
                            result += 40;
                            isLeap = true;
                        } else if (nextC == 'C') {
                            result += 90;
                            isLeap = true;
                        } else {
                            result += map.get(c);
                        }
                        break;
                    case 'C':
                        if (nextC == 'D') {
                            result += 400;
                            isLeap = true;
                        } else if (nextC == 'M') {
                            result += 900;
                            isLeap = true;
                        } else {
                            result += map.get(c);
                        }
                        break;
                    default:
                        result += map.get(c);
                }

                if (isLeap) {
                    // 需要跳过一个索引
                    ++i;
                }
            } else {
                result += map.get(c);
            }
        }

        return result;
    }

}
