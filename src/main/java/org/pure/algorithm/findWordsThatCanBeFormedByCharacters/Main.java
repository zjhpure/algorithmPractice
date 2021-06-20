package org.pure.algorithm.findWordsThatCanBeFormedByCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhangjianhua
 * @date 2021-06-20 16:51
 * @description 拼写单词
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String chars = scanner.next();
        scanner.close();

        // 处理输入结果
        String[] strings = str.split("\\[")[1].split("]")[0].split(",");
        int size = strings.length;
        String[] words = new String[size];
        for (int i = 0; i < size; ++i) {
            words[i] = strings[i].split("\"")[1];
        }

        // 获取输出结果
        int result = countCharacters(words, chars);
        System.out.println(result);
    }

    private static int countCharacters(String[] words, String chars) {
        // 定义长度之和
        int count = 0;

        // 定义集合map，保存字符串chars每个字符的数量
        Map<Character, Integer> map = new HashMap<>();

        // 遍历字符串chars的每个字符，统计每个字符的数量
        for (int i = 0; i < chars.length(); ++i) {
            char c = chars.charAt(i);

            if (map.containsKey(c)) {
                // 若集合map中存在此字符，数量加1
                map.put(c, map.get(c) + 1);
            } else {
                // 若集合map中没有此字符，保存为数量1
                map.put(c, 1);
            }
        }

        // 遍历字符串数组words
        for (String word : words) {
            // 定义是否掌握这个单词的标识
            boolean isFind = true;

            // 定义集合mapTemp，每次判断是否掌握单词时，先把原来构建好的集合map赋值进来，因为每次判断是否掌握单词都要重复再使用集合map
            Map<Character, Integer> mapTemp = new HashMap<>(map);

            // 遍历字符串word的字符
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);

                if (mapTemp.containsKey(ch) && mapTemp.get(ch) > 0) {
                    // 若集合mapTemp存在这个字符，并且这个字符的数量大于0，那么字符够用，继续遍历，数量减1
                    mapTemp.put(ch, mapTemp.get(ch) - 1);
                } else {
                    // 若集合mapTemp不存在这个字符，或者这个字符的数量为0，那么字符不够用，结束遍历，标记这个单词不掌握
                    isFind = false;
                    break;
                }
            }

            if (isFind) {
                // 若这个单词已掌握，那么长度之和count加上字符串word的长度
                count += word.length();
            }
        }

        return count;
    }

}
