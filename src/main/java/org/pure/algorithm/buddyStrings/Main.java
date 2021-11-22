package org.pure.algorithm.buddyStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-11-23 01:07
 * @description 亲密字符串
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        boolean result = buddyStrings(a, b);
        System.out.println(result);
    }

    private static boolean buddyStrings(String a, String b) {
        // 枚举法，三种情况，注意审题，是只交换两个字母一次，不是交换两个字母多次，而且必须要交换，不能不进行交换

        if (a.length() != b.length()) {
            // 情况1：若两个字符串的长度不同，无论怎么交换两个字符都不可能相等，直接返回false
            return false;
        }

        if (a.equals(b)) {
            // 情况2：若两个字符串相等，只要字符串存在重复字符，那么就能在交换字符后还是两个字符串相等

            // 定义集合，统计字符串a每种字符的数量
            Map<Character, Integer> map = new HashMap<>();

            // 遍历字符串a的字符，统计每种字符的数量
            for (int i = 0; i < a.length(); ++i) {
                map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
            }

            // 遍历集合
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    // 若有一种字符的数量大于等于2，那么存在重复字符，可以交换这两个字符后是的两个字符串依然相等，返回true
                    return true;
                }
            }

            // 若没有有一种字符的数量大于等于2，那么不存在重复字符，那么交换两个字符后必定导致两个字符串不相等，返回false
            return false;
        } else {
            // 情况3：若两个字符串不相等，判断字符串a是否和字符串b只有两处字符不同，并且这两处字符是否交换后相等

            // 统计不同字符的数量
            int count = 0;
            // 定义第一个不同字符的下标
            int first = -1;
            // 定义第二个不同字符的下标
            int second = -1;

            // 遍历字符串a的字符
            for (int i = 0; i < a.length(); ++i) {
                if (a.charAt(i) != b.charAt(i)) {
                    // 若字符串a和字符串b相同下标的字符不等，不同字符的数量加1
                    ++count;

                    if (count == 1) {
                        // 获得第一个不同字符的下标
                        first = i;
                    } else if (count == 2) {
                        // 获得第二个不同字符的下标
                        second = i;
                    } else {
                        // 若有第三个不同字符，直接返回false
                        return false;
                    }
                }
            }

            // 最后判断交换两个不同字符的下标在两个字符串中交叉比较对应的值是否相等，若相等返回true，否则返回false
            return first != -1 && second != -1 && a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
        }
    }

}
