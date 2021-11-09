package org.pure.algorithm.bullsAndCows;

import java.util.*;

/**
 * @author zhangjianhua
 * @date 2021/11/8 7:36
 * @description 猜数字游戏
 */
public class Main {

    public static void main(String[] args) {
        // 获取输入结果
        Scanner scanner = new Scanner(System.in);
        String secret = scanner.nextLine();
        String guess = scanner.nextLine();
        scanner.close();

        // 获取输出结果
        String result = getHint(secret, guess);
        System.out.println(result);
    }

    private static String getHint(String secret, String guess) {
        // 模拟法

        // 定义公牛个数
        int bullsCount = 0;

        // 定义奶牛个数
        int cowsCount = 0;

        // 定义除去公牛元素的秘密数字列表
        List<Character> secretList = new ArrayList<>();

        // 定义除去公牛元素的猜测数字列表
        List<Character> guessList = new ArrayList<>();

        // 遍历猜测数字，找出公牛元素，记录除去公牛元素的秘密数字列表和猜测数字列表
        for (int i = 0; i < guess.length(); ++i) {
            if (guess.charAt(i) == secret.charAt(i)) {
                // 若数字和位置都猜对，记录为公牛，公牛个数加1
                ++bullsCount;
            } else {
                // 除去公牛元素的秘密数字列表添加元素
                secretList.add(secret.charAt(i));
                // 除去公牛元素的猜测数字列表添加元素
                guessList.add(guess.charAt(i));
            }
        }

        // 定义哈希集合，保存奶牛位置
        Set<Integer> set = new HashSet<>();

        // 遍历除去公牛元素的猜测数字列表
        for (char c : guessList) {
            // 遍历除去公牛元素的秘密数字列表
            for (int i = 0; i < secretList.size(); ++i) {
                // 若猜测数字在秘密数字中存在，并且之前没有被挑选过，那么符合奶牛条件
                if (!set.contains(i) && c == secretList.get(i)) {
                    // 数字猜对，位置不对，记录为奶牛，奶牛个数加1
                    ++cowsCount;
                    // 哈希集合记录秘密数字中的奶牛位置
                    set.add(i);
                    break;
                }
            }
        }

        // 返回结果，公牛个数加A，再加奶牛个数加B
        return bullsCount + "A" + cowsCount + "B";
    }

}
